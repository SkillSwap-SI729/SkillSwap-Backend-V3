package pe.upc.learningcenter.learning.interfaces.rest.resources;

import pe.upc.learningcenter.learning.domain.model.valueobjects.LearningPath;

public record CreateCourseResource(
                                   String name,
                                   String photoUrl,
                                   String description,
                                   Number cost,
                                   Number rating,
                                   Number nRatings,
                                   Number nStudents,
                                   Number nHours,
                                   String topicName,
                                   Long instructorId) {
}
