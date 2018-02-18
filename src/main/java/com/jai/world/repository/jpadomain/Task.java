package com.jai.world.repository.jpadomain;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "TASK")
public class Task implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8173418231919870308L;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	private Long id;
	
	@Column(name = "NAME")
	@JsonProperty("name")
	private String name;
	
	@Column(name = "DESCRIPTION")
	@JsonProperty("description")
	private String description;
	
	@Column(name = "PRIORITY")
	@JsonProperty("priority")
	private String priority;
	
	@Column(name = "STATUS")
	@JsonProperty("status")
	private String status;
	
	@Column(name = "ARCHIVED")
	@JsonProperty("archived")
	private Boolean archived;
	
	@Column(name = "CREATEDDATE")
	@JsonProperty("createdDate")
	private Date createdDate;
	
	@Column(name = "UPDATEDDATE")
	@JsonProperty("updatedDate")
	private Date updatedDate;
	
	@Column(name = "CREATEDBY")
	@JsonProperty("createdBy")
	private String createdBy;
	
	@Column(name = "UPDATEDBY")
	@JsonProperty("updatedBy")
	private String updatedBy;
	
	@JsonProperty("completed")
	@Column(name = "completed")
    private Boolean completed;
	
	@Version
	@Column(name = "VERSION")
	@JsonProperty("version")
	private Integer version;

	public Task() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getArchived() {
		return archived;
	}

	public void setArchived(Boolean archived) {
		this.archived = archived;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", description=" + description + ", priority=" + priority
				+ ", status=" + status + ", archived=" + archived + ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", completed=" + completed
				+ ", version=" + version + "]";
	}
}
