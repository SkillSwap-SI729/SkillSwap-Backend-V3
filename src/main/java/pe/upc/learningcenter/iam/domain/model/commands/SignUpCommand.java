package pe.upc.learningcenter.iam.domain.model.commands;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import pe.upc.learningcenter.iam.domain.model.entities.Role;
import pe.upc.learningcenter.iam.domain.model.valueobjects.Roles;

import java.util.List;

public record SignUpCommand(
        @NotBlank String username,
        @NotBlank String password,
        List<Role> roles) {
}
