package pe.upc.learningcenter.learning.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.upc.learningcenter.learning.domain.model.aggregates.Student;
import pe.upc.learningcenter.learning.domain.model.queries.GetStudentByIdQuery;
import pe.upc.learningcenter.learning.domain.services.StudentQueryService;
import pe.upc.learningcenter.learning.infrastructure.persistence.jpa.repositories.StudentRepository;


import java.util.Optional;

@Service
public class StudentQueryServiceImpl implements StudentQueryService {

    private final StudentRepository studentRepository;

    public StudentQueryServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Optional<Student> handle(GetStudentByIdQuery query) {
        return studentRepository.findById(query.id());
    }
}
