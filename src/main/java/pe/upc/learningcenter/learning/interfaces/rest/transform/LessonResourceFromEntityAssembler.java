package pe.upc.learningcenter.learning.interfaces.rest.transform;

import pe.upc.learningcenter.learning.domain.model.aggregates.Course;
import pe.upc.learningcenter.learning.domain.model.entities.Lesson;
import pe.upc.learningcenter.learning.interfaces.rest.resources.CourseResource;
import pe.upc.learningcenter.learning.interfaces.rest.resources.LessonResource;

import java.util.ArrayList;
import java.util.List;

public class LessonResourceFromEntityAssembler {
    public static LessonResource toResourceFromEntity(Lesson entity) {

        return new LessonResource(entity.getId(), entity.getName(), entity.getDuration(),
                entity.getLearningPathItem().getId());
    }

    public static List<LessonResource> toResourcesFromEntities(List<Lesson> lessons) {

        List<LessonResource> lessonResources = new ArrayList<>();;

        for (Lesson lesson : lessons) {
            lessonResources.add(toResourceFromEntity(lesson));
        }
        return lessonResources;
    }

}
