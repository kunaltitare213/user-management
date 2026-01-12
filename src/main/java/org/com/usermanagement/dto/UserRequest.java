package org.com.usermanagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserRequest {

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEMail(){
        return email;
    }

    public void setEMail(String email) {
        this.email = email;
    }
}
