package com.orlab.model;

import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldId;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldProperty;
import ioinformarics.oss.jackson.module.jsonld.annotation.JsonldType;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "turniri")
@JsonldType("https://schema.org/EventSeries")
public class Turniri {

    @Id
    @Column(name = "\"idTurnir\"", nullable = false)
    @JsonldId
    private Integer idTurnir;

    @Column(name = "\"Naziv\"", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    @JsonldProperty("https://schema.org/name")
    private String naziv;

    @Column(name = "\"Serija\"", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String serija;

    @Column(name = "\"Organizator\"", columnDefinition = "text[] not null")
    private String organizator;

    @Column(name = "\"Tip\"", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String tip;

    @Column(name = "\"Lokacija\"", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    @JsonldProperty("https://schema.org/location")
    private String lokacija;

    @Column(name = "\"Format\"", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String format;

    @Column(name = "\"NagradniFond\"", nullable = false)
    private Integer nagradniFond;

    @Column(name = "\"BrojTimova\"", nullable = false)
    private Integer brojTimova;

    @JsonldProperty("https://schema.org/startDate")
    @Column(name = "\"DatumPocetka\"", nullable = false)
    private LocalDate datumPocetka;

    @JsonldProperty("https://schema.org/endDate")
    @Column(name = "\"DatumZavrsetka\"", nullable = false)
    private LocalDate datumZavrsetka;

    @Column(name = "\"VerzijaIgre\"", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String verzijaIgre;

    @Column(name = "\"BrojGledatelja\"", nullable = false)
    private Integer brojGledatelja;

//    @ManyToMany(cascade = { CascadeType.ALL })
//    @JoinTable(name = "turnir_sponzor",
//            joinColumns = @JoinColumn(name = "IdTurnir"),
//            inverseJoinColumns = @JoinColumn(name = "IdSponzor"))
//    private Set<Sponzori> sponzoris = new LinkedHashSet<>();


    @Override
    public String toString() {
        return "Turniri{" +
                "idTurnir=" + idTurnir +
                ", naziv='" + naziv + '\'' +
                ", serija='" + serija + '\'' +
                ", organizator='" + organizator + '\'' +
                ", tip='" + tip + '\'' +
                ", lokacija='" + lokacija + '\'' +
                ", format='" + format + '\'' +
                ", nagradniFond=" + nagradniFond +
                ", brojTimova=" + brojTimova +
                ", datumPocetka=" + datumPocetka +
                ", datumZavrsetka=" + datumZavrsetka +
                ", verzijaIgre='" + verzijaIgre + '\'' +
                ", brojGledatelja=" + brojGledatelja +
                '}';
    }

    public Integer getIdTurnir() {
        return idTurnir;
    }

    public void setIdTurnir(Integer idTurnir) {
        this.idTurnir = idTurnir;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getSerija() {
        return serija;
    }

    public void setSerija(String serija) {
        this.serija = serija;
    }

    public String getOrganizator() {
        return organizator;
    }

    public void setOrganizator(String organizator) {
        this.organizator = organizator;
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

//    public Set<Sponzori> getSponzoris() {
//        return sponzoris;
//    }
//
//    public void setSponzoris(Set<Sponzori> sponzoris) {
//        this.sponzoris = sponzoris;
//    }

}