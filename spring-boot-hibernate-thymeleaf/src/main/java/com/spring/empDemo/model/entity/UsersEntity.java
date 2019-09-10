package com.spring.empDemo.model.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "TBL_USERS")
public class UsersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
   
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RolesEntity> roles;

    public UsersEntity() {
    }

    public UsersEntity(UsersEntity users) {
        this.roles = users.getRoles();
        this.name = users.getName();
        this.id = users.getId();
        this.password = users.getPassword();
    }
    
	/*
	 * public UsersEntity(String username, String password) { this.name = username;
	 * this.id = id; this.password = password; }
	 */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Set<RolesEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RolesEntity> roles) {
        this.roles = roles;
    }

	@Override
	public String toString() {
		return "UsersEntity [id=" + id + ", password=" + password + ", name=" + name + ", roles=" + roles + "]";
	}
    
    
}
