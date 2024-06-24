package pe.upc.learningcenter.learning.domain.services;

import pe.upc.learningcenter.learning.domain.model.aggregates.Instructor;
import pe.upc.learningcenter.learning.domain.model.queries.GetInstructorByIdQuery;
import pe.upc.learningcenter.learning.domain.model.queries.GetInstructorByProfileIdQuery;

import java.util.List;
import java.util.Optional;

public interface InstructorQueryService {
    List<Instructor> handle();
    Optional<Instructor> handle(GetInstructorByProfileIdQuery query);
    Optional<Instructor> handle(GetInstructorByIdQuery query);
}