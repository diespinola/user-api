package com.despinola.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import validation.ValidPassword;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class User {
    private UUID uid;
    private String name;
    @NotBlank(message = "El email no puede estar vacío")
    @Pattern(
            regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",
            message = "Formato de email no válido"
    )
    private String email;
    @ValidPassword
    private String password;
    private Date created;
    private Date modified;
    private String token;
    private Boolean isActive;
    private List<UserPhone> phones;
}
