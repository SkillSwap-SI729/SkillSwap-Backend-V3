package pe.upc.learningcenter.learning.interfaces.rest.transform;

import pe.upc.learningcenter.learning.domain.model.commands.CreateInstructorCommand;
import pe.upc.learningcenter.learning.domain.model.commands.CreateStudentCommand;
import pe.upc.learningcenter.learning.interfaces.rest.resources.CreateInstructorResource;
import pe.upc.learningcenter.learning.interfaces.rest.resources.CreateStudentResource;

public class CreateInstructorCommandFromResourceAssembler {
    public static CreateInstructorCommand toCommandFromResource(CreateInstructorResource resource) {
        return new CreateInstructorCommand(resource.firstName(),
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
                resource.password(), "Instructor") ;
    }
}