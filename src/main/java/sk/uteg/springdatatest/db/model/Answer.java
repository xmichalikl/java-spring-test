package sk.uteg.springdatatest.db.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(optional = false)
    private Feedback feedback;

    @ManyToOne(optional = false)
    @JsonBackReference
    private Question question;

    private int ratingValue;

    @ManyToMany
    @JoinTable(name = "answer_selected_option",
            joinColumns = @JoinColumn(name = "answer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "option_id", referencedColumnName = "id")
    )
    private List<Option> selectedOptions;
}
