package pe.upc.learningcenter.profiles.interfaces.rest.resources;

public record UpdateProfileResource(String firstName, String lastName,
                                    String aboutMe,
                                    String slogan,
                                    String photoUrl) {
}
