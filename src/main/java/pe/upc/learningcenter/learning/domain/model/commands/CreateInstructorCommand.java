package pe.upc.learningcenter.learning.domain.model.commands;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateInstructorCommand(
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotBlank @Email String email,
        String photoUrl,
        Number ranking,
        String numberCourses,
        String aboutMe,
        String slogan,
        Number nRatings,
        Number nStudents,
        @NotBlank String username,
        @NotBlank String password,
        @NotBlank String entityName) {
}