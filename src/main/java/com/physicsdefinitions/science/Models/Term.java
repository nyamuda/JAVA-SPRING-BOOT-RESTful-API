package com.physicsdefinitions.science.Models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "terms")
public class Term {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    @NotBlank
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "topic_id")
    @NotBlank
    private Topic topic;

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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

}
