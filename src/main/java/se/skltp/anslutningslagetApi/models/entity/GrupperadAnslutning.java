package se.skltp.anslutningslagetApi.models.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "grupperade_anslutningar")
public class GrupperadAnslutning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String kallsystem;

    private String kategori;

    private String organisatoriskenhet;

    private String tjanstekontrakt;

    private String ursprungligkonsument;

    private String vardgivare;

    private String vardenhet;

    @Temporal(TemporalType.TIMESTAMP)
    private Date forstaAnslutningsDatum;

    @Temporal(TemporalType.TIMESTAMP)
    private Date senasteAnslutningsDatum;


    public String getKallsystem() {
        return kallsystem;
    }

    public void setKallsystem(String kallsystem) {
        this.kallsystem = kallsystem;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getOrganisatoriskenhet() {
        return organisatoriskenhet;
    }

    public void setOrganisatoriskenhet(String organisatoriskenhet) {
        this.organisatoriskenhet = organisatoriskenhet;
    }

    public String getTjanstekontrakt() {
        return tjanstekontrakt;
    }

    public void setTjanstekontrakt(String tjanstekontrakt) {
        this.tjanstekontrakt = tjanstekontrakt;
    }

    public String getUrsprungligkonsument() {
        return ursprungligkonsument;
    }

    public void setUrsprungligkonsument(String ursprungligkonsument) {
        this.ursprungligkonsument = ursprungligkonsument;
    }

    public String getVardgivare() {
        return vardgivare;
    }

    public void setVardgivare(String vardgivare) {
        this.vardgivare = vardgivare;
    }

    public String getVardenhet() {
        return vardenhet;
    }

    public void setVardenhet(String vardenhet) {
        this.vardenhet = vardenhet;
    }

    public Date getForstaAnslutningsDatum() {
        return forstaAnslutningsDatum;
    }

    public void setForstaAnslutningsDatum(Date forstaAnslutningsDatum) {
        this.forstaAnslutningsDatum = forstaAnslutningsDatum;
    }

    public Date getSenasteAnslutningsDatum() {
        return senasteAnslutningsDatum;
    }

    public void setSenasteAnslutningsDatum(Date senasteAnslutningsDatum) {
        this.senasteAnslutningsDatum = senasteAnslutningsDatum;
    }
}
