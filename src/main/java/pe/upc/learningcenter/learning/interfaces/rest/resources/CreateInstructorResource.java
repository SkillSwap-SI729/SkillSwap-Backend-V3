package pe.upc.learningcenter.learning.interfaces.rest.resources;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateInstructorResource(String firstName,
                                       String lastName,
                                       String email,
                                       String photoUrl,
                                       Number ranking,
                                       String numberCourses,
                                       String aboutMe,
                                       String slogan,
                                       Number nRatings,
                                       Number nStudents,
                                       String username,
                                       String password) {
}
