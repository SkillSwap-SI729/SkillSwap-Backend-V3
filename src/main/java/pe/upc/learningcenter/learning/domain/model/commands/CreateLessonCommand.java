package pe.upc.learningcenter.learning.domain.model.commands;

public record CreateLessonCommand(String name, Number duration, Long learningPathItemId) {
}
