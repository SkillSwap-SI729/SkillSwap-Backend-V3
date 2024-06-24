package pe.upc.learningcenter.learning.interfaces.rest.transform;

import pe.upc.learningcenter.learning.domain.model.aggregates.Course;
import pe.upc.learningcenter.learning.domain.model.aggregates.Student;
import pe.upc.learningcenter.learning.interfaces.rest.resources.CourseCommentResource;
import pe.upc.learningcenter.learning.interfaces.rest.resources.CourseResource;
import pe.upc.learningcenter.learning.interfaces.rest.resources.LearningPathItemResource;
import pe.upc.learningcenter.learning.interfaces.rest.resources.StudentResource;

import java.util.ArrayList;
import java.util.List;

public class CourseResourceFromEntityAssembler {
    public static CourseResource toResourceFromEntity(Course entity) {

        return new CourseResource(entity.getId(), entity.getName(),entity.getDescription(),
                entity.getPhotoUrl(), entity.getCost(),
                entity.getRating(),entity.getNRatings(),entity.getNStudents(),
                entity.getNHours(),
                entity.getTopic().getId(),
                entity.getInstructor().getId(),
                LearningPathResourceFromValueObjectAssembler
                .toResourceFromValueObject(entity.getLearningPath()),
                CourseCommentResourceFromEntityAssembler.toResourcesFromEntities(entity.getCourseComments()));
    }

    public static List<CourseResource> toResourcesFromEntities(List<Course> courses) {

        List<CourseResource> coursesResources = new ArrayList<>();;

        for (Course cours : courses) {
            coursesResources.add(toResourceFromEntity(cours));
        }
        return coursesResources;
    }



}
