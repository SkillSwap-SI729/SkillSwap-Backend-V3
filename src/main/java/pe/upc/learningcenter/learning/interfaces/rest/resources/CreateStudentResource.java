package pe.upc.learningcenter.learning.interfaces.rest.resources;

public record CreateStudentResource (String firstName,
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
                                     String password) { }
