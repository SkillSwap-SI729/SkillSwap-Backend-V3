package pe.upc.learningcenter.learning.interfaces.rest.resources;

import java.util.List;

public record TopicResource(Long id, String name, List<CourseResource> coursesResources) {
}