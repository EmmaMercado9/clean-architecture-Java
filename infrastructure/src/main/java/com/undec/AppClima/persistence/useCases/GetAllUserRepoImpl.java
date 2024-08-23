package com.undec.AppClima.persistence.useCases;

import com.undec.AppClima.domain.User;
import com.undec.AppClima.output.IGetAllUsersRepository;
import com.undec.AppClima.persistence.crud.IGetAllUserCRUD;
import com.undec.AppClima.persistence.entity.UserEntity;
import com.undec.AppClima.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class GetAllUserRepoImpl implements IGetAllUsersRepository {
    @Autowired
    IGetAllUserCRUD iGetAllUserCRUD;
    @Override
    public Collection<User> getAll() {
        Iterable<UserEntity>  userEntities = iGetAllUserCRUD.findAll();
        return StreamSupport.stream(userEntities.spliterator(),false).map(UserMapper::dataCoreMapper).collect(Collectors.toList());
    }
}
