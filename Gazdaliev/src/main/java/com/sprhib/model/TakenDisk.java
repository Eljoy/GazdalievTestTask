package com.sprhib.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Home on 17.01.2015.
 */
@Entity
@Table(name = "takendisks")
public class TakenDisk extends Model {

    private String name;
    private String description;
    private String owner;
    private String borrowed;

    public TakenDisk(){}

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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(String borrowed) {
        this.borrowed = borrowed;
    }
}
