package com.undec.AppClima.persistence.useCases;

import com.undec.AppClima.domain.User;
import com.undec.AppClima.output.IModifyUserRepository;
import com.undec.AppClima.persistence.crud.IModifyUserCRUD;
import com.undec.AppClima.persistence.entity.UserEntity;
import com.undec.AppClima.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModifyUserRepoImpl implements IModifyUserRepository {

    @Autowired
    IModifyUserCRUD iModifyUserCRUD;
    @Override
    public boolean userMailExist(String mail) {
        return iModifyUserCRUD.existsByMail(mail);
    }

    @Override
    public boolean userNameExist(String userName) {
        return iModifyUserCRUD.existsByName(userName);
    }

    @Override
    public User get_Current_User(Long idCurrentUser) {
        UserEntity userEntity=iModifyUserCRUD.findById(idCurrentUser).orElse(null);
        return UserMapper.dataCoreMapper(userEntity);
    }

    @Override
    public boolean modifyUser(User user, Long idCurrentUser) {
        UserEntity userEntity=iModifyUserCRUD.findById(idCurrentUser).orElse(null);
        if(userEntity!=null) {
            userEntity.setName(user.getName());
            userEntity.setMail(user.getMail());
            userEntity.setPassword(user.getPassword());
            userEntity.setBirthdate(user.getBirthdate());
            userEntity.setCountry(user.getCountry());
            iModifyUserCRUD.save(userEntity);
            return true;
        }
        return false;
    }

}
