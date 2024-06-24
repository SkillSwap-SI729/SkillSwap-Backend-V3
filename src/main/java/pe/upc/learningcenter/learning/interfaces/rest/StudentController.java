package pe.upc.learningcenter.learning.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.learningcenter.learning.domain.model.queries.GetStudentByIdQuery;
import pe.upc.learningcenter.learning.domain.services.StudentCommandService;
import pe.upc.learningcenter.learning.domain.services.StudentQueryService;
import pe.upc.learningcenter.learning.interfaces.rest.resources.CreateStudentResource;
import pe.upc.learningcenter.learning.interfaces.rest.resources.StudentResource;
import pe.upc.learningcenter.learning.interfaces.rest.transform.CreateStudentCommandFromResourceAssembler;
import pe.upc.learningcenter.learning.interfaces.rest.transform.StudentResourceFromEntityAssembler;

@RestController
@RequestMapping(value = "/api/v2/students", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="Student", description = "Student management endpoints")
public class StudentController {

    private final StudentCommandService studentCommandService;
    private final StudentQueryService studentQueryService;

    public StudentController(StudentCommandService studentCommandService, StudentQueryService studentQueryService) {
        this.studentCommandService = studentCommandService;
        this.studentQueryService = studentQueryService;
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentResource> getStudentById(@PathVariable Long studentId) {
        var getStudentByIdQuery = new GetStudentByIdQuery(studentId);
        var student = studentQueryService.handle(getStudentByIdQuery);
        if (student.isEmpty()) return ResponseEntity.badRequest().build();

        var studentResource = StudentResourceFromEntityAssembler.toResourceFromEntity(student.get());
        return ResponseEntity.ok(studentResource);
    }

    @PostMapping
    public ResponseEntity<StudentResource> createProfile(
            @RequestBody CreateStudentResource createStudentResource) {

        var createStudentCommand = CreateStudentCommandFromResourceAssembler
                .toCommandFromResource(createStudentResource);
        var student = studentCommandService.handle(createStudentCommand);

        if (student.isEmpty()) return ResponseEntity.badRequest().build();

        var studentResource = StudentResourceFromEntityAssembler.toResourceFromEntity(student.get());
        return ResponseEntity.ok(studentResource);
    }



}

