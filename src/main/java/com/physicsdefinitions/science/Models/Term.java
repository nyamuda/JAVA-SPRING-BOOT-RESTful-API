package com.physicsdefinitions.science.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Term {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String term_name;
    private String definition;
    @ManyToOne
    @JoinColumn(name = "physics_topic_id")
    private PhysicsTopic physicsTopic;

    public int getId() {
        return id;
    }

    public String getTerm_name() {
        return term_name;
    }

    public String getDefinition() {
        return definition;
    }

    public PhysicsTopic getPhysicsTopic() {
        return physicsTopic;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTerm_name(String term_name) {
        this.term_name = term_name;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public void setPhysicsTopic(PhysicsTopic physicsTopic) {
        this.physicsTopic = physicsTopic;
    }

}
