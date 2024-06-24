package pe.upc.learningcenter.learning.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import pe.upc.learningcenter.shared.domain.model.entities.AuditableModel;

@Getter
@Entity
public class Lesson extends AuditableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private Number duration;

    @ManyToOne
    @JoinColumn(name = "learning_path_item_id")
    @NotNull
    private LearningPathItem learningPathItem;


    public Lesson(String name,Number duration,
                            LearningPathItem learningPathItem) {
        this.name = name;
        this.duration = duration;
        this.learningPathItem = learningPathItem;
    }

    public Lesson() {

    }


   /* @ManyToOne
    @JoinColumn(name = "next_item_id")
    private LearningPathItem nextItem;*/

}