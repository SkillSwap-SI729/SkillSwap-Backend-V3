package pe.upc.learningcenter.learning.application.internal.commandservices;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;
import pe.upc.learningcenter.learning.application.internal.outboundservices.acl.ExternalProfileService;
import pe.upc.learningcenter.learning.domain.model.aggregates.Instructor;
import pe.upc.learningcenter.learning.domain.model.commands.CreateInstructorCommand;
import pe.upc.learningcenter.learning.domain.services.InstructorCommandService;
import pe.upc.learningcenter.learning.infrastructure.persistence.jpa.repositories.InstructorRepository;

import java.util.Optional;

@Service
public class InstructorCommandServiceImpl implements InstructorCommandService {

    private final InstructorRepository instructorRepository;
    private final ExternalProfileService externalProfileService;

    public InstructorCommandServiceImpl(InstructorRepository instructorRepository, ExternalProfileService externalProfileService) {
        this.instructorRepository = instructorRepository;
        this.externalProfileService = externalProfileService;
    }

    @Override
    public Optional<Instructor> handle(CreateInstructorCommand command) {

        var profileId = externalProfileService.fetchProfileIdByEmail(command.email());

        if (profileId.isEmpty()) {
            profileId = externalProfileService.createProfile(
                    command.firstName(),
                    command.lastName(),
                    command.email(),
                    command.photoUrl(),
                    command.ranking(),
                    command.aboutMe(),
                    command.slogan(),
                    command.numberCourses(),
                    command.nRatings(),
                    command.nStudents(),
                    command.username(),
                    command.password(),
                    command.entityName()
                    );
        } else {
            instructorRepository.findByProfileId(profileId.get()).ifPresent(instructor -> {
                throw new IllegalArgumentException("Profile email already is on use");
            });
        }

        if (profileId.isEmpty()) throw new IllegalArgumentException("Unable to create profile");

        var instructor = new Instructor(profileId.get());
        instructorRepository.save(instructor);

        return Optional.of(instructor);
    }
}