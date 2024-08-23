package com.undec.AppClima.persistence.mapper;

import com.undec.AppClima.domain.User;
import com.undec.AppClima.persistence.entity.UserEntity;
import com.undec.AppClima.persistence.exceptions.ExceptionUserMapper;

public class UserMapper {

    public static  User dataCoreMapper(UserEntity entity){

        try {
            return User.instance(
                    entity.getIdUser(),
                   entity.getName(),
                   entity.getMail(),
                   entity.getPassword(),
                   entity.getBirthdate(),
                   entity.getCountry()
            );

        }catch (Exception e){
            throw new ExceptionUserMapper("Error map Entity a Core");
        }

    }

    public static  UserEntity dataEntityMapper(User user){

        try {
            return new UserEntity(
                    user.getIdUser(),
                    user.getName(),
                    user.getMail(),
                    user.getPassword(),
                    user.getBirthdate(),
                    user.getCountry()
            );

        }catch (Exception e){
            throw new ExceptionUserMapper("Error map Core a Entity");
        }

    }
}
