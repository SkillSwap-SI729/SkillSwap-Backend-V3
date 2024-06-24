package pe.upc.learningcenter.profiles.domain.model.querys;

import pe.upc.learningcenter.profiles.domain.model.valueobjects.PersonName;

public record GetProfileByNameQuery(PersonName name) {
}