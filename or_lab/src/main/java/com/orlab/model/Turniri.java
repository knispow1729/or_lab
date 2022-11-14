package com.orlab.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "turniri", schema = "public")
public class Turniri {

    @Id
    @Column(name = "Naziv", nullable = false)
    private String Naziv;

    @Column(name = "Serija", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String serija;

    @Column(name = "\"Tip\"", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String tip;

    @Column(name = "\"Lokacija\"", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String lokacija;

    @Column(name = "\"Format\"", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String format;

    @Column(name = "\"NagradniFond\"", nullable = false)
    private Integer nagradniFond;

    @Column(name = "\"BrojTimova\"", nullable = false)
    private Integer brojTimova;

    @Column(name = "\"DatumPocetka\"", nullable = false)
    private LocalDate datumPocetka;

    @Column(name = "\"DatumZavrsetka\"", nullable = false)
    private LocalDate datumZavrsetka;

    @Column(name = "\"IdTurnir\"", nullable = false)
    private Integer idTurnir;

    @Column(name = "\"VerzijaIgre\"", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String verzijaIgre;

    @Column(name = "\"BrojGledatelja\"", nullable = false)
    private Integer brojGledatelja;

    @Column(name= "Organizator")
    private String organizator;


    public String getOrganizator() {
        return organizator;
    }

    public void setOrganizator(String organizator) {
        this.organizator = organizator;
    }

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String naziv) {
        this.Naziv = naziv;
    }

    public String getSerija() {
        return serija;
    }

    public void setSerija(String serija) {
        this.serija = serija;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Integer getNagradniFond() {
        return nagradniFond;
    }

    public void setNagradniFond(Integer nagradniFond) {
        this.nagradniFond = nagradniFond;
    }

    public Integer getBrojTimova() {
        return brojTimova;
    }

    public void setBrojTimova(Integer brojTimova) {
        this.brojTimova = brojTimova;
    }

    public LocalDate getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(LocalDate datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public LocalDate getDatumZavrsetka() {
        return datumZavrsetka;
    }

    public void setDatumZavrsetka(LocalDate datumZavrsetka) {
        this.datumZavrsetka = datumZavrsetka;
    }

    public Integer getIdTurnir() {
        return idTurnir;
    }

    public void setIdTurnir(Integer idTurnir) {
        this.idTurnir = idTurnir;
    }

    public String getVerzijaIgre() {
        return verzijaIgre;
    }

    public void setVerzijaIgre(String verzijaIgre) {
        this.verzijaIgre = verzijaIgre;
    }

    public Integer getBrojGledatelja() {
        return brojGledatelja;
    }

    public void setBrojGledatelja(Integer brojGledatelja) {
        this.brojGledatelja = brojGledatelja;
    }


}