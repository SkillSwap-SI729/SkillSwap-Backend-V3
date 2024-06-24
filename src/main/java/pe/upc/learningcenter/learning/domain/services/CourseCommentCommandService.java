package pe.upc.learningcenter.learning.domain.services;

import pe.upc.learningcenter.learning.domain.model.aggregates.Course;
import pe.upc.learningcenter.learning.domain.model.commands.CreateCourseCommand;
import pe.upc.learningcenter.learning.domain.model.commands.CreateCourseCommentCommand;
import pe.upc.learningcenter.learning.domain.model.entities.CourseComment;

import java.util.Optional;

public interface CourseCommentCommandService {
    Optional<CourseComment> handle(CreateCourseCommentCommand command);
}
