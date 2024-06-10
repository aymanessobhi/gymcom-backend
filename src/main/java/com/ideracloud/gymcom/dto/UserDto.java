package com.ideracloud.gymcom.dto;

import com.ideracloud.gymcom.domain.User;
import lombok.Data;


@Data
public class UserDto extends BaseDto<UserDto>{
    Long id;
    String nom;
    String prenom;
    String username;
    String email;
    String tel;
    String password;

    public User getUserFromDto(){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setNom(nom);
        user.setPrenom(prenom);

        return user;
    }
}
