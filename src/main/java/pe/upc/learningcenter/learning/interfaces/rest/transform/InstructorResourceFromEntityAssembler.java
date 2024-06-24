package pe.upc.learningcenter.learning.interfaces.rest.transform;

import pe.upc.learningcenter.learning.domain.model.aggregates.Instructor;
import pe.upc.learningcenter.learning.interfaces.rest.resources.InstructorResource;

import java.util.ArrayList;
import java.util.List;

public class InstructorResourceFromEntityAssembler {

    public static InstructorResource toResourceFromEntity(Instructor entity) {
        return new InstructorResource(entity.getId(), entity.getProfileId(), entity.getAcmeStudentRecordId(),
                CourseResourceFromEntityAssembler.toResourcesFromEntities(entity.getCourses()));
    }

    public static List<InstructorResource> toResourcesFromEntities(List<Instructor> instructors) {

        List<InstructorResource> instructorResources = new ArrayList<>();;

        for (Instructor instructor : instructors) {
            instructorResources.add(toResourceFromEntity(instructor));
        }
        return instructorResources;
    }
}