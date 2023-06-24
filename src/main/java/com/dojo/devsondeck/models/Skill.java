package com.dojo.devsondeck.models;

import java.util.Date;
import java.util.List;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="skills")
public class Skill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String SkillName;
	
	@NotNull
	private String SkillType;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
	
	@Column(updatable=true)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	@OneToMany(mappedBy="skills", fetch = FetchType.LAZY)
    private List<UserHasSkills> users;
	
	@OneToMany(mappedBy="skills",fetch = FetchType.LAZY)
	private List<PositionNeededSkills> position;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSkillName() {
		return SkillName;
	}

	public void setSkillName(String skillName) {
		SkillName = skillName;
	}

	public String getSkillType() {
		return SkillType;
	}

	public void setSkillType(String skillType) {
		SkillType = skillType;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	

	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	public List<UserHasSkills> getUsers() {
		return users;
	}

	public void setUsers(List<UserHasSkills> users) {
		this.users = users;
	}

	public List<PositionNeededSkills> getPosition() {
		return position;
	}

	public void setPosition(List<PositionNeededSkills> position) {
		this.position = position;
	}
 	
	
}
