package pe.upc.learningcenter.profiles.domain.model.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.With;
import pe.upc.learningcenter.profiles.domain.model.commands.CreateProfileCommand;
import pe.upc.learningcenter.profiles.domain.model.valueobjects.EmailAddress;
import pe.upc.learningcenter.profiles.domain.model.valueobjects.PersonName;
import pe.upc.learningcenter.profiles.domain.model.valueobjects.UserId;
import pe.upc.learningcenter.shared.domain.model.aggregate.AuditableAbstractAggregateRoot;

import java.util.HashSet;

@Entity
@Getter
@Setter
@Table(name = "profiles")
public class Profile extends AuditableAbstractAggregateRoot<Profile> {

    @Embedded
    private UserId userId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "first_name")),
            @AttributeOverride(name = "lastName", column = @Column(name = "last_name"))})
    PersonName personName;

    @Embedded
    EmailAddress email;

    @NotBlank
    private String photoUrl;

    @NotNull
    private Number ranking;

    private String numberCourses;
    @NotBlank
    private String aboutMe;
    @NotBlank
    private String slogan;

    private Number nRatings;

    private Number nStudents;
    private String profileType;


    public Profile() {
    }

    public Profile(CreateProfileCommand command, UserId userId) {
        this.personName = new PersonName(command.firstName(), command.lastName());
        this.email = new EmailAddress(command.email());
        this.photoUrl = command.photoUrl();
        this.ranking = command.ranking();
        this.numberCourses = command.numberCourses();
        this.aboutMe = command.aboutMe();
        this.slogan = command.slogan();
        this.nRatings = command.nRatings();
        this.nStudents = command.nStudents();
        this.userId = userId;
        this.profileType = command.profileType();
    }

    public String getFullName(){
        return personName.getFullName();
    }
}
