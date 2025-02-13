package com.tekion.aec.cp.imsjobs.controller.ContestLeaderBoard.models;

/**
 * @author anju
 * @created on 02/08/24 and 2:21 PM
 */
public class User {
    String name;
    UserDepartment department;

    public User(String name, UserDepartment department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDepartment getDepartment() {
        return department;
    }

    public void setDepartment(UserDepartment department) {
        this.department = department;
    }
}
