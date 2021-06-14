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
*Klasa koja predstavlja vlasnika posebnog dela i implementira interfejs GenericEntity.
*
*Vlasnik posebnog dela ima vlasnikId kao Long i ime, prezime, broj posebnog dela, kontakt vlasnika kao String vrednosti, i velicinu posebnog dela kao double, mernu jedinicu kao MernaJedinica i stambenu zajednicu kao StambenaZajednica.
*
* @author Sara
* @version 0.1
*/
public class VlasnikPosebnogDela implements GenericEntity {

	/**
	 * VlasnikId kao Long.
	 */
    private Long vlasnikId;
    
    /**
	 * Ime vlasnika kao String.
	 */
    private String ime;
    /**
	 * Prezime vlasnika kao String.
	 */
    private String prezime;
    /**
	 * Broj stana vlasnika kao String.
	 */
    private String brojPosebnogDela;
    /**
	 * Velicina stana vlasnika kao double.
	 */
    private double velicinaPosebnogDela;
    /**
	 * Merna jedinica u kojoj je izrazena velicina stana vlasnika kao MernaJedinica.
	 */
    private MernaJedinica mernaJedinica;
    /**
	 * Kontakt vlasnika kao String.
	 */
    private String kontaktVlasnika;
    /**
	 * Stambena zajednica stana vlasnika kao StambenaZajednica.
	 */
    private StambenaZajednica stambenaZajednica;

    /**
   	 * Kontruktor koji inicijalizuje objekat i nista vise.
   	 */
    public VlasnikPosebnogDela() {
    	stambenaZajednica = new StambenaZajednica();
    }

    /**
	 * Konstruktor koji inicijalizuje objekat i postavlja vrednosti za vlasnikId, ime, prezime, broj posebnog dela, velicinu posebnog dela, kontakt vlasnika, mernu jedinicu i stambenu zajednicu.
	 * 
	 * @param vlasnikId VlasnikId kao Long.
	 * @param ime Ime vlasnika kao String.
	 * @param prezime Prezime vlasnika kao String.
	 * @param brojPosebnogDela BrojPosebnogDela kao String.
	 * @param velicinaPosebnogDela VelicinaPosebnogDela kao double.
	 * @param kontaktVlasnika KontaktVlasnika kao String.
	 * @param stambenaZajednica Stambena zajednica kao StambenaZajednica.
	 * 
	 */
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

    /**
	 * Vraca stambenu zajednicu u kojoj zivi vlasnik.
	 * 
	 * @return Stambena zajednica kao StambenaZajednica.
	 */
    public StambenaZajednica getStambenaZajednica() {
        return stambenaZajednica;
    }
    /**
   	 * Postavlja stambenu zajednicu u kojoj zivi vlasnik na novu vrednost.
   	 * 
   	 * @param stambenaZajednica Stambena zajednica kao StambenaZajednica.
   	 * 
   	 */
    public void setStambenaZajednica(StambenaZajednica stambenaZajednica) {
        this.stambenaZajednica = stambenaZajednica;
    }

    /**
	 * Vraca id vlasnika.
	 * 
	 * @return VlasnikId kao Long.
	 */
    public Long getVlasnikId() {
        return vlasnikId;
    }

    /**
	 * Postavlja id vlasnika na novu vrednost.
	 * 
	 * @param vlasnikId VlasnikId kao Long.
	 * 
	 */
    public void setVlasnikId(Long vlasnikId) {
        this.vlasnikId = vlasnikId;
    }

    /**
	 * Vraca ime vlasnika.
	 * 
	 * @return Ime vlasnika kao String.
	 */
    public String getIme() {
        return ime;
    }

    /**
	 * Postavlja ime vlasnika na novu vrednost.
	 * 
	 * @param ime Ime vlasnika kao String.
	 */
    public void setIme(String ime) {
    	
		if(ime.length() <= 2)
			throw new RuntimeException("Ime mora imati vise od 2 znaka");
        this.ime = ime;
    }
    /**
	 * Vraca prezime vlasnika.
	 * 
	 * @return Prezime vlasnika kao String.
	 */
    public String getPrezime() {
        return prezime;
    }
    /**
	 * Postavlja prezime vlasnika na novu vrednost.
	 * 
	 * @param prezime Prezime vlasnika kao String.
	 */
    public void setPrezime(String prezime) {
    	if(prezime.length() <= 2)
			throw new RuntimeException("Prezime mora imati vise od 2 znaka");
        this.prezime = prezime;
    }
    /**
	 * Vraca broj stana vlasnika.
	 * 
	 * @return Broj stana vlasnika kao String.
	 */
    public String getBrojPosebnogDela() {
        return brojPosebnogDela;
    }
    /**
	 * Postavlja broj stana vlasnika na novu vrednost.
	 * 
	 * @param brojPosebnogDela Broj posebnog dela vlasnika kao String.
	 */
    public void setBrojPosebnogDela(String brojPosebnogDela) {
        this.brojPosebnogDela = brojPosebnogDela;
    }

    /**
	 * Vraca velicinu stana vlasnika.
	 * 
	 * @return Velicina stana vlasnika kao double.
	 */
    public double getVelicinaPosebnogDela() {
        return velicinaPosebnogDela;
    }
    /**
	 * Postavlja velicinu stana vlasnika na novu vrednost.
	 * 
	 * @param velicinaPosebnogDela Velicina posebnog dela vlasnika kao double.
	 */
    public void setVelicinaPosebnogDela(double velicinaPosebnogDela) {
        this.velicinaPosebnogDela = velicinaPosebnogDela;
    }

    /**
  	 * Vraca kontakt vlasnika.
  	 * 
  	 * @return Kontakt vlasnika kao String.
  	 */
    public String getKontaktVlasnika() {
        return kontaktVlasnika;
    }
    /**
	 * Postavlja kontakt vlasnika na novu vrednost.
	 * 
	 * @param kontaktVlasnika Kontakt vlasnika kao String.
	 */
    public void setKontaktVlasnika(String kontaktVlasnika) {
        this.kontaktVlasnika = kontaktVlasnika;
    }

    /**
  	 * Vraca mernu jedinicu povrsine stana vlasnika.
  	 * 
  	 * @return Merna jedinica kao MernaJedinica.
  	 */
    public MernaJedinica getMernaJedinica() {
        return mernaJedinica;
    }

    /**
	 * Postavlja mernu jedinicu povrsine stana vlasnika na novu vrednost.
	 * 
	 * @param mernaJedinica Merna jedinica kao MernaJedinica.
	 */
    public void setMernaJedinica(MernaJedinica mernaJedinica) {
        this.mernaJedinica = mernaJedinica;
    }

    /**
	 * @return String sa svim podacima o Vlasniku posebnog dela.
	 */
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
            String ime = rs.getString("ime");
            if(ime!=null) {
            vlasnikPosebnogDela.setIme(ime);
            }
            String prezime = rs.getString("prezime");
            if(prezime!=null) {
            	vlasnikPosebnogDela.setPrezime(prezime);
            }
            
            vlasnikPosebnogDela.setBrojPosebnogDela(rs.getString("brojposebnogdela"));
            vlasnikPosebnogDela.setVelicinaPosebnogDela(rs.getDouble("velicinaposebnogdela"));
            String mernaJedinica= rs.getString("mernajedinica");
            if(mernaJedinica!=null) {
            vlasnikPosebnogDela.setMernaJedinica((MernaJedinica.valueOf(mernaJedinica)));
            }
            vlasnikPosebnogDela.setKontaktVlasnika(rs.getString("kontaktvlasnika"));

            StambenaZajednica stambenaZajednica = new StambenaZajednica();
            stambenaZajednica.setStambenaZajednicaId(rs.getLong("stambenazajednicaid"));
            String ulica = rs.getString("ulica");
            if(ulica!=null) {
            stambenaZajednica.setUlica(ulica);
            }
            stambenaZajednica.setBroj(rs.getString("broj"));
            stambenaZajednica.setTekuciRacun(rs.getString("tekuciracun"));
            stambenaZajednica.setBanka(rs.getString("banka"));
            stambenaZajednica.setPib(rs.getString("pib"));
            stambenaZajednica.setMaticniBroj(rs.getString("maticnibroj"));

            Mesto mesto = new Mesto();
            mesto.setMestoId(rs.getLong("mestoid"));
            String naziv=rs.getString("naziv");
            if(naziv!=null) {
            	mesto.setNaziv(naziv);
            }
            String ptt=rs.getString("ptt");
            if(ptt!=null) {
            mesto.setPtt(ptt);
            }
            
            stambenaZajednica.setMesto(mesto);

            vlasnikPosebnogDela.setStambenaZajednica(stambenaZajednica);
            lista.add(vlasnikPosebnogDela);
        }
        rs.close();
        return lista;
    }

}
