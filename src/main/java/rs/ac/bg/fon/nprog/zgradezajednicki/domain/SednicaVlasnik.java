/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.nprog.zgradezajednicki.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
*
*Klasa koja predstavlja asocijativnu klasu izmedju sednice skupstine i vlasnika posebnog dela i implementira interfejs GenericEntity.
*
*SednicaVlasnik ima sednicu skupstine kao SednicaSkupstine i vlasnika posebnog dela kao VlasnikPosebnogDela.
*
* @author Sara
* @version 0.1
*/
public class SednicaVlasnik implements GenericEntity {

	/**
	 * Sednica skupstine kao SednicaSkupstine.
	 */
	
    private SednicaSkupstine sednicaSkupstine;
    /**
	 * Vlasnik posebnog dela kao VlasnikPosebnogDela.
	 */
    private VlasnikPosebnogDela vlasnikPosebnogDela;

    /**
	 * Kontruktor koji inicijalizuje objekat i nista vise.
	 */
    public SednicaVlasnik() {
    }

    /**
   	 * Konstruktor koji inicijalizuje objekat i postavlja vrednosti za sednicu skupstine i vlasnika posebnog dela.
   	 * 
   	 * @param sednicaSkupstine Sednica skupstine kao SednicaSkupstine.
   	 * @param vlasnikPosebnogDela Vlasnik posebnog dela kao VlasnikPosebnogDela.
   	 */
    public SednicaVlasnik(SednicaSkupstine sednicaSkupstine, 
            VlasnikPosebnogDela vlasnikPosebnogDela) {
        this.sednicaSkupstine = sednicaSkupstine;
        this.vlasnikPosebnogDela = vlasnikPosebnogDela;
    }

    /**
	 * Vraca sednicu skupstine.
	 * 
	 * @return Sednica skupstine kao SednicaSkupstine.
	 */
    public SednicaSkupstine getSednicaSkupstine() {
        return sednicaSkupstine;
    }

    /**
   	 * Postavlja sednicu skupstine na novu vrednost.
   	 * 
   	 * @param sednicaSkupstine Sednica skupstine kao SednicaSkupstine.
   	 * 
   	 */
    public void setSednicaSkupstine(SednicaSkupstine sednicaSkupstine) {
        this.sednicaSkupstine = sednicaSkupstine;
    }

    /**
	 * Vraca vlasnika posebnog dela.
	 * 
	 * @return Vlasnik posebnog dela kao VlasnikPosebnogDela.
	 */
    public VlasnikPosebnogDela getVlasnikPosebnogDela() {
        return vlasnikPosebnogDela;
    }

    /**
   	 * Postavlja vlasnika posebnog dela na novu vrednost.
   	 * 
   	 * @param vlasnikPosebnogDela Vlasnik posebnog dela kao VlasnikPosebnogDela.
   	 * 
   	 */
    public void setVlasnikPosebnogDela(VlasnikPosebnogDela vlasnikPosebnogDela) {
        this.vlasnikPosebnogDela = vlasnikPosebnogDela;
    }

    @Override
    public String getTableName() {
        return "sednica_vlasnik";
    }

    @Override
    public String getColumnNamesForInsert() {
        return " sednicaskupstineid, vlasnikposebnogdelaid ";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(sednicaSkupstine.getSednicaSkupstineId()).append(",")
                .append("").append(vlasnikPosebnogDela.getVlasnikId()).append("");
        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public String getAlijas() {
        return " as sv ";
    }

    @Override
    public void setId(Long id) {
    }

    @Override
    public String getUpdateValues() {
    	return "";
    }

    @Override
    public String getPrimaryKeyValue() {
    	return "";
    }

    @Override
    public String getJoin() {
        return " inner join sednica_skupstine AS ss on (ss.sednicaskupstineid = sv.sednicaskupstineid) inner join vlasnik_posebnog_dela AS v on (sv.vlasnikposebnogdelaid = v.vlasnikid) ";
    }

    @Override
    public String selectWhere() {
        return " where ss.sednicaskupstineid=" + sednicaSkupstine.getSednicaSkupstineId();
    }

    @Override
    public List<GenericEntity> makeList(ResultSet rs) throws Exception {
        List<GenericEntity> lista = new ArrayList<>();
        while (rs.next()) {
            vlasnikPosebnogDela = new VlasnikPosebnogDela();
            vlasnikPosebnogDela.setVlasnikId(rs.getLong("vlasnikid"));
            vlasnikPosebnogDela.setIme(rs.getString("ime"));
            vlasnikPosebnogDela.setPrezime(rs.getString("prezime"));
            vlasnikPosebnogDela.setBrojPosebnogDela(rs.getString("brojposebnogdela"));
            vlasnikPosebnogDela.setVelicinaPosebnogDela(rs.getDouble("velicinaposebnogdela"));
            vlasnikPosebnogDela.setMernaJedinica((MernaJedinica.valueOf(rs.getString("mernajedinica"))));
            vlasnikPosebnogDela.setKontaktVlasnika(rs.getString("kontaktvlasnika"));
            
            SednicaVlasnik sednicaVlasnik = new SednicaVlasnik();
            sednicaVlasnik.setSednicaSkupstine(this.sednicaSkupstine);
            sednicaVlasnik.setVlasnikPosebnogDela(this.vlasnikPosebnogDela);
            lista.add(sednicaVlasnik);
        }
        //rs.close();
        return lista;
    }
}
