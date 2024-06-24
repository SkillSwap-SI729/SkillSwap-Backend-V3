package pe.upc.learningcenter.learning.interfaces.rest.resources;

import pe.upc.learningcenter.learning.domain.model.aggregates.Course;

public record CourseCommentResource(Long id,String content, Number rating,
                                    String timeAgo, Long courseId, String profilePhotoUrl,
                                    String username) {
}
