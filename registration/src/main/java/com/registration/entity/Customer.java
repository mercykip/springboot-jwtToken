package com.registration.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "customers",
uniqueConstraints = { 
		@UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email") 
	}
		)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
    private String username;
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "customer_roles", 
				joinColumns = @JoinColumn(name = "customerId"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer( String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
