package pe.upc.learningcenter.learning.domain.model.valueobjects;

public record UserId(Long userId) {
    public UserId {
        if (userId<0){
            throw new IllegalArgumentException("userId cannot be negative");
        }
    }

    public UserId(){ this(0L); }
}
