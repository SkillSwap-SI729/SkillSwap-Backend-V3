package pe.upc.learningcenter.profiles.domain.model.querys;

import pe.upc.learningcenter.profiles.domain.model.valueobjects.PersonName;
import pe.upc.learningcenter.profiles.domain.model.valueobjects.UserId;

public record GetProfileByUserIdQuery(Long userId) {
}