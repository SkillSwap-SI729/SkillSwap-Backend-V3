package pe.upc.learningcenter.learning.domain.model.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;
import pe.upc.learningcenter.learning.domain.model.entities.CourseComment;
import pe.upc.learningcenter.learning.domain.model.entities.Topic;
import pe.upc.learningcenter.learning.domain.model.valueobjects.LearningPath;
import pe.upc.learningcenter.shared.domain.model.aggregate.AuditableAbstractAggregateRoot;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Course extends AuditableAbstractAggregateRoot<Course> {

    @NotBlank
    private String name;
    @NotBlank
    private String photoUrl;
    @NotBlank
    private String description;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @NotNull
    private Number cost;
    @NotNull
    private Number rating;
    @NotNull
    private Number nRatings;
    @NotNull
    private Number nStudents;
    @NotNull
    private Number nHours;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;


    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<CourseComment> courseComments;

    @Embedded
    private final LearningPath learningPath;


    public Course() {
        this.name = Strings.EMPTY;
        this.photoUrl = Strings.EMPTY;
        this.description = Strings.EMPTY;
        this.cost = 0.00;
        this.rating = 0;
        this.nRatings = 0;
        this.nStudents = 0;
        this.nHours = 0;
        this.learningPath = new LearningPath();
        this.courseComments = new ArrayList<>();
    }
    public Course(String name,
                  String photoUrl, String description,
                  Number cost, Number rating, Number nRatings,
                  Number nStudents, Number nHours, Topic topic, Instructor instructor) {
        this();
        this.name = name;
        this.photoUrl = photoUrl;
        this.description = description;
        this.cost = cost;
        this.rating = rating;
        this.nRatings = nRatings;
        this.nStudents = nStudents;
        this.nHours = nHours;
        this.topic = topic;
        this.instructor = instructor;
    }
}
