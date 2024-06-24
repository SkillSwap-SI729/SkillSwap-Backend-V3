package pe.upc.learningcenter.learning.interfaces.rest.transform;

import pe.upc.learningcenter.learning.domain.model.aggregates.Course;
import pe.upc.learningcenter.learning.domain.model.valueobjects.LearningPath;
import pe.upc.learningcenter.learning.interfaces.rest.resources.CourseResource;
import pe.upc.learningcenter.learning.interfaces.rest.resources.LearningPathItemResource;
import pe.upc.learningcenter.learning.interfaces.rest.resources.LearningPathResource;

import java.util.*;

public class LearningPathResourceFromValueObjectAssembler {

    public static LearningPathResource toResourceFromValueObject(LearningPath valueObject) {
        //if(valueObject.getLearningPathItems() == null) return null;

        List<LearningPathItemResource> learningPathItemsResources = new ArrayList<>();;
        LearningPathResource learningPathResource =
                new LearningPathResource(learningPathItemsResources);

        for (int i = 0; i < valueObject.getLearningPathItems().size(); i++){
            learningPathResource.learningPathItemsResources().add(new
                    LearningPathItemResource(valueObject.getLearningPathItems().get(i).getId(),
                    valueObject.getLearningPathItems().get(i).getName(),
                    valueObject.getLearningPathItems().get(i).getTime(),
                    valueObject.getLearningPathItems().get(i).getCourse().getId(),
                    valueObject.getLearningPathItems().get(i).getNLessons(),
                    LessonResourceFromEntityAssembler.toResourcesFromEntities
                            (valueObject.getLearningPathItems().get(i).getLessons())));
        }

        return learningPathResource;
    }
}
