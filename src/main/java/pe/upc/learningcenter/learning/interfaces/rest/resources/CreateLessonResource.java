package pe.upc.learningcenter.learning.interfaces.rest.resources;

public record CreateLessonResource(String name, Number duration, Long learningPathItemId) {
}
