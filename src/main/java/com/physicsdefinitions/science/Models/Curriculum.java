package com.physicsdefinitions.science.Models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "curriculums")
public class Curriculum {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String curriculumName;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "term_curriculum", joinColumns = { @JoinColumn(name = "curriculum_id") }, inverseJoinColumns = {
            @JoinColumn(name = "term_id") })
    private Set<Term> terms = new HashSet<Term>();

    public Curriculum() {
    }

    public String getCurriculumName() {
        return curriculumName;
    }

    public int getId() {
        return id;
    }

    public Set<Term> getTerms() {
        return terms;
    }

    public void setTerms(Set<Term> terms) {
        this.terms = terms;
    }

    public void setCurriculumName(String curriculumName) {
        this.curriculumName = curriculumName;
    }

    public void setId(int id) {
        this.id = id;
    }

}
