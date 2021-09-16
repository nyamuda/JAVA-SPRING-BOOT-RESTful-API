package com.physicsdefinitions.science.Models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "terms")
public class Term {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    @NotBlank(message = "Term name is required.")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "topic_id")
    // @NotBlank
    private Topic topic;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "term_curriculum", joinColumns = { @JoinColumn(name = "term_id") }, inverseJoinColumns = {
            @JoinColumn(name = "curriculum_id") })
    private Collection<Curriculum> curriculums = new ArrayList<>();

    public Term() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Topic getTopic() {
        return topic;
    }

    public Collection<Curriculum> getCurriculums() {
        return curriculums;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public void setCurriculums(Collection<Curriculum> curriculums) {
        this.curriculums = curriculums;
    }

}
