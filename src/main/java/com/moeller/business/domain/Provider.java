package com.moeller.business.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Bernd on 28.08.2016.
 */
@Entity(name = "Provider")
@TableGenerator(name = "gen", table="SHARED_SEQUENCES", initialValue=0, allocationSize=50)
@Table(name = "Provider")
public class Provider implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "gen")
    @Column(name="P_ID")
    private long id;

    @Column(name = "P_DESCRIPTION", unique = true)
    private String description;

    public Provider(){
        //for JPA
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString(){
        return "Id: " + id + ";Description:" + description;
    }
}
