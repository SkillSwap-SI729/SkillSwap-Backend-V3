package pe.upc.learningcenter.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
public record UserId(Long userId) {
    public UserId {
        if (userId<0){
            throw new IllegalArgumentException("userId cannot be negative");
        }
    }

    public UserId(){ this(0L); }
}