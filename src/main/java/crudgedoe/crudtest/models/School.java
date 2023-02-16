package crudgedoe.crudtest.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer amountOfStudents;
    private String city;
    @JsonManagedReference
    @OneToMany
    private List<Leerling> leerling;


    public School(String name, Integer amountOfStudents, String city){
        this.name = name;
        this.amountOfStudents = amountOfStudents;
        this.city = city;
    }

    public School(){}

// Table [cat] contains physical column name [school_id] referred to by multiple logical column names: [school_id], [schoolId]
    public Long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmountOfStudents() {
        return amountOfStudents;
    }

    public void setAmountOfStudents(Integer amountOfStudents) {
        this.amountOfStudents = amountOfStudents;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
