package pe.upc.learningcenter.iam.interfaces.acl;

import org.springframework.stereotype.Service;
import pe.upc.learningcenter.iam.domain.model.commands.SignUpCommand;
import pe.upc.learningcenter.iam.domain.model.entities.Role;
import pe.upc.learningcenter.iam.domain.model.queries.GetUserByIdQuery;
import pe.upc.learningcenter.iam.domain.model.queries.GetUserByUsernameQuery;
import pe.upc.learningcenter.iam.domain.model.valueobjects.Roles;
import pe.upc.learningcenter.iam.domain.services.UserCommandService;
import pe.upc.learningcenter.iam.domain.services.UserQueryService;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class IamContextFacade {
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    public IamContextFacade(UserCommandService userCommandService, UserQueryService userQueryService) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }


    /**
     * Fetches the user id by username
     *
     * @param username the username of the user
     * @return the user id
     */

    public Long fetchUserIdByUsername(String username) {
        var getUserByUsernameQuery = new GetUserByUsernameQuery(username);
        var user = userQueryService.handle(getUserByUsernameQuery);
        if (user.isEmpty()) return 0L;
        return user.get().getId();

    }

    public String fetchUsernameByUserId(Long id) {
        var getUserByIdQuery = new GetUserByIdQuery(id);
        var user = userQueryService.handle(getUserByIdQuery);
        if (user.isEmpty()) return " ";
        return user.get().getUsername();

    }

    /**
     * Creates a new User
     *
     * @param username the username
     * @param password the password
     * @param userType the user type
     * @return the user id
     */

    public Long createUser(String username,
                           String password,
                           String userType) {

        var roles = new ArrayList<String>();

        if(Objects.equals(userType, "Student")) {
            roles.add("ROLE_STUDENT");
        }
        else if(Objects.equals(userType, "Instructor")) {
            roles.add("ROLE_STUDENT");
            roles.add("ROLE_INSTRUCTOR");
        }

        var rolesInCommand = roles.stream().map(Role::toRoleFromName).toList();

        var signUpCommand = new SignUpCommand(username, password, rolesInCommand);

        var user = userCommandService.handle(signUpCommand);

        if (user.isEmpty()) return 0L;
        return user.get().getId();
    }

}
