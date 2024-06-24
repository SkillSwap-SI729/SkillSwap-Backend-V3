package pe.upc.learningcenter.learning.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upc.learningcenter.learning.domain.model.entities.Lesson;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
