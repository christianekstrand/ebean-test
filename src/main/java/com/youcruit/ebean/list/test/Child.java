package com.youcruit.ebean.list.test;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import io.ebean.annotation.CreatedTimestamp;
import io.ebean.annotation.UpdatedTimestamp;

@Entity
@Table(name = "e_child", uniqueConstraints = @UniqueConstraint( columnNames = {"name", "value"}))
public class Child {
    @Id
    private UUID id;
    private String name;
    private String value;
    @ManyToOne
    private Parent parent;
    @UpdatedTimestamp
    private Date lastUpdated;
    @CreatedTimestamp
    private Date dateCreated;
    @Version
    private long version;

    public UUID getId() {
	return id;
    }

    public void setId(final UUID id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(final String name) {
	this.name = name;
    }

    public String getValue() {
	return value;
    }

    public void setValue(final String value) {
	this.value = value;
    }

    public Parent getParent() {
	return parent;
    }

    public void setParent(final Parent parent) {
	this.parent = parent;
    }

    public Date getLastUpdated() {
	return lastUpdated;
    }

    public void setLastUpdated(final Date lastUpdated) {
	this.lastUpdated = lastUpdated;
    }

    public Date getDateCreated() {
	return dateCreated;
    }

    public void setDateCreated(final Date dateCreated) {
	this.dateCreated = dateCreated;
    }

    public long getVersion() {
	return version;
    }

    public void setVersion(final long version) {
	this.version = version;
    }
}
