package pe.upc.learningcenter.learning.interfaces.rest.resources;

import java.util.List;

public record LearningPathItemResource(Long id, String name, String time, Long courseId,
                                       Number nLessons,
                                       List<LessonResource> lessonResources) {
}
