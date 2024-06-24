package pe.upc.learningcenter.learning.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.upc.learningcenter.learning.domain.model.entities.LearningPathItem;
import pe.upc.learningcenter.learning.domain.model.queries.GetLearningPathItemByIdQuery;
import pe.upc.learningcenter.learning.domain.services.LearningPathItemQueryService;
import pe.upc.learningcenter.learning.infrastructure.persistence.jpa.repositories.LearningPathItemRepository;

import java.util.Optional;

@Service
public class LearningPathItemQueryServiceImpl implements LearningPathItemQueryService {
    private final LearningPathItemRepository learningPathItemRepository;

    public LearningPathItemQueryServiceImpl(LearningPathItemRepository learningPathItemRepository) {
        this.learningPathItemRepository = learningPathItemRepository;
    }

    @Override
    public Optional<LearningPathItem> handle(GetLearningPathItemByIdQuery query) {
        return learningPathItemRepository.findById(query.id());
    }
}
