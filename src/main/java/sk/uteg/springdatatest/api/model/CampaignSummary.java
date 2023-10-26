package sk.uteg.springdatatest.api.model;

import lombok.Data;

import java.util.List;

@Data
public class CampaignSummary {
    private long totalFeedbacks;
    private List<QuestionSummary> questionSummaries;
}
