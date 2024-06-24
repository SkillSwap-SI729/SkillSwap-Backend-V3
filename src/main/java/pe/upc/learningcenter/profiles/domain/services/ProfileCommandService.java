package pe.upc.learningcenter.profiles.domain.services;

import pe.upc.learningcenter.learning.domain.model.aggregates.Course;
import pe.upc.learningcenter.learning.domain.model.commands.CreateCourseCommand;
import pe.upc.learningcenter.profiles.domain.model.aggregates.Profile;
import pe.upc.learningcenter.profiles.domain.model.commands.CreateProfileCommand;
import pe.upc.learningcenter.profiles.domain.model.commands.UpdateProfileCommand;

import java.util.Optional;

public interface ProfileCommandService {
    Optional<Profile> handle(CreateProfileCommand command);
    Optional<Profile> handle(Long profileId, UpdateProfileCommand command);
}
