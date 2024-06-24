package pe.upc.learningcenter.learning.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upc.learningcenter.learning.domain.model.entities.CourseComment;

@Repository
public interface CourseCommentRepository extends JpaRepository<CourseComment, Long> {
}
