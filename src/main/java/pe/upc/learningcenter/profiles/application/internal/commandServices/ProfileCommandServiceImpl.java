package pe.upc.learningcenter.profiles.application.internal.commandServices;

import org.springframework.stereotype.Service;
import pe.upc.learningcenter.profiles.application.internal.outboundservices.acl.ExternalIamService;
import pe.upc.learningcenter.profiles.domain.model.aggregates.Profile;
import pe.upc.learningcenter.profiles.domain.model.commands.CreateProfileCommand;
import pe.upc.learningcenter.profiles.domain.model.commands.UpdateProfileCommand;
import pe.upc.learningcenter.profiles.domain.model.valueobjects.EmailAddress;
import pe.upc.learningcenter.profiles.domain.model.valueobjects.PersonName;
import pe.upc.learningcenter.profiles.domain.services.ProfileCommandService;
import pe.upc.learningcenter.profiles.infrastructure.persistence.jpa.repositories.ProfileRepository;

import java.util.Optional;

@Service
public class ProfileCommandServiceImpl implements ProfileCommandService {

    private final ProfileRepository profileRepository;
    private final ExternalIamService externalIamService;

    public ProfileCommandServiceImpl(ProfileRepository profileRepository, ExternalIamService externalIamService) {
        this.profileRepository = profileRepository;
        this.externalIamService = externalIamService;
    }

    @Override
    public Optional<Profile> handle(CreateProfileCommand command) {

        var userId = externalIamService.fetchUserIdByUsername(command.username());

        if (userId.isEmpty()) {
            userId = externalIamService.createUser(
                    command.username(), command.password(), command.profileType());
        } else {
            profileRepository.findByUserId(userId.get()).ifPresent(instructor -> {
                throw new IllegalArgumentException("Profile username already is on use");
            });
        }

        if (userId.isEmpty()) throw new IllegalArgumentException("Unable to create profile");

        var emailAddress = new EmailAddress(command.email());

        profileRepository.findByEmail(emailAddress).map(profile -> {
            throw new IllegalArgumentException("Profile with email " + emailAddress + " already exists");
        });

        var profile = new Profile(command, userId.get());
        profileRepository.save(profile);

        return Optional.of(profile);
    }


    @Override
    public Optional<Profile> handle(Long profileId, UpdateProfileCommand command) {
        Optional<Profile> profileWithPersonName = profileRepository
                .findByPersonName(new PersonName(command.firstName(), command.lastName()));

        if (profileWithPersonName.isPresent() && !profileWithPersonName.get().getId().equals(profileId))
            throw new RuntimeException("Profile with the same name already exists.");

        return profileRepository.findById(profileId).map(profile -> {
            profile.setPersonName(new PersonName(command.firstName(), command.lastName()));
            profile.setAboutMe(command.aboutMe());
            profile.setSlogan(command.slogan());
            profile.setPhotoUrl(command.photoUrl());
            return profileRepository.save(profile);
        });
    }
}
