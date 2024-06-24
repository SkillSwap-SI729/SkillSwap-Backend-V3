package pe.upc.learningcenter.learning.domain.services;

import pe.upc.learningcenter.learning.domain.model.aggregates.Course;
import pe.upc.learningcenter.learning.domain.model.aggregates.Student;
import pe.upc.learningcenter.learning.domain.model.queries.GetCourseByIdQuery;
import pe.upc.learningcenter.learning.domain.model.queries.GetStudentByIdQuery;

import java.util.Optional;

public interface CourseQueryService {
    Optional<Course> handle(GetCourseByIdQuery query);
}
