package com.undec.AppClima.rest.usecasesconfig;

import com.undec.AppClima.input.IModifyUserInput;
import com.undec.AppClima.output.IModifyUserRepository;
import com.undec.AppClima.usecases.ModifyUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModifyUserConfig {
    IModifyUserRepository iModifyUserRepository;
    @Bean
    public IModifyUserInput iModifyUserInput(IModifyUserRepository repo){
        return  new ModifyUserUseCase(repo);
    }
}
