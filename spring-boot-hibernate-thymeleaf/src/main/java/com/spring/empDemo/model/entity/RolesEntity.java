package com.spring.empDemo.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "TBL_ROLE")
public class RolesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int roleId;

    @Column(name = "role")
    private String role;

    public RolesEntity() {
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

	@Override
	public String toString() {
		return "RoleEntity [roleId=" + roleId + ", role=" + role + "]";
	}
    
}
