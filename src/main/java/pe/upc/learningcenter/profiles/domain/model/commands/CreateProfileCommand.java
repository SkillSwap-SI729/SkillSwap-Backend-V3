package pe.upc.learningcenter.profiles.domain.model.commands;

public record CreateProfileCommand (String firstName,String lastName, String email,
                                    String photoUrl, Number ranking, String numberCourses, String aboutMe,
                                    String slogan,
                                    Number nRatings, Number nStudents, String username,
                                    String password, String profileType){
}
