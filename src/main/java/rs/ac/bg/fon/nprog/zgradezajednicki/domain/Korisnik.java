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
 *Klasa koja predstavlja korisnika programa moje zgrade i implementira interfejs GenericEntity.
 *
 *Korisnik ima id kao Long i ime, prezime, korisnicko ime i lozinku kao String vrednosti.
 *
 * @author Sara
 * @version 0.1
 */
public class Korisnik implements GenericEntity{

	/**
	 * Id korisnika kao Long.
	 */
    private Long id;
    
    /**
	 * Ime korisnika kao String.
	 */
    private String ime;
    
    /**
	 * Prezime korisnika kao String.
	 */
    private String prezime;
    
    /**
	 * Korisnicko ime korisnika kao String.
	 */
    private String korisnickoIme;
    
    /**
	 * Lozinka korisnika kao String.
	 */
    private String lozinka;

    
    /**
	 * Kontruktor koji inicijalizuje objekat i nista vise.
	 */
    public Korisnik() {
    }

    /**
	 * Konstruktor koji inicijalizuje objekat i postavlja vrednosti za id, ime, prezime, korisnicko ime i lozinku korisnika.
	 * 
	 * @param id Id korisnika kao Long.
	 * @param ime Ime korisnika kao String.
	 * @param prezime Prezime korisnika kao String.
	 * @param korisnickoIme Korisnicko ime korisnika kao String.
	 * @param lozinka Lozinka korisnika kao String.
	 */
    public Korisnik(Long id, String ime, String prezime, String korisnickoIme, String lozinka) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    /**
	 * Vraca id korisnika.
	 * 
	 * @return Id korisnika kao Long.
	 */
    public Long getId() {
        return id;
    }

    /**
	 * Postavlja id korisnika na novu vrednost.
	 * 
	 * @param id Id korisnika kao Long.
	 * 
	 */
    public void setId(Long id) {
        this.id = id;
    }

    /**
	 * Vraca ime korisnika.
	 * 
	 * @return Ime korisnika kao String.
	 */
    public String getIme() {
        return ime;
    }

    /**
	 * Postavlja ime korisnika na novu vrednost.
	 * 
	 * @param ime Ime korisnika kao String.
	 */
    public void setIme(String ime) {
    	if(ime == null)
			throw new NullPointerException("Ime ne sme biti null");
    	if(ime.length() <=2)
			throw new RuntimeException("Ime mora imati vise od 2 znaka");
        this.ime = ime;
    }

    /**
	 * Vraca prezime korisnika.
	 * 
	 * @return Prezime korisnika kao String.
	 */
    public String getPrezime() {
        return prezime;
    }

    /**
	 * Postavlja prezime korisnika na novu vrednost.
	 * 
	 * @param prezime Prezime korisnika kao String.
	 * 
	 */
    public void setPrezime(String prezime) {
    	if(prezime == null)
			throw new NullPointerException("Prezime ne sme biti null");
    	if(prezime.length() <= 2)
			throw new RuntimeException("Prezime mora imati vise od 2 znaka");
        this.prezime = prezime;
    }

    /**
	 * Vraca korisnicko ime korisnika.
	 * 
	 * @return Korisnicko ime korisnika kao String.
	 */
    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    /**
	 * Postavlja korisnicko ime korisnika na novu vrednost.
	 * 
	 * @param korisnickoIme Korisnicko ime korisnika kao String.
	 * 
	 */
    public void setKorisnickoIme(String korisnickoIme) {
    	if(korisnickoIme == null)
			throw new NullPointerException("Korisnicko ime ne sme biti null");
    	if(korisnickoIme.length() <= 2)
			throw new RuntimeException("Korisnicko ime mora imati vise od 2 znaka");
        this.korisnickoIme = korisnickoIme;
    }

    /**
	 * Vraca lozinku korisnika.
	 * 
	 * @return Lozinka korisnika kao String.
	 */
    public String getLozinka() {
        return lozinka;
    }

    /**
   	 * Postavlja lozinku korisnika na novu vrednost.
   	 * 
   	 * @param lozinka Lozinka korisnika kao String.
   	 * 
   	 */
    public void setLozinka(String lozinka) {
    	if(lozinka == null)
			throw new NullPointerException("Lozinka ne sme biti null");
    	if(lozinka.length() <= 2)
			throw new RuntimeException("Lozinka mora imati vise od 2 znaka");
        this.lozinka = lozinka;
    }

    @Override
    public String getTableName() {
        return " korisnik ";
    }

    @Override
    public String getColumnNamesForInsert() {
    	return "";    }

    @Override
    public String getInsertValues() {
    	return "";    }

    @Override
    public String getAlijas() {
        return " as k ";
    }

    @Override
    public String getUpdateValues() {
    	return "";    }

    @Override
    public String getPrimaryKeyValue() {
    	return "";    }

    @Override
    public String getJoin() {
        return "";
    }

    @Override
    public String selectWhere() {
        return " where korisnickoime = '" + korisnickoIme + "' and lozinka = '" + lozinka + "' ";
    }

    @Override
    public List<GenericEntity> makeList(ResultSet rs) throws Exception {
        List<GenericEntity> lista = new ArrayList<>();
        while(rs.next()){
                Korisnik korisnik = new Korisnik();
                korisnik.setId(rs.getLong("id"));
                String ime = rs.getString("ime");
                if(ime!=null) {
                korisnik.setIme(ime);
                }
                String prezime = rs.getString("prezime");
                if(prezime!=null) {
                korisnik.setPrezime(prezime);
                }
                String lozinka = rs.getString("lozinka");
                if(lozinka!=null) {
                korisnik.setLozinka(lozinka);
                }
                String korisnickoIme = rs.getString("korisnickoIme");
                if(korisnickoIme!=null) {
                korisnik.setKorisnickoIme(korisnickoIme);
                }
                lista.add(korisnik);
            }
            rs.close();
            return lista;
    }

  
   

    
}
