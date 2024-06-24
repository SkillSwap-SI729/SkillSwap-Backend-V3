package pe.upc.learningcenter.learning.interfaces.rest.transform;

import pe.upc.learningcenter.learning.domain.model.commands.CreateCourseCommand;
import pe.upc.learningcenter.learning.domain.model.commands.CreateCourseCommentCommand;
import pe.upc.learningcenter.learning.interfaces.rest.resources.CreateCourseCommentResource;
import pe.upc.learningcenter.learning.interfaces.rest.resources.CreateCourseResource;

public class CreateCourseCommentCommandFromResourceAssembler {
    public static CreateCourseCommentCommand toCommandFromResource(CreateCourseCommentResource resource) {
        return new CreateCourseCommentCommand(resource.profileId(), resource.courseId(),
                resource.content(), resource.rating(), resource.timeAgo());
    }
}
