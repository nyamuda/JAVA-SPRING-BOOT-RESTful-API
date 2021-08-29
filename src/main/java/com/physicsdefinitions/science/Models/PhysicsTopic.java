package com.physicsdefinitions.science.Models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    @OneToMany(mappedBy = "physicsTopic")
    private List<Term> terms;

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

    public List<Term> getTerms() {
        return terms;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTerms(List<Term> terms) {
        this.terms = terms;
    }

}
