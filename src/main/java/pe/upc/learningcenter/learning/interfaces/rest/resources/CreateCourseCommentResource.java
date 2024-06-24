package pe.upc.learningcenter.learning.interfaces.rest.resources;

public record CreateCourseCommentResource(Long profileId, Long courseId,String content,
                                    Number rating, String timeAgo) {
}
