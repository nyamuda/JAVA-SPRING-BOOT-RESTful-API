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

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "curriculums")
public class Curriculum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    @NotBlank
    private String name;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "term_curriculum", joinColumns = { @JoinColumn(name = "curriculum_id") }, inverseJoinColumns = {
            @JoinColumn(name = "term_id") })
    private Set<Term> terms = new HashSet<Term>();

    public Curriculum() {
    }

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

}
