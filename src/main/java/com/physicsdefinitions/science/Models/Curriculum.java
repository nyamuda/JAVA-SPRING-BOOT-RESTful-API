package com.physicsdefinitions.science.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "curriculums")
public class Curriculum {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String curriculumName;

    public Curriculum() {
    }

    public String getCurriculumName() {
        return curriculumName;
    }

    public int getId() {
        return id;
    }

    public void setCurriculumName(String curriculumName) {
        this.curriculumName = curriculumName;
    }

    public void setId(int id) {
        this.id = id;
    }

}
