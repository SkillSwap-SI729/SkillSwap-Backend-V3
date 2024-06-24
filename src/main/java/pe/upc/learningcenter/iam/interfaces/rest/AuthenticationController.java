package pe.upc.learningcenter.iam.interfaces.rest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.learningcenter.iam.domain.model.queries.GetUserByIdQuery;
import pe.upc.learningcenter.iam.domain.services.UserCommandService;
import pe.upc.learningcenter.iam.domain.services.UserQueryService;
import pe.upc.learningcenter.iam.interfaces.rest.resources.AuthenticatedUserResource;
import pe.upc.learningcenter.iam.interfaces.rest.resources.SignInResource;
import pe.upc.learningcenter.iam.interfaces.rest.resources.SignUpResource;
import pe.upc.learningcenter.iam.interfaces.rest.resources.UserResource;
import pe.upc.learningcenter.iam.interfaces.rest.transform.AuthenticatedUserResourceFromEntityAssembler;
import pe.upc.learningcenter.iam.interfaces.rest.transform.SignInCommandFromResourceAssembler;
import pe.upc.learningcenter.iam.interfaces.rest.transform.SignUpCommandFromResourceAssembler;
import pe.upc.learningcenter.iam.interfaces.rest.transform.UserResourceFromEntityAssembler;


@RestController
@RequestMapping(value = "/api/v2/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;
    public AuthenticationController(UserCommandService userCommandService, UserQueryService userQueryService) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResource> getUserById(@PathVariable Long userId) {
        var getUserByIdQuery = new GetUserByIdQuery(userId);
        var user = userQueryService.handle(getUserByIdQuery);
        if (user.isEmpty()) return ResponseEntity.badRequest().build();

        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return ResponseEntity.ok(userResource);
    }
    
    @PostMapping("/sign-in")
    public ResponseEntity<AuthenticatedUserResource> signIn(@RequestBody SignInResource signInResource){
        var signInCommand = SignInCommandFromResourceAssembler.toCommandFromResource(signInResource);

        var authenticatedUser = userCommandService.handle(signInCommand);
        if(authenticatedUser.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        var authenticatedUserResource = AuthenticatedUserResourceFromEntityAssembler.toResourceFromEntity(authenticatedUser.get().getLeft(), authenticatedUser.get().getRight());

        return ResponseEntity.ok(authenticatedUserResource);


    }

    @PostMapping("/sign-up")
    public ResponseEntity<UserResource> signUp(@RequestBody SignUpResource signUpResource){
        var signUpCommand = SignUpCommandFromResourceAssembler.toCommandFromResource(signUpResource);
        var user = userCommandService.handle(signUpCommand);
        if(user.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return ResponseEntity.ok(userResource);

    }

}
