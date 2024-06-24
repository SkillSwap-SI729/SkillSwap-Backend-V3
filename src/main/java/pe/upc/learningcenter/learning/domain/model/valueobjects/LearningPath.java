package pe.upc.learningcenter.learning.domain.model.valueobjects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import pe.upc.learningcenter.learning.domain.model.entities.LearningPathItem;

import java.util.ArrayList;
import java.util.List;

@Getter
@Embeddable
public class LearningPath {

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<LearningPathItem> learningPathItems;

    public LearningPath() {
        this.learningPathItems = new ArrayList<>();
    }

}
