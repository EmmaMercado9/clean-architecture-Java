package com.undec.AppClima.usecases;
import com.undec.AppClima.Utils.CkeckName;
import com.undec.AppClima.domain.User;
import com.undec.AppClima.exeptions.User.ExceptionModifyUserIncorrect;
import com.undec.AppClima.input.IModifyUserInput;
import com.undec.AppClima.output.IModifyUserRepository;

import java.util.Objects;

public class ModifyUserUseCase implements IModifyUserInput {
    IModifyUserRepository iModifyUserRepository;
    public ModifyUserUseCase(IModifyUserRepository iModifyUserRepository){
        this.iModifyUserRepository=iModifyUserRepository;
    }
    @Override
    public boolean ModifyUser(String name,String pass,String mail, Long idCurrentUser) throws ExceptionModifyUserIncorrect {
        User currentUser = iModifyUserRepository.get_Current_User(idCurrentUser);


        if (iModifyUserRepository.userMailExist(mail) && !Objects.equals(currentUser.getIdUser(), idCurrentUser)) {
            throw new ExceptionModifyUserIncorrect("El mail ya existe ingrese otro");
        }
        if (iModifyUserRepository.userNameExist(name)&& !Objects.equals(currentUser.getIdUser(), idCurrentUser)) {
            throw new ExceptionModifyUserIncorrect("El nombre de Usuario ingresado ya existe, Ingrese otro!!!");
        }
        currentUser.edit(name,pass,mail);
        return iModifyUserRepository.modifyUser(currentUser,idCurrentUser);
    }
}