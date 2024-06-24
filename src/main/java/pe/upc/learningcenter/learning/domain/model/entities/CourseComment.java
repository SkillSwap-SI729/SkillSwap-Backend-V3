package pe.upc.learningcenter.learning.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import pe.upc.learningcenter.learning.domain.model.aggregates.Course;
import pe.upc.learningcenter.learning.domain.model.aggregates.Instructor;
import pe.upc.learningcenter.rating.domain.model.valueObjects.CourseId;
import pe.upc.learningcenter.shared.domain.model.aggregate.AuditableAbstractAggregateRoot;

@Getter
@Entity
public class CourseComment extends AuditableAbstractAggregateRoot<CourseComment> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String content;
    @NotNull
    private Number rating;
    @NotBlank
    private String timeAgo;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;


    private String profilePhotoUrl;
    private String username;

    public CourseComment() {

    }

    public CourseComment(String content,Number rating,
                            String timeAgo,Course course, String profilePhotoUrl,
                         String username) {

        this.content = content;
        this.rating = rating;
        this.timeAgo = timeAgo;
        this.course = course;
        this.profilePhotoUrl = profilePhotoUrl;
        this.username = username;
    }


}
