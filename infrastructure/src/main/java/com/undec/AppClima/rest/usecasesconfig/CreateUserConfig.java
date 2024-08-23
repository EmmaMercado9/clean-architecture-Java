package com.undec.AppClima.rest.usecasesconfig;

import com.undec.AppClima.input.ICreateAccountUserInput;
import com.undec.AppClima.output.ICreateAccountUserRepository;
import com.undec.AppClima.usecases.CreateUserAccountUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateUserConfig {

    @Bean
    public ICreateAccountUserInput createUserInput(ICreateAccountUserRepository repo){
        return new CreateUserAccountUseCase(repo);

    }
}
