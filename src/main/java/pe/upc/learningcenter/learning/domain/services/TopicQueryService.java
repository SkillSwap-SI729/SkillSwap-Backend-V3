package pe.upc.learningcenter.learning.domain.services;

import pe.upc.learningcenter.learning.domain.model.entities.Topic;
import pe.upc.learningcenter.learning.domain.model.queries.GetTopicByIdQuery;

import java.util.List;
import java.util.Optional;


public interface TopicQueryService {
    List<Topic> handle();
    Optional<Topic> handle(GetTopicByIdQuery query);
}
