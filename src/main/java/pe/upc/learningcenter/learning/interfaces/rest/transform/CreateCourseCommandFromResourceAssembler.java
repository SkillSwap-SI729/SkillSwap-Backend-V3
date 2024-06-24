package pe.upc.learningcenter.learning.interfaces.rest.transform;

import pe.upc.learningcenter.learning.domain.model.commands.CreateCourseCommand;
import pe.upc.learningcenter.learning.domain.model.commands.CreateStudentCommand;
import pe.upc.learningcenter.learning.interfaces.rest.resources.CreateCourseCommentResource;
import pe.upc.learningcenter.learning.interfaces.rest.resources.CreateCourseResource;
import pe.upc.learningcenter.learning.interfaces.rest.resources.CreateStudentResource;

public class CreateCourseCommandFromResourceAssembler {
    public static CreateCourseCommand toCommandFromResource(CreateCourseResource resource) {
        return new CreateCourseCommand(resource.name(), resource.photoUrl(), resource.description(),
                resource.cost(), resource.rating(), resource.nRatings(), resource.nStudents(), resource.nHours(),
                resource.topicName(), resource.instructorId());
    }
}
