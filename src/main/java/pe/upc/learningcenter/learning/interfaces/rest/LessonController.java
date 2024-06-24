package pe.upc.learningcenter.learning.interfaces.rest;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.upc.learningcenter.learning.domain.services.LessonCommandService;
import pe.upc.learningcenter.learning.interfaces.rest.resources.CreateLessonResource;
import pe.upc.learningcenter.learning.interfaces.rest.resources.LessonResource;
import pe.upc.learningcenter.learning.interfaces.rest.transform.CreateLessonCommandFromResourceAssembler;
import pe.upc.learningcenter.learning.interfaces.rest.transform.LessonResourceFromEntityAssembler;

@RestController
@RequestMapping(value = "/api/v2/lessons", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="Lesson", description = "Learning Path Item management endpoints")
public class LessonController {

    private final LessonCommandService lessonCommandService;

    public LessonController(LessonCommandService lessonCommandService) {

        this.lessonCommandService = lessonCommandService;
    }


    @PostMapping
    public ResponseEntity<LessonResource> createLesson(
            @RequestBody CreateLessonResource createLessonResource) {

        var createLearningPatItemCommand = CreateLessonCommandFromResourceAssembler
                .toCommandFromResource(createLessonResource);
        var lesson = lessonCommandService.handle(createLearningPatItemCommand);

        if (lesson.isEmpty()) return ResponseEntity.badRequest().build();

        var lessonResource = LessonResourceFromEntityAssembler.toResourceFromEntity(lesson.get());
        return ResponseEntity.ok(lessonResource);
    }

}