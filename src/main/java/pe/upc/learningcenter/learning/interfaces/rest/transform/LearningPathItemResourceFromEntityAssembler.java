package pe.upc.learningcenter.learning.interfaces.rest.transform;

import pe.upc.learningcenter.learning.domain.model.entities.LearningPathItem;
import pe.upc.learningcenter.learning.interfaces.rest.resources.LearningPathItemResource;

public class LearningPathItemResourceFromEntityAssembler {
    public static LearningPathItemResource toResourceFromEntity(LearningPathItem entity) {
        return new LearningPathItemResource(entity.getId(), entity.getName(),
                entity.getTime(),
                entity.getCourse().getId(),entity.getNLessons(),
                LessonResourceFromEntityAssembler.toResourcesFromEntities(entity.getLessons()));
    }
}
