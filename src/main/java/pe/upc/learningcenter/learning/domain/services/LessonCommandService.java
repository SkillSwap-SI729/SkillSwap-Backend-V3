package pe.upc.learningcenter.learning.domain.services;

import pe.upc.learningcenter.learning.domain.model.aggregates.Course;
import pe.upc.learningcenter.learning.domain.model.commands.CreateCourseCommand;
import pe.upc.learningcenter.learning.domain.model.commands.CreateLessonCommand;
import pe.upc.learningcenter.learning.domain.model.entities.Lesson;

import java.util.Optional;

public interface LessonCommandService {
    Optional<Lesson> handle(CreateLessonCommand command);
}
