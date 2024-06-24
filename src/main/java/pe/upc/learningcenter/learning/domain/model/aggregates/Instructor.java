package pe.upc.learningcenter.learning.domain.model.aggregates;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import pe.upc.learningcenter.learning.domain.model.valueobjects.AcmeStudentRecordId;
import pe.upc.learningcenter.learning.domain.model.valueobjects.ProfileId;
import pe.upc.learningcenter.shared.domain.model.aggregate.AuditableAbstractAggregateRoot;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Instructor extends AuditableAbstractAggregateRoot<Instructor> {

    @Embedded
    private ProfileId profileId;

    @Embedded
    private final AcmeStudentRecordId studentRecordId;

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
    private List<Course> courses;

    public Instructor() {
        this.studentRecordId = new AcmeStudentRecordId();
        this.profileId = new ProfileId();
        this.courses = new ArrayList<>();
    }
    public Instructor(ProfileId profileId) {
        this();
        this.profileId = profileId;
    }

    public Long getProfileId(){
        return profileId.profileId();
    }

    public String getAcmeStudentRecordId(){
        return studentRecordId.studentRecordId();
    }

}
