package pe.upc.learningcenter.learning.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import pe.upc.learningcenter.learning.domain.model.aggregates.Course;
import pe.upc.learningcenter.shared.domain.model.entities.AuditableModel;

import java.util.ArrayList;
import java.util.List;


@Getter
@Entity
public class LearningPathItem extends AuditableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private Number nLessons;
    @NotBlank
    private String time;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @NotNull
    private Course course;

    @OneToMany(mappedBy = "learningPathItem", cascade = CascadeType.ALL)
    private List<Lesson> lessons;

    public LearningPathItem() {
        this.lessons = new ArrayList<>();
    }

    public LearningPathItem(String name,Number nLessons,
            String time,Course course) {
        this();
        this.name = name;
        this.nLessons = nLessons;
        this.time = time;
        this.course = course;
    }


   /* @ManyToOne
    @JoinColumn(name = "next_item_id")
    private LearningPathItem nextItem;*/

}
