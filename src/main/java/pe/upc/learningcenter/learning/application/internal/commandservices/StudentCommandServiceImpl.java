package pe.upc.learningcenter.learning.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.upc.learningcenter.learning.application.internal.outboundservices.acl.ExternalProfileService;
import pe.upc.learningcenter.learning.domain.model.aggregates.Instructor;
import pe.upc.learningcenter.learning.domain.model.aggregates.Student;
import pe.upc.learningcenter.learning.domain.model.commands.CreateStudentCommand;
import pe.upc.learningcenter.learning.domain.services.StudentCommandService;
import pe.upc.learningcenter.learning.infrastructure.persistence.jpa.repositories.StudentRepository;

import java.util.Optional;

@Service
public class StudentCommandServiceImpl implements StudentCommandService {

    private final StudentRepository studentRepository;
    private final ExternalProfileService externalProfileService;

    public StudentCommandServiceImpl(StudentRepository studentRepository, ExternalProfileService externalProfileService) {
        this.studentRepository = studentRepository;
        this.externalProfileService = externalProfileService;
    }

    @Override
    public Optional<Student> handle(CreateStudentCommand command) {

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
                    command.entityName());
        } else {
            studentRepository.findByProfileId(profileId.get()).ifPresent(instructor -> {
                throw new IllegalArgumentException("Profile email already is on use");
            });
        }

        if (profileId.isEmpty()) throw new IllegalArgumentException("Unable to create profile");

        var student = new Student(profileId.get());
        studentRepository.save(student);

        return Optional.of(student);
    }
}
