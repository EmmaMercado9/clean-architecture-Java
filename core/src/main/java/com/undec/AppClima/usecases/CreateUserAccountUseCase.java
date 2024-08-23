package com.undec.AppClima.usecases;
import com.undec.AppClima.domain.User;
import com.undec.AppClima.exeptions.User.ExceptionUserExist;
import com.undec.AppClima.exeptions.User.ExceptionUserNameExist;
import com.undec.AppClima.input.ICreateAccountUserInput;
import com.undec.AppClima.output.ICreateAccountUserRepository;
public class CreateUserAccountUseCase implements ICreateAccountUserInput {
    ICreateAccountUserRepository iCreateAccountUserRepository;
    public CreateUserAccountUseCase(ICreateAccountUserRepository iCreateAccountUserRepository){
        this.iCreateAccountUserRepository = iCreateAccountUserRepository;
    }
    @Override
    public boolean createUser(User user){
        if(iCreateAccountUserRepository.UserExist(user.getMail())){
            throw new ExceptionUserExist("El usuario ya existe");
        }
        if(iCreateAccountUserRepository.userNameExist(user.getName())){
                throw new ExceptionUserNameExist("El nombre de Usuario ingresado ya existe, Ingrese otro!!!");
        }
        return iCreateAccountUserRepository.SaveUser(user);
    }
}