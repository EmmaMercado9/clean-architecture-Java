package com.undec.AppClima.rest.api;

import com.undec.AppClima.input.ICreateAccountUserInput;
import com.undec.AppClima.rest.model.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class CreateUserController {

    ICreateAccountUserInput iCreateAccountUserInput;
    public CreateUserController(ICreateAccountUserInput iCreateAccountUserInput ){
        this.iCreateAccountUserInput=iCreateAccountUserInput;
    }

    @PostMapping()
    public ResponseEntity<?> createUser(@RequestBody UserDTO user){
        boolean result= iCreateAccountUserInput.createUser(user.dtoToCore());
        return  ResponseEntity.ok().body(result);
    }
}
