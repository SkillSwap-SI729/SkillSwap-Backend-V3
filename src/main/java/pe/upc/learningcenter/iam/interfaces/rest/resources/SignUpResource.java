package pe.upc.learningcenter.iam.interfaces.rest.resources;

import pe.upc.learningcenter.iam.domain.model.valueobjects.Roles;

import java.util.List;

public record SignUpResource(String firstName, String lastName, String email,
        String username, String password, List<Roles> roles) {
}
