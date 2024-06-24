package pe.upc.learningcenter.learning.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.learningcenter.learning.domain.model.queries.GetTopicByIdQuery;
import pe.upc.learningcenter.learning.domain.services.TopicQueryService;
import pe.upc.learningcenter.learning.interfaces.rest.resources.TopicResource;
import pe.upc.learningcenter.learning.interfaces.rest.resources.TopicResource;
import pe.upc.learningcenter.learning.interfaces.rest.transform.TopicResourceFromEntityAssembler;
import pe.upc.learningcenter.learning.interfaces.rest.transform.TopicResourceFromEntityAssembler;

import java.util.List;


@RestController
@RequestMapping(value = "/api/v2/topics", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="Topic", description = "Topic management endpoints")
public class TopicController {
    
    private final TopicQueryService topicQueryService;

    public TopicController(TopicQueryService topicQueryService) {
        this.topicQueryService = topicQueryService;
    }
    
    @GetMapping
    public ResponseEntity<List<TopicResource>> getAll() {

        var topicResources = TopicResourceFromEntityAssembler
                .toResourcesFromEntities(topicQueryService.handle());
        return ResponseEntity.ok(topicResources);
    }

    @GetMapping("/{topicId}")
    public ResponseEntity<TopicResource> getTopicById(@PathVariable Long topicId) {
        var getTopicByIdQuery = new GetTopicByIdQuery(topicId);
        var topic = topicQueryService.handle(getTopicByIdQuery);
        if (topic.isEmpty()) return ResponseEntity.badRequest().build();

        var topicResource = TopicResourceFromEntityAssembler.toResourceFromEntity(topic.get());
        return ResponseEntity.ok(topicResource);
    }
    
}