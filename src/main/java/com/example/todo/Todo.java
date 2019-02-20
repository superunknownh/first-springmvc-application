package com.example.todo;

import java.util.Date;

import javax.validation.constraints.Size;

/**
 * This class represents a to-do.
 * 
 * @author hsanchez
 *
 */
public class Todo {

	/**
	 * Create a new to-do.
	 * 
	 * @param id The to-do id.
	 * @param user The to-do owner.
	 * @param description The to-do description.
	 * @param targetDate The to-do target date.
	 * @param isDone If the to-do is done or not.
	 */
	public Todo(int id, String user, String description, Date targetDate, boolean isDone) {
		super();
		this.id = id;
		this.user = user;
		this.description = description;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}
	
	public Todo() {
		this(0, "", "", new Date(), false);
	}

	/**
	 * Get the to-do id.
	 * 
	 * @return The to-do id.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set the to-do id. 
	 * 
	 * @param id The to-do id.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get the to-do owner.
	 * 
	 * @return The to-do owner.
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Set the to-do owner.
	 * 
	 * @param user the to-do owner.
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Get the to-do description.
	 * 
	 * @return The to-do description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the to-do description.
	 * 
	 * @param description The to-do description.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the to-do target date.
	 * 
	 * @return The to-do target date.
	 */
	public Date getTargetDate() {
		return targetDate;
	}

	/**
	 * Set the to-do target date.
	 * 
	 * @param targetDate The to-do target date.
	 */
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	
	/**
	 * Know if the to-do is done.
	 * 
	 * @return if the to-do is done.
	 */
	public boolean isDone() {
		return isDone;
	}

	/**
	 * Set the to-do done.
	 * 
	 * @param isDone The to-do done.
	 */
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Todo [id=%s, user=%s, description=%s, targetDate=%s, isDone=%s]", id, user, description, targetDate, isDone);
	}

	private int id;
	private String user;
	@Size(min=6, message="Enter at least 6 characters")
	private String description;
	private Date targetDate;
	private boolean isDone;
}
