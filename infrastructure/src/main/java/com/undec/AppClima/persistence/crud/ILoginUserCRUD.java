package com.undec.AppClima.persistence.crud;

import com.undec.AppClima.domain.User;
import com.undec.AppClima.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoginUserCRUD extends CrudRepository<UserEntity,Long> {
    UserEntity searchByName(String name);
}
