package pe.upc.learningcenter.learning.domain.services;

import pe.upc.learningcenter.learning.domain.model.aggregates.Instructor;
import pe.upc.learningcenter.learning.domain.model.aggregates.Student;
import pe.upc.learningcenter.learning.domain.model.commands.CreateInstructorCommand;
import pe.upc.learningcenter.learning.domain.model.commands.CreateStudentCommand;

import java.util.Optional;

public interface InstructorCommandService {
    Optional<Instructor> handle(CreateInstructorCommand command);
}
