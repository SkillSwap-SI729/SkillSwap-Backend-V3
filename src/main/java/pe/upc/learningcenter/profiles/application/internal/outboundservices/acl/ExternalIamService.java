package pe.upc.learningcenter.profiles.application.internal.outboundservices.acl;

import org.springframework.stereotype.Service;
import pe.upc.learningcenter.iam.interfaces.acl.IamContextFacade;
import pe.upc.learningcenter.profiles.domain.model.valueobjects.UserId;

import java.util.Optional;

@Service
public class ExternalIamService {

    private final IamContextFacade iamContextFacade;

    public ExternalIamService(IamContextFacade iamContextFacade) {
        this.iamContextFacade = iamContextFacade;
    }


    public Optional<UserId> fetchUserIdByUsername(String username) {
        var userId = iamContextFacade.fetchUserIdByUsername(username);
        if (userId == 0L) return Optional.empty();
        return Optional.of(new UserId(userId));
    }

    public Optional<String> fetchUsernameByUserId(Long id) {
        var username = iamContextFacade.fetchUsernameByUserId(id);
        if (username == " ") return Optional.empty();
        return Optional.of(username);
    }

    public Optional<UserId> createUser(String username,
                                       String password,
                                       String userType) {
        var userId = iamContextFacade.createUser(username, password, userType );
        if (userId == 0L) return Optional.empty();
        return Optional.of(new UserId(userId));
    }

}