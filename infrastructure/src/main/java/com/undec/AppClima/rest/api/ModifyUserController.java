package com.undec.AppClima.rest.api;

import com.undec.AppClima.domain.User;
import com.undec.AppClima.input.IModifyUserInput;
import com.undec.AppClima.rest.model.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/modify")
public class ModifyUserController {
    IModifyUserInput iModifyUserInput;


    public  ModifyUserController(IModifyUserInput iModifyUserInput){
        this.iModifyUserInput=iModifyUserInput;
    }

    @PutMapping
    public ResponseEntity<?> modifyUser(@RequestBody UserDTO userDTO) {
        User user=userDTO.dtoToCore();
        boolean result = iModifyUserInput.ModifyUser(user.getName(),user.getPassword(),user.getMail(),user.getIdUser());
        return ResponseEntity.ok().body(result);
    }

}
