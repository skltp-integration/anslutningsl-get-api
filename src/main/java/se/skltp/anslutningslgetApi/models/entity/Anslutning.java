package se.skltp.anslutningslgetApi.models.entity;

import org.omg.CORBA.PRIVATE_MEMBER;

import javax.persistence.*;

@Entity
@Table(name = "anslutning")
public class Anslutning {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="kallsystem")
    private Kallsystem kallsystem;


    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="kategori")
    private Kategori kategori;


    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="organisatoriskenhet")
     private Organisatoriskenhet organisatoriskenhet;


    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="tjanstekontrakt")
    private Tjanstekontrakt tjanstekontrakt;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ursprungligkonsument")
    private Ursprungligkonsument ursprungligkonsument;


    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="vardgivare")
    private Vardgivare vardgivare;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="vardenhet")
    private Vardenhet vardenhet;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Kallsystem getKallsystem() {
        return kallsystem;
    }

    public void setKallsystem(Kallsystem kallsystem) {
        this.kallsystem = kallsystem;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public Organisatoriskenhet getOrganisatoriskenhet() {
        return organisatoriskenhet;
    }

    public void setOrganisatoriskenhet(Organisatoriskenhet organisatoriskenhet) {
        this.organisatoriskenhet = organisatoriskenhet;
    }

    public Tjanstekontrakt getTjanstekontrakt() {
        return tjanstekontrakt;
    }

    public void setTjanstekontrakt(Tjanstekontrakt tjanstekontrakt) {
        this.tjanstekontrakt = tjanstekontrakt;
    }

    public Ursprungligkonsument getUrsprungligkonsument() {
        return ursprungligkonsument;
    }

    public void setUrsprungligkonsument(Ursprungligkonsument ursprungligkonsument) {
        this.ursprungligkonsument = ursprungligkonsument;
    }

    public Vardgivare getVardgivare() {
        return vardgivare;
    }

    public void setVardgivare(Vardgivare vardgivare) {
        this.vardgivare = vardgivare;
    }

    public Vardenhet getVardenhet() {
        return vardenhet;
    }

    public void setVardenhet(Vardenhet vardenhet) {
        this.vardenhet = vardenhet;
    }
}
