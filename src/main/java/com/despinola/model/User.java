package com.despinola.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import validation.ValidPassword;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Schema(description = "User Model")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    @JsonIgnore
    private UUID uid;
    @NotBlank(message = "El nombre no puede estar vacío")
    @Schema(description = "Nombre del usuario", example = "Juan Rodriguez", required = true)
    private String name;
    @NotBlank(message = "El email no puede estar vacío")
    @Pattern(
            regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",
            message = "Formato de email no válido"
    )
    @Schema(description = "Correo electrónico del usuario", example = "juan@rodriguez.org", required = true)
    private String email;
    @NotBlank(message = "La contraseña no puede estar vacía")
    @ValidPassword
    @Schema(description = "Contraseña del usuario", example = "Abc12345$", required = true)
    private String password;
    @JsonIgnore
    @Schema(description = "Fecha de creación del usuario")
    private Date created;
    @JsonIgnore
    @Schema(description = "Fecha de última modificación")
    private Date modified;
    @JsonIgnore
    @Schema(description = "Token JWT generado")
    private String token;
    @JsonIgnore
    @Schema(description = "Indica si el usuario está activo")
    private Boolean isActive;
    @NotEmpty(message = "Debe incluir al menos un número de teléfono")
    @Schema(description = "Lista de teléfonos del usuario", required = true)
    private List<UserPhone> phones;
}
