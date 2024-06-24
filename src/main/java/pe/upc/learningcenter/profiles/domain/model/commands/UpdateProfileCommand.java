package pe.upc.learningcenter.profiles.domain.model.commands;

public record UpdateProfileCommand(String firstName, String lastName,
                                   String aboutMe,
                                   String slogan,
                                   String photoUrl) {
}
