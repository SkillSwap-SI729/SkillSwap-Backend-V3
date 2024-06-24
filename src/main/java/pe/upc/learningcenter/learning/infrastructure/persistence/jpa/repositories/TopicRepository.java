package pe.upc.learningcenter.learning.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upc.learningcenter.learning.domain.model.entities.Topic;

import java.util.Optional;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    boolean existsByName(String name);
    Optional<Topic> findByName(String name);
}
