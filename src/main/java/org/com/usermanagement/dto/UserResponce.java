package org.com.usermanagement.dto;

public class UserResponce {
    private int id;
    private String name;

    public UserResponce(int id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
