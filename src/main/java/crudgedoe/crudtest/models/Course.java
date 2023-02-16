package crudgedoe.crudtest.models;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name="Course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer credits;

    @ManyToMany(mappedBy = "courses")
    private Collection<Leerling> leerling;
    // TODO: 16/02/2023 list initializeren 


    public Course(String name, Integer credits) {
        this.name = name;
        this.credits = credits;
    }
    public Course(){}

    public Long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }
}