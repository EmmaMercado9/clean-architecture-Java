package com.undec.AppClima.usecases;
import com.undec.AppClima.domain.User;
import com.undec.AppClima.input.IGetAllUsersInput;
import com.undec.AppClima.output.IGetAllUsersRepository;
import java.util.Collection;
public class GetAllUsersUseCase implements IGetAllUsersInput {
    IGetAllUsersRepository iGetAllUsersRepository;
    public GetAllUsersUseCase(IGetAllUsersRepository iGetAllUsersRepository) {
        this.iGetAllUsersRepository = iGetAllUsersRepository;
    }
    @Override
    public Collection<User> getAllUsers() {
        return iGetAllUsersRepository.getAll();
    }
}