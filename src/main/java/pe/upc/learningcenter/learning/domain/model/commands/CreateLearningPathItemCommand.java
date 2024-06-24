package pe.upc.learningcenter.learning.domain.model.commands;

import jakarta.validation.constraints.NotBlank;

public record CreateLearningPathItemCommand(@NotBlank String name,
                                            @NotBlank Number nLessons,
                                            @NotBlank String time,
                                            @NotBlank Long courseId) {
}
