package pe.upc.learningcenter.iam.interfaces.rest.transform;

import pe.upc.learningcenter.iam.domain.model.entities.Role;
import pe.upc.learningcenter.iam.interfaces.rest.resources.RoleResource;
import pe.upc.learningcenter.profiles.domain.model.aggregates.Profile;
import pe.upc.learningcenter.profiles.interfaces.rest.resources.ProfileResource;

public class RoleResourceFromEntityAssembler {
    public static RoleResource toResourceFromEntity(Role entity) {
        return new RoleResource(entity.getId(), entity.getName());
    }
}
