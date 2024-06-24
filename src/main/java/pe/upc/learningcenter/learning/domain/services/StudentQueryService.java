package pe.upc.learningcenter.learning.domain.services;

import pe.upc.learningcenter.learning.domain.model.aggregates.Student;
import pe.upc.learningcenter.learning.domain.model.queries.GetStudentByIdQuery;

import java.util.Optional;

public interface StudentQueryService {
    Optional<Student> handle(GetStudentByIdQuery query);
}
