package se.skltp.anslutningslgetApi.web.rest.v1.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.nio.charset.Charset;
import java.util.Random;

@JacksonXmlRootElement(localName = "anslutning")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AnslutningDTO {

    private String kallsystem;
    private String ketogori;
    private String organisatoriskenhet;
    private String tjanstekontrakt;
    private String ursprungligkonsument;
    private String vardenhet;
    private String vardgivare;

//    //todo for test
//    public AnslutningDTO() {
//        this.kallsystem = "SE2321000164-9999";
//        this.ketogori = "1";
//        this.organisatoriskenhet = "SE2321000164-1111111111111";
//        this.tjanstekontrakt = "urn:riv:clinicalprocess:healthcond:description:GetCareDocumentationResponder:2";
//        this.ursprungligkonsument = "T_SERVICES_SE165565594230-6666";
//        this.vardenhet = "SE2321000164-1234567891012";
//        this.vardgivare = "SE2321000164-1234567891033";
//    }

    public String getKallsystem() {
        return kallsystem;
    }

    public void setKallsystem(String kallsystem) {
        this.kallsystem = kallsystem;
    }

    public String getKetogori() {
        return ketogori;
    }

    public void setKetogori(String ketogori) {
        this.ketogori = ketogori;
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
}
