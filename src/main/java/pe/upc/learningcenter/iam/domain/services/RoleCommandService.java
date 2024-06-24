package pe.upc.learningcenter.iam.domain.services;

import pe.upc.learningcenter.iam.domain.model.commands.CreateRoleCommand;
import pe.upc.learningcenter.iam.domain.model.commands.SeedRolesCommand;
import pe.upc.learningcenter.iam.domain.model.entities.Role;

import java.util.Optional;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
    Optional<Role> handle(CreateRoleCommand createRoleCommand);
}
