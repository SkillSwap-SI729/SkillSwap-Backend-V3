package pe.upc.learningcenter.learning.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.upc.learningcenter.learning.domain.model.entities.Topic;
import pe.upc.learningcenter.learning.domain.model.queries.GetTopicByIdQuery;
import pe.upc.learningcenter.learning.domain.services.TopicQueryService;
import pe.upc.learningcenter.learning.infrastructure.persistence.jpa.repositories.TopicRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TopicQueryServiceImpl implements TopicQueryService {

    private final TopicRepository topicRepository;

    public TopicQueryServiceImpl(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public List<Topic> handle() {
        return topicRepository.findAll();
    }

    @Override
    public Optional<Topic> handle(GetTopicByIdQuery query) {
        return topicRepository.findById(query.id());
    }
}
