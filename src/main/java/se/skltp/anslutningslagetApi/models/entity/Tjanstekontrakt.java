package se.skltp.anslutningslagetApi.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "tjanstekontrakt")
public class Tjanstekontrakt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
