package pe.upc.learningcenter.learning.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.upc.learningcenter.learning.domain.model.commands.CreateLearningPathItemCommand;
import pe.upc.learningcenter.learning.domain.model.entities.LearningPathItem;
import pe.upc.learningcenter.learning.domain.services.LearningPathItemCommandService;
import pe.upc.learningcenter.learning.infrastructure.persistence.jpa.repositories.CourseRepository;
import pe.upc.learningcenter.learning.infrastructure.persistence.jpa.repositories.LearningPathItemRepository;

import java.util.Optional;

@Service
public class LearningPathItemCommandServiceImpl implements
        LearningPathItemCommandService {
    private final LearningPathItemRepository learningPathItemRepository;
    private final CourseRepository courseRepository;

    public LearningPathItemCommandServiceImpl(LearningPathItemRepository learningPathItemRepository, CourseRepository courseRepository) {
        this.learningPathItemRepository = learningPathItemRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public Optional<LearningPathItem> handle(CreateLearningPathItemCommand command) {
        if (!courseRepository.existsById(command.courseId()))
            throw new RuntimeException("Course does not exist");

        var course = courseRepository.findById(command.courseId());

        var learningPathItem = new LearningPathItem(command.name(),command.nLessons(),
                command.time(),course.get());

        learningPathItemRepository.save(learningPathItem);

        return Optional.of(learningPathItem);
    }
}
