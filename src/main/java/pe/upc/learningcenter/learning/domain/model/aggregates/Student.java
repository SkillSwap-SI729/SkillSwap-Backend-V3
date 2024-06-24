package pe.upc.learningcenter.learning.domain.model.aggregates;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import pe.upc.learningcenter.learning.domain.model.valueobjects.AcmeStudentRecordId;
import pe.upc.learningcenter.learning.domain.model.valueobjects.ProfileId;
import pe.upc.learningcenter.learning.domain.model.valueobjects.ProfileId;
import pe.upc.learningcenter.shared.domain.model.aggregate.AuditableAbstractAggregateRoot;

@Entity
@Getter
public class Student extends AuditableAbstractAggregateRoot<Student> {

    @Embedded
    private ProfileId profileId;

    @Embedded
    private final AcmeStudentRecordId studentRecordId;


    public Student() {
        this.studentRecordId = new AcmeStudentRecordId();
        this.profileId = new ProfileId();
    }
    public Student(ProfileId profileId) {
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
