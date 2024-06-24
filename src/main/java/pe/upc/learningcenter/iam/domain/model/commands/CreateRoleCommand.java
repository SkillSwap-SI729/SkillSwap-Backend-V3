package pe.upc.learningcenter.iam.domain.model.commands;

import pe.upc.learningcenter.iam.domain.model.valueobjects.Roles;

public record CreateRoleCommand(Roles name) {
}
