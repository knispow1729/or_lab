package com.orlab.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "sponzori")
public class Sponzori {

    @Id
    @Column(name = "\"IdSponzor\"", nullable = false)
    private Integer idSponzor;

    @Column(name = "\"Naziv\"", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String naziv;

    @Column(name = "\"Iznos\"", nullable = false)
    private Integer iznos;

//    @ManyToMany(mappedBy = "sponzoris")
//    @JsonIgnore
//    private Set<Turniri> turniris = new LinkedHashSet<>();


    public Integer getIdSponzor() {
        return idSponzor;
    }

    public void setIdSponzor(Integer idSponzor) {
        this.idSponzor = idSponzor;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getIznos() {
        return iznos;
    }

    public void setIznos(Integer iznos) {
        this.iznos = iznos;
    }

//    public Set<Turniri> getTurniris() {
//        return turniris;
//    }
//
//    public void setTurniris(Set<Turniri> turniris) {
//        this.turniris = turniris;
//    }

}