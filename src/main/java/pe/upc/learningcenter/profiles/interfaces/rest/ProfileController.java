package pe.upc.learningcenter.profiles.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.learningcenter.profiles.interfaces.rest.transform.UpdateProfileCommandFromResourceAssembler;
import pe.upc.learningcenter.profiles.domain.model.querys.GetProfileByIdQuery;
import pe.upc.learningcenter.profiles.domain.services.ProfileCommandService;
import pe.upc.learningcenter.profiles.domain.services.ProfileQueryService;
import pe.upc.learningcenter.profiles.interfaces.rest.resources.ProfileResource;
import pe.upc.learningcenter.profiles.interfaces.rest.resources.UpdateProfileResource;
import pe.upc.learningcenter.profiles.interfaces.rest.transform.ProfileResourceFromEntityAssembler;

import java.util.List;


@RestController
@RequestMapping(value = "/api/v2/profiles", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="Profile", description = "Profile management endpoints")
public class ProfileController {

    private final ProfileQueryService profileQueryService;
    private final ProfileCommandService profileCommandService;

    public ProfileController(ProfileQueryService profileQueryService,
                             ProfileCommandService profileCommandService) {
        this.profileQueryService = profileQueryService;
        this.profileCommandService = profileCommandService;
    }

    @GetMapping
    public ResponseEntity<List<ProfileResource>> getAll() {

        var profileResources = ProfileResourceFromEntityAssembler
                .toResourcesFromEntities(profileQueryService.handle());
        return ResponseEntity.ok(profileResources);
    }
    
    @GetMapping("/{profileId}")
    public ResponseEntity<ProfileResource> getProfileById(@PathVariable Long profileId) {
        var getProfileByIdQuery = new GetProfileByIdQuery(profileId);
        var profile = profileQueryService.handle(getProfileByIdQuery);
        if (profile.isEmpty()) return ResponseEntity.badRequest().build();

        var profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());
        return ResponseEntity.ok(profileResource);
    }

    @PutMapping("{profileId}")
    public ResponseEntity<ProfileResource> updateProfile
            (@PathVariable Long profileId, @RequestBody UpdateProfileResource updateProfileResource) {
        var updateProfileCommand = UpdateProfileCommandFromResourceAssembler
                .toCommandFromResource(updateProfileResource);
        var profile = profileCommandService.handle(profileId, updateProfileCommand);

        if (profile.isEmpty()) return ResponseEntity.badRequest().build();

        var profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());
        return ResponseEntity.ok(profileResource);
    }
    

}
