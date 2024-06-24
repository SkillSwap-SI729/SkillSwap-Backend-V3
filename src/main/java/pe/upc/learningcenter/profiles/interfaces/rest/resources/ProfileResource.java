package pe.upc.learningcenter.profiles.interfaces.rest.resources;

import jakarta.validation.constraints.NotBlank;

public record ProfileResource(Long id, Long userId, String personName, String email,
                              String photoUrl, Number ranking, String numberCourses,
                              String aboutMe,
                              String slogan,
                              Number nRatings,
                              Number nStudents,
                              String profileType) {
}
