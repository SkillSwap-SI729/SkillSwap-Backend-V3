package pe.upc.learningcenter.profiles.application.internal.commandServices;

import org.springframework.stereotype.Service;
import pe.upc.learningcenter.profiles.domain.model.aggregates.Profile;
import pe.upc.learningcenter.profiles.domain.model.querys.GetProfileByEmailQuery;
import pe.upc.learningcenter.profiles.domain.model.querys.GetProfileByIdQuery;
import pe.upc.learningcenter.profiles.domain.model.querys.GetProfileByNameQuery;
import pe.upc.learningcenter.profiles.domain.model.querys.GetProfileByUserIdQuery;
import pe.upc.learningcenter.profiles.domain.model.valueobjects.UserId;
import pe.upc.learningcenter.profiles.domain.services.ProfileQueryService;
import pe.upc.learningcenter.profiles.infrastructure.persistence.jpa.repositories.ProfileRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileQueryServiceImpl implements ProfileQueryService {

    private final ProfileRepository profileRepository;

    public ProfileQueryServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Optional<Profile> handle(GetProfileByIdQuery query) {
        return profileRepository.findById(query.id());
    }

    @Override
    public Optional<Profile> handle(GetProfileByNameQuery query) {
        return profileRepository.findByPersonName(query.name());
    }

    @Override
    public Optional<Profile> handle(GetProfileByEmailQuery query) {
        return profileRepository.findByEmail(query.emailAddress());
    }

    @Override
    public Optional<Profile> handle(GetProfileByUserIdQuery query) {
        return profileRepository.findByUserId(new UserId(query.userId()));
    }

    @Override
    public List<Profile> handle() {
        return profileRepository.findAll();
    }
}
