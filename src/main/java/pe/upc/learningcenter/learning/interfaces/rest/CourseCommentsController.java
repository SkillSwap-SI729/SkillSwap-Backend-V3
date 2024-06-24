package pe.upc.learningcenter.learning.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.upc.learningcenter.learning.domain.services.CourseCommentCommandService;
import pe.upc.learningcenter.learning.interfaces.rest.resources.CourseCommentResource;
import pe.upc.learningcenter.learning.interfaces.rest.resources.CreateCourseCommentResource;
import pe.upc.learningcenter.learning.interfaces.rest.transform.CourseCommentResourceFromEntityAssembler;
import pe.upc.learningcenter.learning.interfaces.rest.transform.CreateCourseCommentCommandFromResourceAssembler;

@RestController
@RequestMapping(value = "/api/v2/courseComments", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="CourseComment", description = "CourseComment management endpoints")
public class CourseCommentsController {

    private final CourseCommentCommandService courseCommentCommandService;

    public CourseCommentsController(CourseCommentCommandService courseCommentCommandService) {
        this.courseCommentCommandService = courseCommentCommandService;
    }

    @PostMapping
    public ResponseEntity<CourseCommentResource> createCourseComment(
            @RequestBody CreateCourseCommentResource createCourseCommentResource) {

        var createCourseCommentCommand = CreateCourseCommentCommandFromResourceAssembler
                .toCommandFromResource(createCourseCommentResource);
        var courseComment = courseCommentCommandService.handle(createCourseCommentCommand);

        if (courseComment.isEmpty()) return ResponseEntity.badRequest().build();

        var courseCommentResource = CourseCommentResourceFromEntityAssembler
                .toResourceFromEntity(courseComment.get());
        return ResponseEntity.ok(courseCommentResource);
    }

}