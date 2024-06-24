package pe.upc.learningcenter.learning.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upc.learningcenter.learning.domain.model.aggregates.Course;
import pe.upc.learningcenter.learning.domain.model.aggregates.Student;
import pe.upc.learningcenter.learning.domain.model.valueobjects.ProfileId;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    boolean existsByName(String name);
    Optional<Course> findByName(String name);
}