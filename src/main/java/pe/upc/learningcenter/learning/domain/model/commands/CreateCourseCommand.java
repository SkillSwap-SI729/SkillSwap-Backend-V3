package pe.upc.learningcenter.learning.domain.model.commands;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import pe.upc.learningcenter.learning.domain.model.valueobjects.LearningPath;

public record CreateCourseCommand( @NotBlank String name,
                                   @NotBlank String photoUrl,
                                   @NotBlank String description,
                                   @NotBlank Number cost,
                                   @NotBlank Number rating,
                                   @NotBlank Number nRatings,
                                   @NotBlank Number nStudents,
                                   @NotBlank Number nHours,
                                   @NotNull String topicName,
                                   @NotNull Long instructorId) {
}
