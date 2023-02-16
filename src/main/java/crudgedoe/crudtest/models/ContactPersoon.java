package crudgedoe.crudtest.models;

import jakarta.persistence.*;

@Entity
@Table(name="ContactPersoon")
public class ContactPersoon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String phoneNumber;



    //private int id;
    @OneToOne(mappedBy = "contactPersoon")
    private Leerling leerling;

    public ContactPersoon(){}
    public ContactPersoon(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber;
    }
}
