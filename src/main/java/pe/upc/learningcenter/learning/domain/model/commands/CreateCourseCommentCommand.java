package pe.upc.learningcenter.learning.domain.model.commands;

public record CreateCourseCommentCommand (Long profileId, Long courseId,String content,
                                         Number rating, String timeAgo){
}
