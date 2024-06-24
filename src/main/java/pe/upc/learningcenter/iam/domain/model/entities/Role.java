package pe.upc.learningcenter.iam.domain.model.entities;

import jakarta.persistence.*;
import lombok.*;
import pe.upc.learningcenter.iam.domain.model.valueobjects.Roles;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    @Getter
    private Roles name;

    public Role(Roles name) {
        this.name = name;
    }

    public String getStringName(){
        return name.name();
    }

    public static Role getDefaultRole() {
        return new Role(Roles.ROLE_STUDENT);
    }

    public static List<Role> validateRoleSet(List<Role> roles) {
        if (roles == null || roles.isEmpty()) {
            return List.of(getDefaultRole());
        }
        return roles;
    }

}
