package pe.upc.learningcenter.learning.domain.services;

import pe.upc.learningcenter.learning.domain.model.aggregates.Course;
import pe.upc.learningcenter.learning.domain.model.aggregates.Student;
import pe.upc.learningcenter.learning.domain.model.commands.CreateCourseCommand;

import java.util.Optional;

public interface CourseCommandService {
    Optional<Course> handle(CreateCourseCommand command);
}
