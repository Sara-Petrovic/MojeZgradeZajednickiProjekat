/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.nprog.zgradezajednicki.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sara
 */
public class VlasnikPosebnogDela implements GenericEntity {

    private Long vlasnikId;
    private String ime;
    private String prezime;
    private String brojPosebnogDela;
    private double velicinaPosebnogDela;
    private MernaJedinica mernaJedinica;
    private String kontaktVlasnika;
    private StambenaZajednica stambenaZajednica;

    public VlasnikPosebnogDela() {
    }

    public VlasnikPosebnogDela(Long vlasnikId, String ime, String prezime, 
            String brojPosebnogDela, double velicinaPosebnogDela, 
            String kontaktVlasnika, StambenaZajednica stambenaZajednica) {
        this.vlasnikId = vlasnikId;
        this.ime = ime;
        this.prezime = prezime;
        this.brojPosebnogDela = brojPosebnogDela;
        this.velicinaPosebnogDela = velicinaPosebnogDela;
        this.kontaktVlasnika = kontaktVlasnika;
        this.stambenaZajednica = stambenaZajednica;
        //default:
        mernaJedinica = MernaJedinica.m2;
    }

    public StambenaZajednica getStambenaZajednica() {
        return stambenaZajednica;
    }

    public void setStambenaZajednica(StambenaZajednica stambenaZajednica) {
        this.stambenaZajednica = stambenaZajednica;
    }

    public Long getVlasnikId() {
        return vlasnikId;
    }

    public void setVlasnikId(Long vlasnikId) {
        this.vlasnikId = vlasnikId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getBrojPosebnogDela() {
        return brojPosebnogDela;
    }

    public void setBrojPosebnogDela(String brojPosebnogDela) {
        this.brojPosebnogDela = brojPosebnogDela;
    }

    public double getVelicinaPosebnogDela() {
        return velicinaPosebnogDela;
    }

    public void setVelicinaPosebnogDela(double velicinaPosebnogDela) {
        this.velicinaPosebnogDela = velicinaPosebnogDela;
    }

    public String getKontaktVlasnika() {
        return kontaktVlasnika;
    }

    public void setKontaktVlasnika(String kontaktVlasnika) {
        this.kontaktVlasnika = kontaktVlasnika;
    }

    public MernaJedinica getMernaJedinica() {
        return mernaJedinica;
    }

    public void setMernaJedinica(MernaJedinica mernaJedinica) {
        this.mernaJedinica = mernaJedinica;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String getTableName() {
        return "vlasnik_posebnog_dela";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "vlasnikid, ime, prezime, brojposebnogdela, velicinaposebnogdela, mernajedinica, kontaktvlasnika, stambenazajednicaid";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(vlasnikId).append(",")
                .append("'").append(ime).append("',")
                .append("'").append(prezime).append("',")
                .append("'").append(brojPosebnogDela).append("',")
                .append("").append(velicinaPosebnogDela).append(",")
                .append("'").append(mernaJedinica).append("',")
                .append("'").append(kontaktVlasnika).append("',")
                .append(stambenaZajednica.getStambenaZajednicaId()).append("");
        return sb.toString();
    }

    @Override
    public String getAlijas() {
        return " as v";
    }

    @Override
    public void setId(Long id) {
        this.vlasnikId = id;
    }

    @Override
    public String getUpdateValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ime = '").append(ime).append("',")
                .append(" prezime = '").append(prezime).append("',")
                .append(" brojposebnogdela = '").append(brojPosebnogDela).append("',")
                .append(" velicinaposebnogdela = ").append(velicinaPosebnogDela).append(", ")
                .append(" mernajedinica = '").append(mernaJedinica).append("', ")
                .append(" kontaktvlasnika = '").append(kontaktVlasnika).append("', ")
                .append(" stambenazajednicaid = ").append(stambenaZajednica.getStambenaZajednicaId()).append("");
        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public String getPrimaryKeyValue() {
        return " vlasnikid = " + vlasnikId;
    }

    @Override
    public String getJoin() {
        return " inner join stambena_zajednica AS s on (s.stambenazajednicaid = v.stambenazajednicaid) inner join mesto AS m on (s.mesto = m.mestoid) ";
    }

    @Override
    public String selectWhere() {
        if (prezime == null) {
            prezime = "";
        }
        String pom = " where v.prezime like '%" + prezime + "%' ";
        if (stambenaZajednica != null) {
            pom += " and s.stambenazajednicaid = " + stambenaZajednica.getStambenaZajednicaId();
        }
        if (vlasnikId != null) { //za ucitaj vlasnika
            pom += " and vlasnikid = " + vlasnikId;
        }
        return pom;
    }

    @Override
    public List<GenericEntity> makeList(ResultSet rs) throws Exception {
        List<GenericEntity> lista = new ArrayList<>();
        while (rs.next()) {
            VlasnikPosebnogDela vlasnikPosebnogDela = new VlasnikPosebnogDela();
            vlasnikPosebnogDela.setVlasnikId(rs.getLong("vlasnikid"));
            vlasnikPosebnogDela.setIme(rs.getString("ime"));
            vlasnikPosebnogDela.setPrezime(rs.getString("prezime"));
            vlasnikPosebnogDela.setBrojPosebnogDela(rs.getString("brojposebnogdela"));
            vlasnikPosebnogDela.setVelicinaPosebnogDela(rs.getDouble("velicinaposebnogdela"));
            vlasnikPosebnogDela.setMernaJedinica((MernaJedinica.valueOf(rs.getString("mernajedinica"))));
            vlasnikPosebnogDela.setKontaktVlasnika(rs.getString("kontaktvlasnika"));

            StambenaZajednica stambenaZajednica = new StambenaZajednica();
            stambenaZajednica.setStambenaZajednicaId(rs.getLong("stambenazajednicaid"));
            stambenaZajednica.setUlica(rs.getString("ulica"));
            stambenaZajednica.setBroj(rs.getString("broj"));
            stambenaZajednica.setTekuciRacun(rs.getString("tekuciracun"));
            stambenaZajednica.setBanka(rs.getString("banka"));
            stambenaZajednica.setPib(rs.getString("pib"));
            stambenaZajednica.setMaticniBroj(rs.getString("maticnibroj"));

            Mesto mesto = new Mesto();
            mesto.setMestoId(rs.getLong("mestoid"));
            mesto.setNaziv(rs.getString("naziv"));
            mesto.setPtt(rs.getString("ptt"));
            stambenaZajednica.setMesto(mesto);

            vlasnikPosebnogDela.setStambenaZajednica(stambenaZajednica);
            lista.add(vlasnikPosebnogDela);
        }
        rs.close();
        return lista;
    }

}
