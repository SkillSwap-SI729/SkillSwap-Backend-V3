package pe.upc.learningcenter.learning.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.upc.learningcenter.learning.domain.model.commands.CreateLessonCommand;
import pe.upc.learningcenter.learning.domain.model.entities.Lesson;
import pe.upc.learningcenter.learning.domain.services.LessonCommandService;
import pe.upc.learningcenter.learning.infrastructure.persistence.jpa.repositories.LearningPathItemRepository;
import pe.upc.learningcenter.learning.infrastructure.persistence.jpa.repositories.LessonRepository;

import java.util.Optional;

@Service
public class LessonCommandServiceImpl implements LessonCommandService {
    private final LessonRepository lessonRepository;
    private final LearningPathItemRepository learningPathItemRepository;

    public LessonCommandServiceImpl(LessonRepository lessonRepository, LearningPathItemRepository learningPathItemRepository) {
        this.lessonRepository = lessonRepository;
        this.learningPathItemRepository = learningPathItemRepository;
    }

    @Override
    public Optional<Lesson> handle(CreateLessonCommand command) {
        if (!learningPathItemRepository.existsById(command.learningPathItemId()))
            throw new RuntimeException("LearningPathItem not found");

        var learningPathItem = learningPathItemRepository.findById(command.learningPathItemId());

        var lesson = new Lesson(command.name(), command.duration(), learningPathItem.get());

        return Optional.of(lessonRepository.save(lesson));
    }
}
