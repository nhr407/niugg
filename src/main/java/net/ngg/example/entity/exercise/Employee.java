package net.ngg.example.entity.exercise;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="employee")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Employee implements Serializable{
	
	// The @GeneratedValue annotation says that this value will be determined by the datasource, not by the code.
	@Id
    @Column(name="ID")
    @GeneratedValue 
    private Integer id;
	
    @Column(name="FIRSTNAME")
    private String firstname;
    
    @Column(name="LASTNAME")
    private String lastname;
    
    @Column(name="EMAIL")
    private String email;
    
    @Column(name="TELEPHONE")
    private String telephone;
    
    public Employee(){}
    
    public Employee(String firstname, String lastname, String email, String telephone) {
    	this.firstname = firstname;
    	this.lastname = lastname;
    	this.email = email;
    	this.telephone = telephone;
    }
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
    
}
