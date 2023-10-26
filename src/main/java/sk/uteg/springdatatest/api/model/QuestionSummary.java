package sk.uteg.springdatatest.api.model;

import lombok.Data;
import sk.uteg.springdatatest.db.model.QuestionType;

import java.math.BigDecimal;
import java.util.List;

@Data
public class QuestionSummary {
    private String name;
    private QuestionType type;

    // will be ZERO for type == CHOICE
    private BigDecimal ratingAverage;

    // will be empty for type == RATING
    private List<OptionSummary> optionSummaries;
}
