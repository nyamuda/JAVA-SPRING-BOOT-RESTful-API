package com.physicsdefinitions.science.Models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "topic_id")
    private Topic topic;

    public Term() {
    }

    public int getId() {
        return id;
    }

    public String getTerm_name() {
        return term_name;
    }

    public String getDefinition() {
        return definition;
    }

    public Topic getPhysicsTopic() {
        return topic;
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

    public void setPhysicsTopic(Topic topic) {
        this.topic = topic;
    }

}
