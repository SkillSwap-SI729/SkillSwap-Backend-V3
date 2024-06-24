package pe.upc.learningcenter.learning.interfaces.rest.resources;

public record CreateLearningPathItemResource(String name,Number nLessons,String time,
                                             Long courseId) {
}
