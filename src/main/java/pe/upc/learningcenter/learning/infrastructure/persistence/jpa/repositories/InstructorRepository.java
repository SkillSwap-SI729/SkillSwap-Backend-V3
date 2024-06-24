package pe.upc.learningcenter.learning.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upc.learningcenter.learning.domain.model.aggregates.Instructor;
import pe.upc.learningcenter.learning.domain.model.valueobjects.ProfileId;

import java.util.Optional;
@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    Optional<Instructor> findByProfileId(ProfileId userId);
}
