package com.undec.AppClima.persistence.useCases;

import com.undec.AppClima.domain.User;
import com.undec.AppClima.output.ILoginRepository;
import com.undec.AppClima.persistence.crud.ILoginUserCRUD;
import com.undec.AppClima.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class LoginUserRepoImpl implements ILoginRepository {
    @Autowired
    ILoginUserCRUD iLoginUserCRUD;
    @Override
    public User searchUserByName(String userName) {

        return  UserMapper.dataCoreMapper(iLoginUserCRUD.searchByName(userName));
    }
}
