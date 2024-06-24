package pe.upc.learningcenter.learning.interfaces.rest.resources;

import java.util.List;

public record InstructorResource(Long id, Long profileId, String acmeStudentRecordId,
                                 List<CourseResource> coursesResources) {
}
