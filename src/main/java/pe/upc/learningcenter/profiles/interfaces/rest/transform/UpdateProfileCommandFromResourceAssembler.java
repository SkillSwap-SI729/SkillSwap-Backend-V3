package pe.upc.learningcenter.profiles.interfaces.rest.transform;

import pe.upc.learningcenter.profiles.domain.model.commands.UpdateProfileCommand;
import pe.upc.learningcenter.profiles.interfaces.rest.resources.UpdateProfileResource;

public class UpdateProfileCommandFromResourceAssembler {
    public static UpdateProfileCommand toCommandFromResource(UpdateProfileResource resource) {
        return new UpdateProfileCommand(resource.firstName(), resource.lastName(),
                resource.aboutMe(),
                resource.slogan(), resource.photoUrl());
    }
}
