
package com.gaudetb.dojosandninjas.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;


@Entity
@Table(name = "ninjas")
public class Ninja {

	// ---------------------------
	// Member Variables:
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Ninja must have a first name.")
	@Size(min = 2, max = 30, message = "First name must be at least 2 characters and no more than 30 characters long.")
	private String firstName;
	
	@NotNull(message = "Ninja must have a Last name.")
	@Size(min = 2, max = 30, message = "Last name must be at least 2 characters and no more than 30 characters long.")
	private String lastName;
	
	@NotNull(message = "Ninja must have an age.")
	@Positive(message = "Ninja age must be greater than zero.")
	private int age;
	
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dojo_id")
	private Dojo dojo;

	// ---------------------------
	// Constructors:
	
	public Ninja() {
		
	}

	// ---------------------------
	// Methods:

	// ---------------------------
	// Getters & Setters:
	
	// GETTERS

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @return the dojo
	 */
	public Dojo getDojo() {
		return dojo;
	}
	
	// SETTERS:

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @param dojo the dojo to set
	 */
	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}
	
	@PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

	
}
