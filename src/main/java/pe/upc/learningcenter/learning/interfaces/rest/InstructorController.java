package pe.upc.learningcenter.learning.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.learningcenter.learning.domain.model.queries.GetInstructorByIdQuery;
import pe.upc.learningcenter.learning.domain.model.queries.GetInstructorByProfileIdQuery;
import pe.upc.learningcenter.learning.domain.model.valueobjects.ProfileId;
import pe.upc.learningcenter.learning.domain.services.InstructorQueryService;
import pe.upc.learningcenter.learning.domain.services.InstructorCommandService;
import pe.upc.learningcenter.learning.domain.services.TopicQueryService;
import pe.upc.learningcenter.learning.infrastructure.persistence.jpa.repositories.InstructorRepository;
import pe.upc.learningcenter.learning.interfaces.rest.resources.*;
import pe.upc.learningcenter.learning.interfaces.rest.resources.InstructorResource;
import pe.upc.learningcenter.learning.interfaces.rest.transform.*;
import pe.upc.learningcenter.learning.interfaces.rest.transform.InstructorResourceFromEntityAssembler;
import pe.upc.learningcenter.profiles.domain.model.querys.GetProfileByEmailQuery;
import pe.upc.learningcenter.profiles.domain.model.valueobjects.EmailAddress;
import pe.upc.learningcenter.profiles.interfaces.rest.transform.ProfileResourceFromEntityAssembler;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v2/instructors", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="Instructor", description = "Instructor management endpoints")
public class InstructorController {

    private final InstructorQueryService instructorQueryService;
    private final InstructorCommandService instructorCommandService;
    
    public InstructorController(InstructorCommandService instructorCommandService, InstructorQueryService instructorQueryService) {
        this.instructorCommandService = instructorCommandService;
        this.instructorQueryService = instructorQueryService;
    }

    @GetMapping
    public ResponseEntity<List<InstructorResource>> getAll() {

        var instructorResources = InstructorResourceFromEntityAssembler
                .toResourcesFromEntities(instructorQueryService.handle());
        return ResponseEntity.ok(instructorResources);
    }
    @GetMapping("/{instructorId}")
    public ResponseEntity<InstructorResource> getInstructorById(@PathVariable Long instructorId) {
        var getInstructorByIdQuery = new GetInstructorByIdQuery(instructorId);
        var instructor = instructorQueryService.handle(getInstructorByIdQuery);
        if (instructor.isEmpty()) return ResponseEntity.badRequest().build();

        var instructorResource = InstructorResourceFromEntityAssembler.toResourceFromEntity(instructor.get());
        return ResponseEntity.ok(instructorResource);
    }

    @GetMapping("/profileId/{profileId}")
    public ResponseEntity<InstructorResource> getInstructorByProfileId(@PathVariable Long profileId) {
        var getInstructorByProfileIdQuery
                = new GetInstructorByProfileIdQuery(new ProfileId(profileId));
        var instructor = instructorQueryService.handle(getInstructorByProfileIdQuery);
        if (instructor.isEmpty()) return ResponseEntity.badRequest().build();

        var instructorResource = InstructorResourceFromEntityAssembler.toResourceFromEntity(instructor.get());
        return ResponseEntity.ok(instructorResource);
    }

    @PostMapping
    public ResponseEntity<InstructorResource> createProfile(
            @RequestBody CreateInstructorResource createInstructorResource) {

        var createInstructorCommand = CreateInstructorCommandFromResourceAssembler
                .toCommandFromResource(createInstructorResource);
        var instructor = instructorCommandService.handle(createInstructorCommand);

        if (instructor.isEmpty()) return ResponseEntity.badRequest().build();

        var instructorResource = InstructorResourceFromEntityAssembler.toResourceFromEntity(instructor.get());
        return ResponseEntity.ok(instructorResource);
    }

}