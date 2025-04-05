package com.despinola.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Schema(description = "Teléfono del usuario")
public class UserPhoneResponse {
    @Schema(description = "Identificador único del teléfono", example = "e0e54328-ee41-4e0a-bab1-09b33e8fcc80")
    private UUID uid;

    @Schema(description = "Número de teléfono", example = "1234567")
    private String number;

    @Schema(description = "Código de ciudad", example = "1")
    private String cityCode;

    @Schema(description = "Código de país", example = "57")
    private String countryCode;
}
