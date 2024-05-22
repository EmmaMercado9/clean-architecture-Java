package com.undec.AppClima.usecases;
import com.undec.AppClima.domain.User;
import com.undec.AppClima.exeptions.User.ExceptionModifyUserIncorrect;
import com.undec.AppClima.input.IModifyUserInput;
import com.undec.AppClima.output.IModifyUserRepository;
public class ModifyUserUseCase implements IModifyUserInput {
    IModifyUserRepository iModifyUserRepository;
    public ModifyUserUseCase(IModifyUserRepository iModifyUserRepository){
        this.iModifyUserRepository=iModifyUserRepository;
    }
    @Override
    public boolean ModifyUser(User newUser,int idCurrentUser) throws ExceptionModifyUserIncorrect {
        User currentUser = iModifyUserRepository.get_Current_User(idCurrentUser);
        if (iModifyUserRepository.userMailExist(newUser.getMail())) {
            throw new ExceptionModifyUserIncorrect("El mail ya existe ingrese otro");
        }
        if (iModifyUserRepository.userNameExist(newUser.getName())) {
            throw new ExceptionModifyUserIncorrect("El nombre de Usuario ingresado ya existe, Ingrese otro!!!");
        }
        if(!currentUser.getName().equals(newUser.getName())){
            currentUser.setName(newUser.getName());
        }
        if(!currentUser.getMail().equals(newUser.getMail())){
            currentUser.setMail(newUser.getMail());
        }
        if(!currentUser.getPassword().equals(newUser.getPassword())){
            currentUser.setPassword(newUser.getPassword());
        }
        return iModifyUserRepository.modifyUser(currentUser,idCurrentUser);
    }
}