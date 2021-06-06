/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.nprog.zgradezajednicki.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
*
*Klasa koja predstavlja sednicu skupstine i implementira interfejs GenericEntity.
*
*Sednica skupstine ima sednicuSkupstineId kao Long, datum odrzavanja kao Date, broj prisutnih kao int, dnevni red kao String, stambenu zajednicu kao StambenuZajednicu i listu vlasnika koji su prisustvovali toj sednici skupstine kao List<VlasnikPosebnogDela>.
*
*
* @author Sara
* @version 0.1
*/
public class SednicaSkupstine implements GenericEntity {

	/**
	 * Id sednice skupstine kao Long.
	 */
    private Long sednicaSkupstineId;
    
    /**
	 * Datum odrzavanja sednice kao Date.
	 */
    private Date datumOdrzavanja;
    
    /**
	 * Broj prisutnih na sednici kao int.
	 */
    private int brojPrisutnih;
    
    /**
	 * Dnevni red sednice kao String.
	 */
    private String dnevniRed;
    
    /**
	 * Stambena zajednica u kojoj je odrzana sednica kao StambenaZajednica.
	 */
    private StambenaZajednica stambenaZajednica;
    
    /**
	 * Lista vlasnika stanova koji su prisustvovali sednici kao List<VlasnikPosebnogDela>.
	 */
    private List<VlasnikPosebnogDela> vlasnici;

    /**
   	 * Kontruktor koji inicijalizuje objekat i postavlja listu vlasnika na novu praznu listu.
   	 */
    public SednicaSkupstine() {
        vlasnici = new ArrayList<>();
        datumOdrzavanja = new Date();
        stambenaZajednica = new StambenaZajednica();
    }

    /**
	 * Konstruktor koji inicijalizuje objekat i postavlja vrednosti za sednicuSkupstineId, datum odrzavanja, broj prisutnih, dnevni red, stambenu zajednicu i vlasnike.
	 * 
	 * @param sednicaSkupstineId SednicaSkupstineId kao Long.
	 * @param datumOdrzavanja Datum odrzavanja sednice kao Date.
	 * @param brojPrisutnih Broj prisutnih vlasnika kao int.
	 * @param dnevniRed Dnevni red sednice kao String.
	 * @param stambenaZajednica Stambena zajednica kao StambenaZajednica.
	 * @param vlasnici Vlasnici koji su prisustvovali kao List<VlasnikPosebnogDela>.
	 */
    public SednicaSkupstine(Long sednicaSkupstineId, Date datumOdrzavanja, 
            int brojPrisutnih, String dnevniRed, StambenaZajednica stambenaZajednica,
            List<VlasnikPosebnogDela> vlasnici) {
        this.sednicaSkupstineId = sednicaSkupstineId;
        this.datumOdrzavanja = datumOdrzavanja;
        this.brojPrisutnih = brojPrisutnih;
        this.dnevniRed = dnevniRed;
        this.stambenaZajednica = stambenaZajednica;
        this.vlasnici = vlasnici;
    }


    /**
	 * Vraca listu vlasnika koji su prisustvovali sednici.
	 * 
	 * @return Lista vlasnika kao List<VlasnikPosebnogDela>.
	 */
    public List<VlasnikPosebnogDela> getVlasnici() {
        return vlasnici;
    }

    /**
   	 * Postavlja listu vlasnika koji su prisustvovali sednici na novu vrednost.
   	 * 
   	 * @param vlasnici Vlasnici kao List<VlasnikPosebnogDela>.
   	 * 
   	 */
    public void setVlasnici(List<VlasnikPosebnogDela> vlasnici) {
        this.vlasnici = vlasnici;
    }

    /**
   	 * Vraca id sednice skupstine.
   	 * 
   	 * @return Id sednice skupstine kao Long.
   	 */
    public Long getSednicaSkupstineId() {
        return sednicaSkupstineId;
    }

    /**
	 * Postavlja id sednice skupstine na novu vrednost.
	 * 
	 * @param sednicaSkupstineId SednicaSkupstineId kao Long.
	 * 
	 */
    public void setSednicaSkupstineId(Long sednicaSkupstineId) {
        this.sednicaSkupstineId = sednicaSkupstineId;
    }

    /**
	 * Vraca datum odrzavanja sednice.
	 * 
	 * @return Datum odrzavanja kao Date.
	 */
    public Date getDatumOdrzavanja() {
        return datumOdrzavanja;
    }

    /**
	 * Postavlja datum odrzavanja sednice na novu vrednost.
	 * 
	 * @param datumOdrzavanja DatumOdrzavanja sednice kao Date.
	 */
    public void setDatumOdrzavanja(Date datumOdrzavanja) {
        this.datumOdrzavanja = datumOdrzavanja;
    }

    /**
	 * Vraca broj prisutnih vlasnika na sednici.
	 * 
	 * @return Broj prisutnih vlasnika kao int.
	 */
    public int getBrojPrisutnih() {
        return brojPrisutnih;
    }

    /**
	 * Postavlja broj prisutnih vlasnika na novu vrednost.
	 * 
	 * @param brojPrisutnih Broj prisutnih vlasnika kao int.
	 */
    public void setBrojPrisutnih(int brojPrisutnih) {
        this.brojPrisutnih = brojPrisutnih;
    }

    /**
	 * Vraca dnevni red sednice.
	 * 
	 * @return Dnevni red sednice kao String.
	 */
    public String getDnevniRed() {
        return dnevniRed;
    }

    /**
	 * Postavlja dnevni red sednice na novu vrednost.
	 * 
	 * @param dnevniRed DnevniRed sednice kao String.
	 */
    public void setDnevniRed(String dnevniRed) {
        this.dnevniRed = dnevniRed;
    }

    /**
	 * Vraca stambenu zajednicu u kojoj je odrzana sednica skupstine.
	 * 
	 * @return Stambena zajednica kao StambenaZajednica.
	 */
    public StambenaZajednica getStambenaZajednica() {
        return stambenaZajednica;
    }

    /**
	 * Postavlja stambenu zajednicu u kojoj je odrzana sednica skupstine na novu vrednost.
	 * 
	 * @param stambenaZajednica StambenaZajednica sednice skupstine kao StambenaZajednica.
	 */
    public void setStambenaZajednica(StambenaZajednica stambenaZajednica) {
        this.stambenaZajednica = stambenaZajednica;
    }

    @Override
    public String getTableName() {
        return "sednica_skupstine";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "datumodrzavanja, brojprisutnih, dnevnired, stambenazajednicaid";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        sb.append("'").append(format.format(datumOdrzavanja)).append("',")
                .append(brojPrisutnih).append(",")
                .append("'").append(dnevniRed).append("',")
                .append("").append(stambenaZajednica.getStambenaZajednicaId()).append("");
        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public String getAlijas() {
        return " as ss";
    }

    @Override
    public void setId(Long id) {
        this.sednicaSkupstineId = id;
    }

    @Override
    public String getUpdateValues() {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        sb.append(" datumodrzavanja = '").append(format.format(datumOdrzavanja)).append("',")
                .append(" brojprisutnih = ").append(brojPrisutnih).append(",")
                .append(" dnevnired = ").append("'").append(dnevniRed).append("',")
                .append(" stambenazajednicaid = ").append(stambenaZajednica.getStambenaZajednicaId()).append("");
        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public String getPrimaryKeyValue() {
        return " sednicaskupstineid = " + sednicaSkupstineId;
    }

    @Override
    public String getJoin() {
        return " inner join stambena_zajednica AS s on (s.stambenazajednicaid = ss.stambenazajednicaid) ";
    }

    @Override
    public String selectWhere() {
        if (stambenaZajednica != null) {
            return " where s.stambenazajednicaid = " + stambenaZajednica.getStambenaZajednicaId();
        }
        return "";
    }

    @Override
    public List<GenericEntity> makeList(ResultSet rs) throws Exception {
        List<GenericEntity> lista = new ArrayList<>();
        while (rs.next()) {
            SednicaSkupstine sednica = new SednicaSkupstine();
            sednica.setSednicaSkupstineId(rs.getLong("sednicaskupstineid"));
            sednica.setDatumOdrzavanja(rs.getDate("datumodrzavanja"));
            sednica.setBrojPrisutnih(rs.getInt("brojprisutnih"));
            sednica.setDnevniRed(rs.getString("dnevnired"));

            StambenaZajednica stambenaZajednica = new StambenaZajednica();
            stambenaZajednica.setStambenaZajednicaId(rs.getLong("s.stambenazajednicaid"));

            sednica.setStambenaZajednica(stambenaZajednica);
            lista.add(sednica);
        }

        return lista;
    }
}
