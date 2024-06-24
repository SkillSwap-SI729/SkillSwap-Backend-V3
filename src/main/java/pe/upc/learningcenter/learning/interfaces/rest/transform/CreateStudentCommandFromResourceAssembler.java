package pe.upc.learningcenter.learning.interfaces.rest.transform;

import pe.upc.learningcenter.learning.domain.model.commands.CreateStudentCommand;
import pe.upc.learningcenter.learning.interfaces.rest.resources.CreateStudentResource;


public class CreateStudentCommandFromResourceAssembler {
    public static CreateStudentCommand toCommandFromResource(CreateStudentResource resource) {
        return new CreateStudentCommand(resource.firstName(),
                resource.lastName(),
                resource.email(),
                resource.photoUrl(),
                resource.ranking(),
                resource.numberCourses(),
                resource.aboutMe(),
                resource.slogan(),
                resource.nRatings(),
                resource.nStudents(),
                resource.username(),
                resource.password(), "Student");
    }
}
