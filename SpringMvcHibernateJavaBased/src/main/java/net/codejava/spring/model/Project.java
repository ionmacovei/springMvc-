package net.codejava.spring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.Hibernate;



@Entity
public class Project {

	private Integer id;
	private String name;
	private String discription;
	private List<User> users;
	
	@Id
	@GeneratedValue
	@Column(name = "PROJECT_ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "discription")
	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	@ManyToMany(cascade =CascadeType.ALL)
	@JoinTable(name = "user_project", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	public List<User> getUsers() {
		return users;
	}
   
	public void setUsers( List<User> users) {

		
			this.users= users;
		
		
	}
	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj))
			return true;
		if (obj instanceof User) {
			return id.equals(Project.class.cast(obj).getId());
		} else {
			return false;
		}
	}
    
	
}
