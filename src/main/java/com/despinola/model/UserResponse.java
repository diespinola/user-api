package com.despinola.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Schema(description = "User Response")
public class UserResponse {
    @Schema(description = "Identificador único del usuario", example = "6107c6a9-2c37-4858-946e-2cf732306ed6")
    private UUID uid;

    @Schema(description = "Nombre completo del usuario", example = "Juan Rodriguez")
    private String name;

    @Schema(description = "Correo electrónico del usuario", example = "juan@rodriguez.org")
    private String email;

    @Schema(description = "Contraseña del usuario", example = "hunter2")
    private String password;

    @Schema(description = "Fecha de creación", example = "2025-04-04T17:14:36.906+00:00")
    private Date created;

    @Schema(description = "Fecha de modificación", example = "2025-04-04T17:14:36.906+00:00")
    private Date modified;

    @Schema(description = "Token JWT asignado al usuario")
    private String token;

    @Schema(description = "Indica si el usuario está activo", example = "true")
    private Boolean isActive;

    @Schema(description = "Lista de teléfonos del usuario")
    private List<UserPhoneResponse> phones;
}
