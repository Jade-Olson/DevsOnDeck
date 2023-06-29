package com.dojo.devsondeck.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")

public class User {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=1, message="First Name must not be blank!!")
	private String firstName;
	
	@NotNull
	@Size(min=1, message="Last Name must not be blank!!")
	private String lastName;
	
	@NotNull
	@Email(message="Must be a valid Email!")
	private String email;
	
	@NotNull
	@Size(min=1, message="Password must not be blank!!")
	private String password;
	
	@NotNull
	private String confirmPassword;
	
	@NotNull
	@Size(min=1, message="Address must not be blank!!")
	private String address;
	
	@NotNull
	@Size(min=1, message="City must not be blank!!")
	private String city;
	
	@NotNull
	@Size(min=1, message="Bio must not be blank!!")
	private String bio;
	
	@NotNull
	private String state;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
	
	@Column(updatable=true)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	@OneToMany(mappedBy="users", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<UserHasSkills> skills;
	
	public User() {}
	

	public List<UserHasSkills> getSkills() {
		return skills;
	}

	public void setSkills(List<UserHasSkills> skills) {
		this.skills = skills;
	}

	public Long getId() {
		return id;
	}
	

	public String getBio() {
		return bio;
	}


	public void setBio(String bio) {
		this.bio = bio;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreatedAt() {
		return createdAt;
	}


	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
}
