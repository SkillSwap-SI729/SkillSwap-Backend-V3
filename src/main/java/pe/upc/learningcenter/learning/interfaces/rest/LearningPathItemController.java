package pe.upc.learningcenter.learning.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.learningcenter.learning.domain.model.queries.GetLearningPathItemByIdQuery;
import pe.upc.learningcenter.learning.domain.services.LearningPathItemQueryService;
import pe.upc.learningcenter.learning.domain.services.LearningPathItemCommandService;
import pe.upc.learningcenter.learning.interfaces.rest.resources.LearningPathItemResource;
import pe.upc.learningcenter.learning.interfaces.rest.resources.CreateLearningPathItemResource;
import pe.upc.learningcenter.learning.interfaces.rest.transform.LearningPathItemResourceFromEntityAssembler;
import pe.upc.learningcenter.learning.interfaces.rest.transform.CreateLearningPathItemCommandFromResourceAssembler;


@RestController
@RequestMapping(value = "/api/v2/learningPathItems", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="Learning Path Item", description = "Learning Path Item management endpoints")
public class LearningPathItemController {

    private final LearningPathItemCommandService learningPathItemCommandService;
    private final LearningPathItemQueryService learningPathItemQueryService;

    public LearningPathItemController(LearningPathItemCommandService learningPathItemCommandService, LearningPathItemQueryService learningPathItemQueryService) {
        this.learningPathItemCommandService = learningPathItemCommandService;
        this.learningPathItemQueryService = learningPathItemQueryService;
    }

    @GetMapping("/{learningPathItemId}")
    public ResponseEntity<LearningPathItemResource> getLearningPathItemById(@PathVariable Long learningPathItemId) {
        var getLearningPathItemByIdQuery = new GetLearningPathItemByIdQuery(learningPathItemId);
        var learningPathItem = learningPathItemQueryService.handle(getLearningPathItemByIdQuery);
        if (learningPathItem.isEmpty()) return ResponseEntity.badRequest().build();

        var learningPathItemResource = LearningPathItemResourceFromEntityAssembler.toResourceFromEntity(learningPathItem.get());
        return ResponseEntity.ok(learningPathItemResource);
    }

    @PostMapping
    public ResponseEntity<LearningPathItemResource> createLearningPathItem(
            @RequestBody CreateLearningPathItemResource createLearningPathItemResource) {

        var createLearningPatItemCommand = CreateLearningPathItemCommandFromResourceAssembler
                .toCommandFromResource(createLearningPathItemResource);
        var learningPathItem = learningPathItemCommandService.handle(createLearningPatItemCommand);

        if (learningPathItem.isEmpty()) return ResponseEntity.badRequest().build();

        var learningPathItemResource = LearningPathItemResourceFromEntityAssembler.toResourceFromEntity(learningPathItem.get());
        return ResponseEntity.ok(learningPathItemResource);
    }

}
