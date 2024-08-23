package com.undec.AppClima.rest.api;

import com.undec.AppClima.domain.User;
import com.undec.AppClima.input.IGetAllUsersInput;
import com.undec.AppClima.rest.model.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/getAll")
public class GetAllUserController {
    IGetAllUsersInput iGetAllUsersInput;

    public GetAllUserController(IGetAllUsersInput iGetAllUsersInput){
        this.iGetAllUsersInput=iGetAllUsersInput;
    }

    @GetMapping()

    public ResponseEntity<List<UserDTO>> GetAllUsers(){
        Collection<User> list=iGetAllUsersInput.getAllUsers();

        List<UserDTO> list1=list.stream().map(UserDTO::coreToDTO).toList();

        if (!list1.isEmpty()) {
            return ResponseEntity.ok(list1);
        } else {
            return ResponseEntity.noContent().build();
        }
    }


}
