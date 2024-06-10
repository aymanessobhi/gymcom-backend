package com.ideracloud.gymcom.dto;

import lombok.Data;

@Data
public class UserSearchDto implements SearchDto<UserSearchDto>{
    Long id;
    String nom;
    String prenom;
    String username;
    String email;
    String tel;
}
