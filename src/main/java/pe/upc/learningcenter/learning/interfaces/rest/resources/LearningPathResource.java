package pe.upc.learningcenter.learning.interfaces.rest.resources;

import org.apache.commons.lang3.mutable.Mutable;

import java.util.List;

public record LearningPathResource(List<LearningPathItemResource> learningPathItemsResources) {
}
