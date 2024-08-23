package com.undec.AppClima.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.undec.AppClima.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@Data

public class UserDTO {

    private Long idUser;
    @JsonProperty(value="name")
    private String name;

    @JsonProperty(value="mail")
    private String mail;

    @JsonProperty(value="password")
    private String password;

    @JsonProperty(value="birthdate")
    private LocalDate birthdate;

    @JsonProperty(value="country")
    private String country;

    public  User dtoToCore(){
        return User.instance(
                this.getIdUser()
                ,this.getName()
                ,this.getMail(),
                this.getPassword(),
                this.getBirthdate(),
                this.getCountry()
        );
    }
    public static UserDTO coreToDTO(User user){
        return new UserDTO(user.getIdUser(), user.getName(), user.getMail(), user.getPassword(), user.getBirthdate(),user.getCountry());
    }

}
