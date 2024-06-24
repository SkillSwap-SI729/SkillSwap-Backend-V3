package pe.upc.learningcenter.learning.interfaces.rest.transform;

import pe.upc.learningcenter.learning.domain.model.commands.CreateLessonCommand;
import pe.upc.learningcenter.learning.interfaces.rest.resources.CreateLessonResource;

public class CreateLessonCommandFromResourceAssembler {
    public static CreateLessonCommand toCommandFromResource(CreateLessonResource resource) {
        return new CreateLessonCommand(resource.name(), resource.duration(),
                resource.learningPathItemId());
    }
}
