package pe.upc.learningcenter.rating.domain.model.valueObjects;

public record CourseId(Long courseId) {
    public CourseId {
        if (courseId<0){
            throw new IllegalArgumentException("courseId cannot be negative");
        }
    }

    public CourseId(){ this(0L); }
}
