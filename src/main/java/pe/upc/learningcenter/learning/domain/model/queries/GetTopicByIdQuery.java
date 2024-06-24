package pe.upc.learningcenter.learning.domain.model.queries;

public record GetTopicByIdQuery(Long id) {
    public GetTopicByIdQuery {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        if (id < 0) {
            throw new IllegalArgumentException("id cannot be negative");
        }
    }
}
