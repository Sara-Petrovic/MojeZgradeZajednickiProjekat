
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.nprog.zgradezajednicki.domain;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Sara
 */
public class StambenaZajednica implements GenericEntity {

    private Long stambenaZajednicaId;
    private String ulica;
    private String broj;
    private Mesto mesto;
    private String tekuciRacun;
    private String banka;
    private String pib;
    private String maticniBroj;

    public StambenaZajednica() {
    }

    public StambenaZajednica(Long stambenaZajednicaId, String ulica, String broj,
            Mesto mesto, String tekuciRacun, String banka, 
            String pib, String maticniBroj) {
        this.stambenaZajednicaId = stambenaZajednicaId;
        this.ulica = ulica;
        this.broj = broj;
        this.mesto = mesto;
        this.tekuciRacun = tekuciRacun;
        this.banka = banka;
        this.pib = pib;
        this.maticniBroj = maticniBroj;
    }

    public String getBanka() {
        return banka;
    }

    public void setBanka(String banka) {
        this.banka = banka;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getMaticniBroj() {
        return maticniBroj;
    }

    public void setMaticniBroj(String maticniBroj) {
        this.maticniBroj = maticniBroj;
    }

    public String getTekuciRacun() {
        return tekuciRacun;
    }

    public void setTekuciRacun(String tekuciRacun) {
        this.tekuciRacun = tekuciRacun;
    }

    public Long getStambenaZajednicaId() {
        return stambenaZajednicaId;
    }

    public void setStambenaZajednicaId(Long stambenaZajednicaId) {
        this.stambenaZajednicaId = stambenaZajednicaId;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    @Override
    public String toString() {
        return ulica + " " + broj + ", " + mesto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StambenaZajednica other = (StambenaZajednica) obj;
        if (!Objects.equals(this.stambenaZajednicaId, other.stambenaZajednicaId)) {
            return false;
        }
        return true;
    }

    @Override
    public String getTableName() {
        return "stambena_zajednica";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "stambenazajednicaid, mesto, ulica, broj, banka, tekuciracun, pib, maticnibroj";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(stambenaZajednicaId).append(",")
                .append(mesto.getMestoId()).append(",")
                .append("'").append(ulica).append("',")
                .append("'").append(broj).append("',")
                .append("'").append(banka).append("',")
                .append("'").append(tekuciRacun).append("',")
                .append("'").append(pib).append("',")
                .append("'").append(maticniBroj).append("'");
        return sb.toString();

    }

    @Override
    public String getAlijas() {
        return " as sz ";
    }

    @Override
    public void setId(Long id) {
        this.stambenaZajednicaId = id;
    }

    @Override
    public String getUpdateValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(" mesto = ").append(mesto.getMestoId()).append(",")
                .append(" ulica = '").append(ulica).append("',")
                .append(" broj = '").append(broj).append("',")
                .append(" banka = '").append(banka).append("', ")
                .append(" tekuciracun = '").append(tekuciRacun).append("', ")
                .append(" pib = '").append(pib).append("', ")
                .append(" maticnibroj = '").append(maticniBroj).append("'");
        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public String getPrimaryKeyValue() {
        return " stambenazajednicaid = " + stambenaZajednicaId;
    }

    @Override
    public String getJoin() {
        return " inner join mesto AS m on (sz.mesto = m.mestoid)";
    }

    @Override
    public String selectWhere() {
        if (ulica == null) {
            ulica = "";
        }
        String pom = " where sz.ulica like '%" + ulica + "%' ";
        if (mesto != null) {
            pom += " and m.mestoid = " + mesto.getMestoId();
        }
        if(stambenaZajednicaId!=null){
            pom += " and stambenazajednicaid = " + stambenaZajednicaId;
        }
        return pom;
    }

    @Override
    public List<GenericEntity> makeList(ResultSet rs) throws Exception {
        List<GenericEntity> lista = new ArrayList<>();
        while (rs.next()) {
            //System.out.println("usao");
            StambenaZajednica stambenaZajednica = new StambenaZajednica();
            stambenaZajednica.setStambenaZajednicaId(rs.getLong("stambenazajednicaid"));
            stambenaZajednica.setUlica(rs.getString("ulica"));
            stambenaZajednica.setBroj(rs.getString("broj"));
            stambenaZajednica.setTekuciRacun(rs.getString("tekuciracun"));
            stambenaZajednica.setBanka(rs.getString("banka"));
            stambenaZajednica.setPib(rs.getString("pib"));
            stambenaZajednica.setMaticniBroj(rs.getString("maticnibroj"));

           // System.out.println("usao2");
            Mesto mesto = new Mesto();
            mesto.setMestoId(rs.getLong("mesto"));
            mesto.setNaziv(rs.getString("naziv"));
            mesto.setPtt(rs.getString("ptt"));

            stambenaZajednica.setMesto(mesto);
            lista.add(stambenaZajednica);
            //System.out.println(stambenaZajednica);
        }
        rs.close();
        return lista;
    }

}
