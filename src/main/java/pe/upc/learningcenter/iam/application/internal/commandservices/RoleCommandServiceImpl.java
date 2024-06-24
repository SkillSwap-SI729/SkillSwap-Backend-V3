package pe.upc.learningcenter.iam.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.upc.learningcenter.iam.domain.model.commands.CreateRoleCommand;
import pe.upc.learningcenter.iam.domain.model.commands.SeedRolesCommand;
import pe.upc.learningcenter.iam.domain.model.entities.Role;
import pe.upc.learningcenter.iam.domain.model.valueobjects.Roles;
import pe.upc.learningcenter.iam.domain.services.RoleCommandService;
import pe.upc.learningcenter.iam.infraestructure.persistence.jpa.repositories.RoleRepository;
import pe.upc.learningcenter.profiles.domain.model.aggregates.Profile;

import java.util.Optional;

@Service
public class RoleCommandServiceImpl implements RoleCommandService {

    private final RoleRepository roleRepository;

    public RoleCommandServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void handle(SeedRolesCommand command) {

    }

    @Override
    public Optional<Role> handle(CreateRoleCommand createRoleCommand) {
        var role = new Role(createRoleCommand.name());
        roleRepository.save(role);

        return Optional.of(role);
    }


}
