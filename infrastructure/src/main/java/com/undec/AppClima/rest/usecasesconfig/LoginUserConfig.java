package com.undec.AppClima.rest.usecasesconfig;

import com.undec.AppClima.input.ILoginInput;
import com.undec.AppClima.output.ILoginRepository;
import com.undec.AppClima.usecases.LoginUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoginUserConfig {
    ILoginRepository iLoginRepository;
    @Bean
    public ILoginInput iLoginInput(ILoginRepository iLoginRepository){
        return  new LoginUseCase(iLoginRepository);
    }

}
