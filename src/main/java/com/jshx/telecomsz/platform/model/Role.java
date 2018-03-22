package com.jshx.telecomsz.platform.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

/**
 * Created with Intellij IDEA by 王金 on 2018/3/14 16:09.
 *
 * @author 王金
 * @version 1.0
 */
@JsonIdentityInfo(generator=JSOGGenerator.class)
public class Role extends BaseDomain {

    private String roleName;

    private String roleCode;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
