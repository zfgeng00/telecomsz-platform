package com.jshx.telecomsz.platform.model;

/**
 * Created with Intellij IDEA by 王金 on 2018/3/14 14:39.
 */
public class UserRole extends BaseDomain {

    private User user;

    private Role role;

    public UserRole() {
    }

    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
