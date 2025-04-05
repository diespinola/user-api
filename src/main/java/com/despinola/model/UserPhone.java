package com.despinola.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserPhone {

    @JsonIgnore
    private UUID uid;
    @NotBlank(message = "El número no puede estar vacío")
    @Schema(description = "Número de teléfono", example = "1234567", required = true)
    private String number;
    @NotBlank(message = "El código de ciudad no puede estar vacío")
    @Schema(description = "Código de ciudad", example = "1", required = true)
    private String cityCode;
    @NotBlank(message = "El código de país no puede estar vacío")
    @Schema(description = "Código de país", example = "57", required = true)
    private String countryCode;
}
