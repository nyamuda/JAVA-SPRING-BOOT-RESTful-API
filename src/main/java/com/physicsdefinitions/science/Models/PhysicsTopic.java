package com.physicsdefinitions.science.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

@Entity
@Table
public class PhysicsTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    public PhysicsTopic() {
    }

    public PhysicsTopic(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
