package com.despinola.mapper;

import com.despinola.entities.UserEntity;
import com.despinola.entities.UserPhonesEntity;
import com.despinola.model.User;
import com.despinola.model.UserPhone;
import com.despinola.model.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toModel(UserEntity entity);
    UserEntity toEntity(User model);

    UserPhone toModel(UserPhonesEntity entity);
    UserPhonesEntity toEntity(UserPhone model);

    List<UserPhone> toPhoneModels(List<UserPhonesEntity> entities);
    List<UserPhonesEntity> toPhoneEntities(List<UserPhone> models);

    UserResponse toUserResponse(UserEntity user);

}
