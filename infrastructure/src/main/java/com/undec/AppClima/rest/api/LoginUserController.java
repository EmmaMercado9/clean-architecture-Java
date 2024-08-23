package com.undec.AppClima.rest.api;

import com.undec.AppClima.domain.User;
import com.undec.AppClima.input.ILoginInput;
import com.undec.AppClima.rest.model.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loggin")
public class LoginUserController {

    ILoginInput iLoginInput;
    public  LoginUserController(ILoginInput iLoginInput){
        this.iLoginInput=iLoginInput;
    }

    @PostMapping
    public ResponseEntity<?> loginUser(@RequestBody UserDTO userDTO){
        User user=userDTO.dtoToCore();
        boolean resultado=iLoginInput.LoginUser(user.getName(),user.getPassword());
        return ResponseEntity.ok().body(resultado);
    }
}
