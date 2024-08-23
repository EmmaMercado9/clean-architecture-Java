package com.undec.AppClima.persistence.useCases;

import com.undec.AppClima.domain.User;
import com.undec.AppClima.output.ICreateAccountUserRepository;
import com.undec.AppClima.persistence.crud.ICreateAccountUserCRUD;
import com.undec.AppClima.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class CreateAccountUserRepoImpl implements ICreateAccountUserRepository {

    ICreateAccountUserCRUD iCreateAccountUserCRUD;

    @Autowired
    public  CreateAccountUserRepoImpl(ICreateAccountUserCRUD iCreateAccountUserCRUD){
        this.iCreateAccountUserCRUD=iCreateAccountUserCRUD;
    }
    @Override
    public boolean UserExist(String mail) {
        return iCreateAccountUserCRUD.existsByMail(mail);
    }

    @Override
    public boolean userNameExist(String userName) {
        return iCreateAccountUserCRUD.existsByName(userName);
    }

    @Override
    public boolean SaveUser(User user) {
        UserEntity userEntity=new UserEntity();
        userEntity.setName(user.getName());
        userEntity.setMail(user.getMail());
        userEntity.setPassword(user.getPassword());
        userEntity.setBirthdate(user.getBirthdate());
        userEntity.setCountry(user.getCountry());
        return this.iCreateAccountUserCRUD.save(userEntity).getIdUser()!=null;
    }
}
