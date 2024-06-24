package pe.upc.learningcenter.learning.application.internal.commandservices;


import org.springframework.stereotype.Service;
import pe.upc.learningcenter.learning.domain.model.aggregates.Course;
import pe.upc.learningcenter.learning.domain.model.commands.CreateCourseCommand;
import pe.upc.learningcenter.learning.domain.model.entities.Topic;
import pe.upc.learningcenter.learning.domain.services.CourseCommandService;
import pe.upc.learningcenter.learning.infrastructure.persistence.jpa.repositories.CourseRepository;
import pe.upc.learningcenter.learning.infrastructure.persistence.jpa.repositories.InstructorRepository;
import pe.upc.learningcenter.learning.infrastructure.persistence.jpa.repositories.TopicRepository;


import java.util.Optional;

@Service
public class CourseCommandServiceImpl implements CourseCommandService {
    private final CourseRepository courseRepository;
    private final TopicRepository topicRepository;
    private final InstructorRepository instructorRepository;

    public CourseCommandServiceImpl(CourseRepository courseRepository, TopicRepository topicRepository,
                                    InstructorRepository instructorRepository) {
        this.courseRepository = courseRepository;
        this.topicRepository = topicRepository;
        this.instructorRepository = instructorRepository;
    }

    @Override
    public Optional<Course> handle(CreateCourseCommand command) {
        if (courseRepository.existsByName(command.name()))
            throw new RuntimeException("Course name already exists");

        if (!instructorRepository.existsById(command.instructorId()))
            throw new RuntimeException("Instructor not found");

        if (!topicRepository.existsByName(command.topicName()))
        {
            var topic = new Topic(command.topicName());
            topicRepository.save(topic);
        }

        var instructor = instructorRepository.findById(command.instructorId());
        var topic = topicRepository.findByName(command.topicName());

        var course = new Course(command.name(), command.photoUrl(), command.description(),
                command.cost(), command.rating(), command.nRatings(),
                command.nStudents(), command.nHours(), topic.get(), instructor.get());

        courseRepository.save(course);

        return courseRepository.findByName(command.name());
    }
}
