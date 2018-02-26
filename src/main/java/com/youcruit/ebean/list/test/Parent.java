package com.youcruit.ebean.list.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import io.ebean.annotation.CreatedTimestamp;
import io.ebean.annotation.PrivateOwned;
import io.ebean.annotation.UpdatedTimestamp;

@Entity
@Table(name = "e_parent")
public class Parent {
    @Id
    private UUID id;
    private String name;
    @PrivateOwned
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Child> children;
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

    public List<Child> getChildren() {
        if (children == null) {
            this.children = new ArrayList<>();
	}
	return children;
    }

    public void setChildren(final List<Child> children) {
	this.children = children;
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
