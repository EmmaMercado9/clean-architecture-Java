package com.undec.AppClima.persistence.crud;

import com.undec.AppClima.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IModifyUserCRUD  extends CrudRepository<UserEntity,Long> {

    boolean existsByMail(String mail);
    boolean existsByName(String name);



}
