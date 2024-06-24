package pe.upc.learningcenter.learning.application.internal.outboundservices.acl;

import org.springframework.stereotype.Service;
import pe.upc.learningcenter.learning.domain.model.valueobjects.ProfileId;
import pe.upc.learningcenter.learning.domain.model.valueobjects.UserId;
import pe.upc.learningcenter.profiles.interfaces.acl.ProfilesContextFacade;

import java.util.Optional;

@Service
public class ExternalProfileService {

    private final ProfilesContextFacade profilesContextFacade;

    public ExternalProfileService(ProfilesContextFacade profilesContextFacade) {
        this.profilesContextFacade = profilesContextFacade;
    }

    public Optional<ProfileId> fetchProfileIdByEmail(String email) {
        var profileId = profilesContextFacade.fetchProfileIdByEmail(email);
        if (profileId == 0L) return Optional.empty();
        return Optional.of(new ProfileId(profileId));
    }

    public Optional<String> fetchProfilePhotoUrlById(Long id) {
        var profilePhotoUrl = profilesContextFacade.fetchProfilePhotoUrlById(id);
        if (profilePhotoUrl == " ") return Optional.empty();
        return Optional.of(profilePhotoUrl);
    }

    public Optional<UserId> fetchProfileUserIdById(Long id) {
        var userId = profilesContextFacade.fetchProfileUserIdById(id);
        if (userId == 0L) return Optional.empty();
        return Optional.of(new UserId(userId));
    }

    public Optional<ProfileId> createProfile(String firstName,String lastName, String email,
                                             String photoUrl, Number ranking,
                                             String aboutMe, String slogan,  String numberCourses,
                                             Number nRatings, Number nStudents,
                                             String username, String password, String profileType) {
        var profileId = profilesContextFacade.createProfile
                ( firstName, lastName,  email,
                         photoUrl,  ranking,  numberCourses,aboutMe,  slogan,
                         nRatings,  nStudents, username, password, profileType);
        if (profileId == 0L) return Optional.empty();
        return Optional.of(new ProfileId(profileId));
    }

}
