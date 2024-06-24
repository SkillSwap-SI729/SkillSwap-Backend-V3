package pe.upc.learningcenter.learning.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.upc.learningcenter.learning.domain.model.aggregates.Course;
import pe.upc.learningcenter.learning.domain.model.aggregates.Student;
import pe.upc.learningcenter.learning.domain.model.queries.GetCourseByIdQuery;
import pe.upc.learningcenter.learning.domain.model.queries.GetStudentByIdQuery;
import pe.upc.learningcenter.learning.domain.services.CourseQueryService;
import pe.upc.learningcenter.learning.infrastructure.persistence.jpa.repositories.CourseRepository;
import pe.upc.learningcenter.learning.infrastructure.persistence.jpa.repositories.StudentRepository;

import java.util.Optional;

@Service
public class CourseQueryServiceImpl implements CourseQueryService {

    private final CourseRepository courseRepository;

    public CourseQueryServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Optional<Course> handle(GetCourseByIdQuery query) {
        return courseRepository.findById(query.id());
    }
}
