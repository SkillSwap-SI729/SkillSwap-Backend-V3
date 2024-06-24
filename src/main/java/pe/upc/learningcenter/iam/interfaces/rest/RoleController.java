package pe.upc.learningcenter.iam.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.learningcenter.iam.domain.services.RoleCommandService;
import pe.upc.learningcenter.iam.interfaces.rest.resources.CreateRoleResource;
import pe.upc.learningcenter.iam.interfaces.rest.resources.RoleResource;
import pe.upc.learningcenter.iam.interfaces.rest.transform.CreateRoleCommandFromResourceAssembler;
import pe.upc.learningcenter.iam.interfaces.rest.transform.RoleResourceFromEntityAssembler;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v2/roles", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="Role", description = "Role management endpoints")
public class RoleController {

    private final RoleCommandService roleCommandService;

    public RoleController(RoleCommandService roleCommandService) {
        this.roleCommandService = roleCommandService;
    }


    @PostMapping
    public ResponseEntity<RoleResource> createRole(
            @RequestBody CreateRoleResource createRoleResource) {

        var createRoleCommand = CreateRoleCommandFromResourceAssembler
                .toCommandFromResource(createRoleResource);
        var role = roleCommandService.handle(createRoleCommand);

        if (role.isEmpty()) return ResponseEntity.badRequest().build();

        var roleResource = RoleResourceFromEntityAssembler.toResourceFromEntity(role.get());
        return ResponseEntity.ok(roleResource);
    }

}