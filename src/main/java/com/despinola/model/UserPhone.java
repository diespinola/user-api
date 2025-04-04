package com.despinola.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserPhone {
    private UUID uid;
    private String number;
    private String cityCode;
    private String countryCode;
}
