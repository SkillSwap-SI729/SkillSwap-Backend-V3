package pe.upc.learningcenter.profiles.interfaces.rest.transform;

import pe.upc.learningcenter.learning.domain.model.aggregates.Student;
import pe.upc.learningcenter.learning.interfaces.rest.resources.StudentResource;
import pe.upc.learningcenter.profiles.domain.model.aggregates.Profile;
import pe.upc.learningcenter.profiles.interfaces.rest.resources.ProfileResource;

import java.util.ArrayList;
import java.util.List;

public class ProfileResourceFromEntityAssembler {
    public static ProfileResource toResourceFromEntity(Profile entity) {
        return new ProfileResource(entity.getId(), entity.getUserId().userId(),
                entity.getFullName(), entity.getEmail().emailAddress(),
                entity.getPhotoUrl(), entity.getRanking(), entity.getNumberCourses(),
                entity.getAboutMe(),
                entity.getSlogan(),
                entity.getNRatings(),
                entity.getNStudents(), entity.getProfileType());
    }

    public static List<ProfileResource> toResourcesFromEntities(List<Profile> profiles) {

        List<ProfileResource> profileResources = new ArrayList<>();;

        for (Profile profile : profiles) {
            profileResources.add(toResourceFromEntity(profile));
        }
        return profileResources;
    }
}
