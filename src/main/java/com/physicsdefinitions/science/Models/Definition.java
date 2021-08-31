package com.physicsdefinitions.science.Models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "definitions")
public class Definition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String definition;
    private String keywords;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "term_id")
    private Term term;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "curriculum_id")
    private Curriculum curriculum;

    public Definition() {
    }

    public int getId() {
        return id;
    }

    public String getDefinition() {
        return definition;
    }

    public String getKeywords() {
        return keywords;
    }

    public int getTerm() {
        return term.getId();
    }

    public int getCurriculum() {
        return curriculum.getId();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

}
