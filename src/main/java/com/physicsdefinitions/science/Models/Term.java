package com.physicsdefinitions.science.Models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "terms")
public class Term {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String termName;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "topic_id")
    private Topic topic;

    public Term() {
    }

    public int getId() {
        return id;
    }

    public String getTermName() {
        return termName;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

}
