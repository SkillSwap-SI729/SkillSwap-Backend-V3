package pe.upc.learningcenter.learning.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import pe.upc.learningcenter.learning.domain.model.aggregates.Course;
import pe.upc.learningcenter.learning.domain.model.valueobjects.TutorialId;
import pe.upc.learningcenter.shared.domain.model.entities.AuditableModel;

@Entity
public class LearningPathItem extends AuditableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @NotNull
    private Course course;

    @ManyToOne
    @JoinColumn(name = "next_item_id")
    private LearningPathItem nextItem;

    private Long tutorialId;

}
