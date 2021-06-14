
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
*Klasa koja predstavlja stambenu zajednicu i implementira interfejs GenericEntity.
*
*Stambena zajednica ima stambenaZajednicaId kao Long i ulicu, broj, tekuci racun, banku, pib i maticni broj kao String i mesto kao Mesto.
*
* @author Sara
* @version 0.1
*/
public class StambenaZajednica implements GenericEntity {

	/**
	 * StambenaZajednicaId kao Long.
	 */
    private Long stambenaZajednicaId;
    
    /**
	 * Ulica stambene zajednice kao String.
	 */
    private String ulica;
    
    /**
	 * Broj stambene zajednice kao String.
	 */
    private String broj;
    
    /**
	 * Mesto stambene zajednice kao Mesto.
	 */
    private Mesto mesto;
    
    /**
	 * Tekuci racun stambene zajednice kao String.
	 */
    private String tekuciRacun;
    
    /**
	 * Banka stambene zajednice kao String.
	 */
    private String banka;
    
    /**
	 * Pib stambene zajednice kao String.
	 */
    private String pib;
    
    /**
	 * Maticni broj stambene zajednice kao String.
	 */
    private String maticniBroj;

    
    /**
   	 * Kontruktor koji inicijalizuje objekat i nista vise.
   	 */
    public StambenaZajednica() {
    	mesto = new Mesto();
    }

    /**
   	 * Konstruktor koji inicijalizuje objekat i postavlja vrednosti za id stambene zajednice, ulicu, broj, mesto, tekuci racun, banku, pib i maticni broj.
   	 * 
   	 * @param stambenaZajednicaId StambenaZajednicaId kao Long.
   	 * @param ulica Ulica kao String.
   	 * @param broj Broj stambene zajednice kao String.
   	 * @param mesto Mesto kao Mesto.
   	 * @param tekuciRacun Tekuci racun kao String.
   	 * @param banka Banka kao String.
   	 * @param pib Pib kao String.
   	 * @param maticniBroj Maticni broj stambene zajednice kao String.
   	 */
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

    /**
	 * Vraca banku stambene zajednice.
	 * 
	 * @return Banka stambene zajednice kao String.
	 */
    public String getBanka() {
        return banka;
    }

    /**
	 * Postavlja banku stambene zajednice na novu vrednost.
	 * 
	 * @param banka Banka stambene zajednice kao String.
	 */
    public void setBanka(String banka) {
        this.banka = banka;
    }

    /**
	 * Vraca pib stambene zajednice.
	 * 
	 * @return Pib stambene zajednice kao String.
	 */
    public String getPib() {
        return pib;
    }

    /**
	 * Postavlja pib stambene zajednice na novu vrednost.
	 * 
	 * @param pib Pib stambene zajednice kao String.
	 */
    public void setPib(String pib) {
        this.pib = pib;
    }

    /**
	 * Vraca maticni broj stambene zajednice.
	 * 
	 * @return Maticni broj stambene zajednice kao String.
	 */
    public String getMaticniBroj() {
        return maticniBroj;
    }

    /**
	 * Postavlja maticni broj stambene zajednice na novu vrednost.
	 * 
	 * @param maticniBroj Maticni broj stambene zajednice kao String.
	 */
    public void setMaticniBroj(String maticniBroj) {
        this.maticniBroj = maticniBroj;
    }

    /**
	 * Vraca tekuci racun stambene zajednice.
	 * 
	 * @return Tekuci racun stambene zajednice kao String.
	 */
    public String getTekuciRacun() {
        return tekuciRacun;
    }

    /**
	 * Postavlja tekuci racun stambene zajednice na novu vrednost.
	 * 
	 * @param tekuciRacun Tekuci racun stambene zajednice kao String.
	 */
    public void setTekuciRacun(String tekuciRacun) {
        this.tekuciRacun = tekuciRacun;
    }

    /**
	 * Vraca id stambene zajednice.
	 * 
	 * @return Id stambene zajednice kao Long.
	 */
    public Long getStambenaZajednicaId() {
        return stambenaZajednicaId;
    }

    /**
   	 * Postavlja id stambene zajednice na novu vrednost.
   	 * 
   	 * @param stambenaZajednicaId StambenaZajednicaId kao Long.
   	 * 
   	 */
    public void setStambenaZajednicaId(Long stambenaZajednicaId) {
        this.stambenaZajednicaId = stambenaZajednicaId;
    }

    /**
	 * Vraca ulicu stambene zajednice.
	 * 
	 * @return Ulica stambene zajednice kao String.
	 */
    public String getUlica() {
        return ulica;
    }


    /**
	 * Postavlja ulicu stambene zajednice na novu vrednost.
	 * 
	 * @param ulica Ulica stambene zajednice kao String.
	 */
    public void setUlica(String ulica) {
    	if(ulica.length() <= 4)
			throw new RuntimeException("Ulica mora imati vise od 4 znaka");
        this.ulica = ulica;
    }

    /**
	 * Vraca broj stambene zajednice.
	 * 
	 * @return Broj stambene zajednice kao String.
	 */
    public String getBroj() {
        return broj;
    }

    /**
	 * Postavlja broj stambene zajednice na novu vrednost.
	 * 
	 * @param broj Broj stambene zajednice kao String.
	 */
    public void setBroj(String broj) {
        this.broj = broj;
    }

    /**
   	 * Vraca mesto stambene zajednice.
   	 * 
   	 * @return Mesto stambene zajednice kao Mesto.
   	 */
    public Mesto getMesto() {
        return mesto;
    }

    /**
	 * Postavlja mesto stambene zajednice na novu vrednost.
	 * 
	 * @param mesto Mesto stambene zajednice kao Mesto.
	 */
    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    /**
	 * @return String sa svim podacima o Stambenoj zajednici.
	 */
    @Override
    public String toString() {
        return ulica + " " + broj + ", " + mesto;
    }

    /**
	 * @return Int koji predstavlja hash kod za objekat klase StambenaZajednica.
	 */
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /**
	 * Poredi dve stambene zajednice i vraca true ako su iste i false ako nisu.
	 * 
	 * Stambene zajednice se porede po stambenaZajednicaId-ju i moraju da budu isti.
	 * 
	 * @return 
	 * <ul>
	 * 			<li>true ako su oba objekta klase StambenaZajednica i imaju isti stambenaZajednicaId</li>
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
            
            StambenaZajednica stambenaZajednica = new StambenaZajednica();
            stambenaZajednica.setStambenaZajednicaId(rs.getLong("stambenazajednicaid"));
            String ulica = rs.getString("ulica");
            if(ulica!=null) {
            stambenaZajednica.setUlica(ulica);}
            stambenaZajednica.setBroj(rs.getString("broj"));
            stambenaZajednica.setTekuciRacun(rs.getString("tekuciracun"));
            stambenaZajednica.setBanka(rs.getString("banka"));
            stambenaZajednica.setPib(rs.getString("pib"));
            stambenaZajednica.setMaticniBroj(rs.getString("maticnibroj"));

       
            Mesto mesto = new Mesto(1l,	"1", "Uzice");
            mesto.setMestoId(rs.getLong("mesto"));
            String naziv=rs.getString("naziv");
            if(naziv!=null) {
            	mesto.setNaziv(naziv);
            }
            String ptt=rs.getString("ptt");
            if(ptt!=null) {
            mesto.setPtt(ptt);
            }

            stambenaZajednica.setMesto(mesto);
            lista.add(stambenaZajednica);
            //System.out.println(stambenaZajednica);
        }
        rs.close();
        return lista;
    }

}
