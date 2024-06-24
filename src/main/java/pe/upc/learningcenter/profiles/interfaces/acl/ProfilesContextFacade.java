package pe.upc.learningcenter.profiles.interfaces.acl;

import org.springframework.stereotype.Service;
import pe.upc.learningcenter.profiles.domain.model.commands.CreateProfileCommand;
import pe.upc.learningcenter.profiles.domain.model.querys.GetProfileByEmailQuery;
import pe.upc.learningcenter.profiles.domain.model.querys.GetProfileByIdQuery;
import pe.upc.learningcenter.profiles.domain.model.valueobjects.EmailAddress;
import pe.upc.learningcenter.profiles.domain.services.ProfileCommandService;
import pe.upc.learningcenter.profiles.domain.services.ProfileQueryService;

@Service
public class ProfilesContextFacade {
    private final ProfileCommandService profileCommandService;
    private final ProfileQueryService profileQueryService;

    public ProfilesContextFacade(ProfileCommandService profileCommandService,
                                 ProfileQueryService profileQueryService) {
        this.profileCommandService = profileCommandService;
        this.profileQueryService = profileQueryService;
    }


    /**
     * Creates a new Profile
     *
     * @param firstName the first name
     * @param lastName the first name
     * @param email the first name
     * @param photoUrl the first name
     * @param ranking the first name
     * @param aboutMe the first name
     * @param slogan the slogan
     * @param nRatings the number of ratings
     * @param nStudents the number of students
     * @return the profile id
     */
    public Long createProfile(String firstName,String lastName, String email,
                              String photoUrl, Number ranking, String numberCourses,String aboutMe, String slogan,
                              Number nRatings, Number nStudents, String username, String password,
                              String profileType) {
        var createProfileCommand = new CreateProfileCommand(firstName,lastName,  email,
                 photoUrl,  ranking,  numberCourses,aboutMe,  slogan,
                 nRatings,  nStudents, username, password, profileType);
        var profile = profileCommandService.handle(createProfileCommand);
        if (profile.isEmpty()) return 0L;
        return profile.get().getId();
    }

    /**
     * Fetches the profile id by email
     *
     * @param email the email
     * @return the profile id
     */
    public Long fetchProfileIdByEmail(String email) {
        var getProfileByEmailQuery = new GetProfileByEmailQuery(new EmailAddress(email));
        var profile = profileQueryService.handle(getProfileByEmailQuery);
        if (profile.isEmpty()) return 0L;
        return profile.get().getId();

    }

    public String fetchProfilePhotoUrlById (Long id) {
        var getProfileByIdQuery = new GetProfileByIdQuery(id);
        var profile = profileQueryService.handle(getProfileByIdQuery);
        if (profile.isEmpty()) return " ";
        return profile.get().getPhotoUrl();
    }

    public Long fetchProfileUserIdById (Long id) {
        var getProfileByIdQuery = new GetProfileByIdQuery(id);
        var profile = profileQueryService.handle(getProfileByIdQuery);
        if (profile.isEmpty()) return 0L;
        return profile.get().getUserId().userId();
    }
}