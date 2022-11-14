package com.orlab.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "sponzori", schema = "public")
public class Sponzori {
    @Id
    @Column(name = "\"IdSponzor\"", nullable = false)
    private Integer id;

    @Column(name = "\"Naziv\"", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String Naziv;

    @Column(name = "\"Iznos\"", nullable = false)
    private Integer iznos;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String naziv) {
        this.Naziv = naziv;
    }

    public Integer getIznos() {
        return iznos;
    }

    public void setIznos(Integer iznos) {
        this.iznos = iznos;
    }


}