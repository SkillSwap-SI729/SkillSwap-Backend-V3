package pe.upc.learningcenter.learning.domain.services;

import pe.upc.learningcenter.learning.domain.model.commands.CreateLearningPathItemCommand;
import pe.upc.learningcenter.learning.domain.model.entities.LearningPathItem;

import java.util.Optional;

public interface LearningPathItemCommandService {
    Optional<LearningPathItem> handle(CreateLearningPathItemCommand command);
}
