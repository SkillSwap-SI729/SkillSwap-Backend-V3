package pe.upc.learningcenter.profiles.domain.model.querys;

import pe.upc.learningcenter.profiles.domain.model.valueobjects.EmailAddress;

public record GetProfileByEmailQuery(EmailAddress emailAddress) {
}
