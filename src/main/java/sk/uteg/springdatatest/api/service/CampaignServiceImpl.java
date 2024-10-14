package sk.uteg.springdatatest.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.uteg.springdatatest.api.exception.NotFoundException;
import sk.uteg.springdatatest.api.model.CampaignSummary;
import sk.uteg.springdatatest.api.model.OptionSummary;
import sk.uteg.springdatatest.api.model.QuestionSummary;
import sk.uteg.springdatatest.db.model.*;
import sk.uteg.springdatatest.db.repository.AnswerRepository;
import sk.uteg.springdatatest.db.repository.CampaignRepository;
import sk.uteg.springdatatest.db.repository.FeedbackRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@Service
public class CampaignServiceImpl implements CampaignService {

    private final CampaignRepository campaignRepository;
    private final FeedbackRepository feedbackRepository;
    private final AnswerRepository answerRepository;

    @Autowired
    public CampaignServiceImpl(
            CampaignRepository campaignRepository,
            FeedbackRepository feedbackRepository,
            AnswerRepository answerRepository
    ) {
        this.campaignRepository = campaignRepository;
        this.answerRepository = answerRepository;
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public CampaignSummary getCampaignSummary(UUID campaignId) throws NotFoundException {
        Optional<Campaign> campaignOptional = this.campaignRepository.findById(campaignId);
        Campaign campaign = campaignOptional.orElseThrow(() -> new NotFoundException("Campaign not found"));

        CampaignSummary campaignSummary = new CampaignSummary();
        campaignSummary.setQuestionSummaries(new ArrayList<>());

        List<Feedback> feedbacks = this.feedbackRepository.findByCampaignId(campaign.getId());
        campaignSummary.setTotalFeedbacks(feedbacks.size());

        for (Question question : campaign.getQuestions()) {
            QuestionSummary questionSummary = new QuestionSummary();
            questionSummary.setName(question.getText());
            questionSummary.setType(question.getType());
            questionSummary.setOptionSummaries(new ArrayList<>());

            if (question.getType() == QuestionType.RATING) {
                BigDecimal ratingAvg = processRating(question);
                questionSummary.setRatingAverage(ratingAvg);
            }

            if (question.getType() == QuestionType.CHOICE) {
                List<OptionSummary> optionSummaries = processChoice(question);
                questionSummary.setOptionSummaries(optionSummaries);
                questionSummary.setRatingAverage(BigDecimal.ZERO);
            }

            campaignSummary.getQuestionSummaries().add(questionSummary);
        }

        return campaignSummary;
    }

    private BigDecimal processRating(Question question) {
        List<Answer> questionAnswers = this.answerRepository.findByQuestionId(question.getId());
        if (questionAnswers.isEmpty()) return BigDecimal.ZERO;

        BigDecimal ratingSum = questionAnswers.stream()
                .map(answer -> BigDecimal.valueOf(answer.getRatingValue()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (ratingSum.equals(BigDecimal.ZERO)) return BigDecimal.ZERO;
        return ratingSum.divide(BigDecimal.valueOf(questionAnswers.size()), 2, RoundingMode.HALF_UP);
    }

    private List<OptionSummary> processChoice(Question question) {
        List<Answer> questionAnswers = this.answerRepository.findByQuestionId(question.getId());
        List<Option> questionOptions = question.getOptions();

        Map<UUID, Integer> optionsMap = new HashMap<>();
        for (Option option : questionOptions) {
            optionsMap.put(option.getId(), 0);
        }

        for (Answer answer : questionAnswers) {
            List<Option> answerOptions = answer.getSelectedOptions();
            for (Option option : answerOptions) {
                if (optionsMap.containsKey(option.getId())) {
                    optionsMap.put(option.getId(), optionsMap.get(option.getId()) + 1);
                }
            }
        }

        List<OptionSummary> optionSummaries = new ArrayList<>();
        for (Option option : questionOptions) {
            if (optionsMap.containsKey(option.getId())) {
                OptionSummary optionSummary = new OptionSummary();
                optionSummary.setText(option.getText());
                optionSummary.setOccurrences(optionsMap.get(option.getId()));
                optionSummaries.add(optionSummary);
            }
        }

        return optionSummaries;
    }
}
