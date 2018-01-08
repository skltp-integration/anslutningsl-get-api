package se.skltp.anslutningslagetApi.service.impl;

public class AnslutningCriteria {
    private String kallsystem;
    private String kategori;
    private String organisatoriskenhet;
    private String tjanstekontrakt;
    private String ursprungligkonsument;
    private String vardenhet;
    private String vardgivare;

    public AnslutningCriteria(String kallsystem, String kategori, String organisatoriskenhet, String tjanstekontrakt, String ursprungligkonsument, String vardenhet, String vardgivare) {
        this.kallsystem = kallsystem;
        this.kategori = kategori;
        this.organisatoriskenhet = organisatoriskenhet;
        this.tjanstekontrakt = tjanstekontrakt;
        this.ursprungligkonsument = ursprungligkonsument;
        this.vardenhet = vardenhet;
        this.vardgivare = vardgivare;
    }

    public AnslutningCriteria(){

    }

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

    public String getVardenhet() {
        return vardenhet;
    }

    public void setVardenhet(String vardenhet) {
        this.vardenhet = vardenhet;
    }

    public String getVardgivare() {
        return vardgivare;
    }

    public void setVardgivare(String vardgivare) {
        this.vardgivare = vardgivare;
    }

    public boolean isEmpty() {
        return getKallsystem() ==  null && getKategori() == null &&
                getOrganisatoriskenhet() == null && getTjanstekontrakt() == null &&
                getUrsprungligkonsument() == null && getVardenhet() == null && getVardgivare() == null;
    }
}
