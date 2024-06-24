package pe.upc.learningcenter.learning.interfaces.rest.transform;

import pe.upc.learningcenter.learning.domain.model.aggregates.Course;
import pe.upc.learningcenter.learning.domain.model.aggregates.Instructor;
import pe.upc.learningcenter.learning.domain.model.entities.CourseComment;
import pe.upc.learningcenter.learning.interfaces.rest.resources.CourseCommentResource;
import pe.upc.learningcenter.learning.interfaces.rest.resources.CourseResource;
import pe.upc.learningcenter.learning.interfaces.rest.resources.InstructorResource;

import java.util.ArrayList;
import java.util.List;

public class CourseCommentResourceFromEntityAssembler {
    public static CourseCommentResource toResourceFromEntity(CourseComment entity) {
        return new CourseCommentResource(entity.getId(), entity.getContent(), entity.getRating(),
                entity.getTimeAgo(),  entity.getCourse().getId(), entity.getProfilePhotoUrl(),
                entity.getUsername());
    }

    public static List<CourseCommentResource> toResourcesFromEntities(List<CourseComment> coursesComments) {

        List<CourseCommentResource> coursesCommentsResources = new ArrayList<>();;

        for (CourseComment courseComment : coursesComments) {
            coursesCommentsResources.add(toResourceFromEntity(courseComment));
        }
        return coursesCommentsResources;
    }
}
