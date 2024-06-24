package pe.upc.learningcenter.learning.interfaces.rest.transform;

import pe.upc.learningcenter.learning.domain.model.commands.CreateLearningPathItemCommand;
import pe.upc.learningcenter.learning.interfaces.rest.resources.CreateLearningPathItemResource;

public class CreateLearningPathItemCommandFromResourceAssembler {
    public static CreateLearningPathItemCommand toCommandFromResource(CreateLearningPathItemResource resource) {
        return new CreateLearningPathItemCommand(resource.name(), resource.nLessons(),
                resource.time(),
                resource.courseId());
    }
}
