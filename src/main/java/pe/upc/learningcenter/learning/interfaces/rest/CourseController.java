package pe.upc.learningcenter.learning.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.learningcenter.learning.domain.model.queries.GetCourseByIdQuery;
import pe.upc.learningcenter.learning.domain.model.queries.GetStudentByIdQuery;
import pe.upc.learningcenter.learning.domain.services.CourseCommandService;
import pe.upc.learningcenter.learning.domain.services.CourseQueryService;
import pe.upc.learningcenter.learning.interfaces.rest.resources.CreateCourseResource;
import pe.upc.learningcenter.learning.interfaces.rest.resources.CourseResource;
import pe.upc.learningcenter.learning.interfaces.rest.resources.StudentResource;
import pe.upc.learningcenter.learning.interfaces.rest.transform.CreateCourseCommandFromResourceAssembler;
import pe.upc.learningcenter.learning.interfaces.rest.transform.CourseResourceFromEntityAssembler;
import pe.upc.learningcenter.learning.interfaces.rest.transform.StudentResourceFromEntityAssembler;

@RestController
@RequestMapping(value = "/api/v2/courses", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="Course", description = "Course management endpoints")
public class CourseController {

    private final CourseCommandService courseCommandService;
    private final CourseQueryService courseQueryService;

    public CourseController(CourseCommandService courseCommandService, CourseQueryService courseQueryService) {
        this.courseCommandService = courseCommandService;
        this.courseQueryService = courseQueryService;
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<CourseResource> getCourseById(@PathVariable Long courseId) {
        var getCourseByIdQuery = new GetCourseByIdQuery(courseId);
        var course = courseQueryService.handle(getCourseByIdQuery);
        if (course.isEmpty()) return ResponseEntity.badRequest().build();

        var courseResource = CourseResourceFromEntityAssembler.toResourceFromEntity(course.get());
        return ResponseEntity.ok(courseResource);
    }

    @PostMapping
    public ResponseEntity<CourseResource> createCourse(
            @RequestBody CreateCourseResource createCourseResource) {

        var createCourseCommand = CreateCourseCommandFromResourceAssembler
                .toCommandFromResource(createCourseResource);
        var course = courseCommandService.handle(createCourseCommand);

        if (course.isEmpty()) return ResponseEntity.badRequest().build();

        var courseResource = CourseResourceFromEntityAssembler.toResourceFromEntity(course.get());
        return ResponseEntity.ok(courseResource);
    }
    
}
