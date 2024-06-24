package pe.upc.learningcenter.learning.domain.services;

import pe.upc.learningcenter.learning.domain.model.entities.LearningPathItem;
import pe.upc.learningcenter.learning.domain.model.queries.GetLearningPathItemByIdQuery;

import java.util.Optional;

public interface LearningPathItemQueryService {
    Optional<LearningPathItem> handle(GetLearningPathItemByIdQuery query);
}
