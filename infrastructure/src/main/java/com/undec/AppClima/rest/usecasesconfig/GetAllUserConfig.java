package com.undec.AppClima.rest.usecasesconfig;

import com.undec.AppClima.input.IGetAllUsersInput;
import com.undec.AppClima.output.IGetAllUsersRepository;
import com.undec.AppClima.usecases.GetAllUsersUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetAllUserConfig {

    @Bean
    public IGetAllUsersInput getAllUsersInput (IGetAllUsersRepository repo){
        return new GetAllUsersUseCase(repo);
    }
}
