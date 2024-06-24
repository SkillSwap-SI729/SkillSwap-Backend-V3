package pe.upc.learningcenter.learning.domain.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import pe.upc.learningcenter.learning.domain.model.aggregates.Course;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String name;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private List<Course> courses;

    public Topic(String name) {
        this.name = name;
    }



}