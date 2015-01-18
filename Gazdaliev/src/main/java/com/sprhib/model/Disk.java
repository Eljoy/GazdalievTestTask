package com.sprhib.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="disks")
public class Disk extends Model{

	private String name;
    private String owner;
	private String description;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
