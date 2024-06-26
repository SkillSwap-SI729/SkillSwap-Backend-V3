package pe.upc.learningcenter.profiles.domain.services;

import pe.upc.learningcenter.profiles.domain.model.aggregates.Profile;
import pe.upc.learningcenter.profiles.domain.model.querys.GetProfileByEmailQuery;
import pe.upc.learningcenter.profiles.domain.model.querys.GetProfileByIdQuery;
import pe.upc.learningcenter.profiles.domain.model.querys.GetProfileByNameQuery;
import pe.upc.learningcenter.profiles.domain.model.querys.GetProfileByUserIdQuery;

import java.util.List;
import java.util.Optional;

public interface ProfileQueryService {
    Optional<Profile> handle(GetProfileByIdQuery query);
    Optional<Profile> handle(GetProfileByNameQuery query);
    Optional<Profile> handle(GetProfileByEmailQuery query);
    Optional<Profile> handle(GetProfileByUserIdQuery query);
    List<Profile> handle();
}
