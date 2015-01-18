package com.sprhib.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Home on 16.01.2015.
 */
@Entity
@Table(name = "role")
public class UserRole extends Model {

    @ManyToMany(mappedBy = "userRoles")
    private Set<User> users = new HashSet<>();


    @Enumerated(EnumType.STRING)
    @Column(name = "title")
    private ListRole listRole;

    public UserRole(){
        super();
    }

    public UserRole(int id){
        super(id);
    }

    public ListRole getListRole() {
        return listRole;
    }

    public void setListRole(ListRole listRole) {
        this.listRole = listRole;
    }
}
