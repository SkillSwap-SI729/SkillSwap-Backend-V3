package pe.upc.learningcenter.learning.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.upc.learningcenter.learning.application.internal.outboundservices.acl.ExternalProfileService;
import pe.upc.learningcenter.learning.domain.model.aggregates.Course;
import pe.upc.learningcenter.learning.domain.model.commands.CreateCourseCommand;
import pe.upc.learningcenter.learning.domain.model.commands.CreateCourseCommentCommand;
import pe.upc.learningcenter.learning.domain.model.entities.CourseComment;
import pe.upc.learningcenter.learning.domain.services.CourseCommentCommandService;
import pe.upc.learningcenter.learning.infrastructure.persistence.jpa.repositories.CourseCommentRepository;
import pe.upc.learningcenter.learning.infrastructure.persistence.jpa.repositories.CourseRepository;
import pe.upc.learningcenter.profiles.application.internal.outboundservices.acl.ExternalIamService;

import java.util.Optional;

@Service
public class CourseCommentCommandServiceImpl implements CourseCommentCommandService {
    private final CourseCommentRepository courseCommentRepository;
    private final ExternalProfileService externalProfileService;
    private final ExternalIamService externalIamService;
    private final CourseRepository courseRepository;

    public CourseCommentCommandServiceImpl(CourseCommentRepository courseCommentRepository, ExternalProfileService externalProfileService, ExternalIamService externalIamService, CourseRepository courseRepository) {
        this.courseCommentRepository = courseCommentRepository;
        this.externalProfileService = externalProfileService;
        this.externalIamService = externalIamService;
        this.courseRepository = courseRepository;
    }

    @Override
    public Optional<CourseComment> handle(CreateCourseCommentCommand command) {
        var profilePhotoUrl = externalProfileService.fetchProfilePhotoUrlById(command.profileId());

        var userId = externalProfileService.fetchProfileUserIdById(command.profileId());
        var username = externalIamService.fetchUsernameByUserId(userId.get().userId());

        var course = courseRepository.findById(command.courseId());
        var courseComment = new CourseComment(command.content(), command.rating(),
                command.timeAgo(),course.get(),profilePhotoUrl.get(),username.get());

        courseCommentRepository.save(courseComment);

        return Optional.of(courseComment);
    }
}
