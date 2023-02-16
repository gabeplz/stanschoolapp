package crudgedoe.crudtest.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name="Leerling")
public class Leerling {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer schoolKlas;

   // private Integer school_id;

    @ManyToOne
    @JsonBackReference
   // @JoinColumn(name="school_id")
    private School school;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "leerling_courses",
            joinColumns = @JoinColumn(name = "leerling_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Collection<Course> courses;
    // TODO: 16/02/2023 list intitializeren 
    
    //@OneToOne(mappedBy = "leerling")
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private ContactPersoon contactPersoon;





    public Leerling(String name, Integer schoolKlas) {
        this.name = name;
        this.schoolKlas = schoolKlas;
      //  this.schoolId = school;
    }


    public Leerling(){};


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSchoolKlas() {
        return schoolKlas;
    }

    public void setSchoolKlas(Integer schoolKlas) {
        this.schoolKlas = schoolKlas;
    }

//    public Integer getSchooId() {
//        return school_id;
//    }
//
//    public void setSchoolId(Integer schoolId) {
//        this.school_id = schoolId;
//    }
}
