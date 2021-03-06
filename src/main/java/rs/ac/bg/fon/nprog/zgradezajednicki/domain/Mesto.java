/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.nprog.zgradezajednicki.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
*
*Klasa koja predstavlja mesto gde se nalazi zgrada i implementira interfejs GenericEntity.
*
*Mesto ima id kao Long i ptt i naziv kao String vrednosti.
*
* @author Sara
* @version 0.1
*/
public class Mesto implements GenericEntity {

	/**
	 * MestoId kao Long.
	 */
    private Long mestoId;
    
    /**
	 * Ptt mesta kao String.
	 */
    private String ptt;
    
    /**
	 * Naziv mesta kao String.
	 */
    private String naziv;

    /**
   	 * Kontruktor koji inicijalizuje objekat i nista vise.
   	 */
    public Mesto() {
    }

    /**
	 * Konstruktor koji inicijalizuje objekat i postavlja vrednosti za mestoId, ptt i naziv mesta.
	 * 
	 * @param mestoId MestoId kao Long.
	 * @param ptt Ptt mesta kao String.
	 * @param naziv Naziv mesta kao String.
	 * 
	 */
    public Mesto(Long mestoId, String ptt, String naziv) {
        this.mestoId = mestoId;
        this.ptt = ptt;
        this.naziv = naziv;
    }

    /**
	 * Vraca naziv mesta.
	 * 
	 * @return Naziv mesta kao String.
	 */
    public String getNaziv() {
        return naziv;
    }

    /**
	 * Postavlja naziv mesta na novu vrednost.
	 * 
	 * @param naziv Naziv mesta kao String.
	 * 
	 */
    public void setNaziv(String naziv) {
    	if(naziv == null)
			throw new NullPointerException("Naziv ne sme biti null");
    	if(naziv.length() <= 1) //Ub ima 2 slova
			throw new RuntimeException("Naziv mesta mora imati vise od 1 znaka");
        this.naziv = naziv;
    }

    /**
	 * Vraca id mesta.
	 * 
	 * @return MestoId kao Long.
	 */
    public Long getMestoId() {
        return mestoId;
    }

    /**
	 * Postavlja id mesta na novu vrednost.
	 * 
	 * @param mestoId MestoId kao Long.
	 * 
	 */
    public void setMestoId(Long mestoId) {
    	if(mestoId == null)
			throw new NullPointerException("Id ne sme biti null");
        this.mestoId = mestoId;
    }

    /**
	 * Vraca ptt mesta.
	 * 
	 * @return Ptt mesta kao String.
	 */
    public String getPtt() {
        return ptt;
    }

    /**
	 * Postavlja ptt mesta na novu vrednost.
	 * 
	 * @param ptt Ptt mesta kao String.
	 */
    public void setPtt(String ptt) {
    	if(ptt == null)
			throw new NullPointerException("Ptt ne sme biti null");
    	
        this.ptt = ptt;
    }

    /**
	 * @return String sa svim podacima o Mestu.
	 */
    @Override
    public String toString() {
        return naziv;
    }

    /**
	 * @return Int koji predstavlja hash kod za objekat klase Mesto.
	 */
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /**
	 * Poredi dva mesta i vraca true ako su isti i false ako nisu.
	 * 
	 * Mesta se porede po mestoId-ju i moraju da budu isti.
	 * 
	 * @return 
	 * <ul>
	 * 			<li>true ako su oba objekta klase Mesto i imaju isti mestoId</li>
	 * 			<li>false u svim ostalim slucajevima</li>
	 * </ul>
	 */
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
        final Mesto other = (Mesto) obj;
        if (!Objects.equals(this.mestoId, other.mestoId)) {
            return false;
        }
        return true;
    }

    @Override
    public String getTableName() {
        return " mesto ";
    }

    @Override
    public String getColumnNamesForInsert() {
    	return "";
    }

    @Override
    public String getInsertValues() {
    	return "";    }

    @Override
    public String getAlijas() {
        return " as m ";
    }

    @Override
    public void setId(Long id) {
    	
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
    	return "";    }

    @Override
    public List<GenericEntity> makeList(ResultSet rs) throws Exception {
        List<GenericEntity> lista = new ArrayList<>();
        while (rs.next()) {
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
            lista.add(mesto);
            System.out.println(mesto);
        }
        rs.close();
        return lista;
    }

}
