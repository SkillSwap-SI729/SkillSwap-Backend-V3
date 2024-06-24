package pe.upc.learningcenter.learning.interfaces.rest.transform;

import pe.upc.learningcenter.learning.domain.model.entities.Topic;
import pe.upc.learningcenter.learning.interfaces.rest.resources.LimitedTopicResource;
import pe.upc.learningcenter.learning.interfaces.rest.resources.TopicResource;

import java.util.ArrayList;
import java.util.List;

public class TopicResourceFromEntityAssembler {

    public static LimitedTopicResource toLimitedResourceFromEntity(Topic entity) {
        return new LimitedTopicResource(entity.getId(), entity.getName());
    }

    public static TopicResource toResourceFromEntity(Topic entity) {
        return new TopicResource(entity.getId(), entity.getName(),
                CourseResourceFromEntityAssembler.toResourcesFromEntities(entity.getCourses()));
    }

    public static List<TopicResource> toResourcesFromEntities(List<Topic> topics) {

        List<TopicResource> topicResources = new ArrayList<>();;

        for (Topic topic : topics) {
            topicResources.add(toResourceFromEntity(topic));
        }
        return topicResources;
    }
}
