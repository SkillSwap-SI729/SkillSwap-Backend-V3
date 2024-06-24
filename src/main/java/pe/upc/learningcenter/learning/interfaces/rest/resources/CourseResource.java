package pe.upc.learningcenter.learning.interfaces.rest.resources;

import java.util.List;

public record CourseResource(Long id,
                             String name,
                             String description,
                             String photoUrl,
                             Number cost,
                             Number rating,
                             Number nRatings,
                             Number nStudents,
                             Number nHours,
                             Long topicId,
                             Long instructorId,
                             LearningPathResource learningPathResource,
                             List<CourseCommentResource> courseCommentResources) {
}


