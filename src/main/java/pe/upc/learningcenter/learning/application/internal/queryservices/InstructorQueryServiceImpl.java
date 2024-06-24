package pe.upc.learningcenter.learning.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.upc.learningcenter.learning.domain.model.aggregates.Instructor;
import pe.upc.learningcenter.learning.domain.model.queries.GetInstructorByIdQuery;
import pe.upc.learningcenter.learning.domain.model.queries.GetInstructorByProfileIdQuery;
import pe.upc.learningcenter.learning.domain.services.InstructorQueryService;
import pe.upc.learningcenter.learning.infrastructure.persistence.jpa.repositories.InstructorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorQueryServiceImpl implements InstructorQueryService {
    private final InstructorRepository instructorRepository;

    public InstructorQueryServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructor> handle() {
        return instructorRepository.findAll();
    }

    @Override
    public Optional<Instructor> handle(GetInstructorByProfileIdQuery query) {
        return instructorRepository.findByProfileId(query.profileId());
    }

    @Override
    public Optional<Instructor> handle(GetInstructorByIdQuery query) {
        return instructorRepository.findById(query.id());
    }
}
