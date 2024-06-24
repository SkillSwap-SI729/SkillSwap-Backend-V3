package pe.upc.learningcenter.iam.interfaces.rest.transform;

import pe.upc.learningcenter.iam.domain.model.aggregates.User;
import pe.upc.learningcenter.iam.domain.model.commands.CreateRoleCommand;
import pe.upc.learningcenter.iam.interfaces.rest.resources.AuthenticatedUserResource;
import pe.upc.learningcenter.iam.interfaces.rest.resources.CreateRoleResource;

public class CreateRoleCommandFromResourceAssembler {
    public static CreateRoleCommand toCommandFromResource(CreateRoleResource resource){
        return new CreateRoleCommand(resource.name());
    }
}
