/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.nprog.zgradezajednicki.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 *Interfejs koji predstavlja opsti domenski objekat.
 * @author Sara Petrovic
 */
public interface GenericEntity extends Serializable {

	
	/**
	 * Vraca naziv tabele u bazi.
	 * 
	 *  @return TableName TableName kao String.
	 */
    String getTableName();

    /**
	 * Vraca nazive kolona u koje treba insertovati vrednosti.
	 * 
	 *  @return ColumnNames ColumnNames kao String.
	 */
    String getColumnNamesForInsert();

    /**
	 * Vraca vrednosti koje treba insertovati u tabelu.
	 * 
	 *  @return InsertValues InsertValues kao String.
	 */
    String getInsertValues();
    
    /**
	 * Vraca alijas tabele.
	 * 
	 *  @return Alijas kao String.
	 */
    String getAlijas();

    /**
	 * Postavlja id na novu vrednost.
	 * 
	 * @param id Id kao Long.
	 * 
	 */
    void setId(Long id);

    /**
	 * Vraca vrednosti koje treba izmeniti u tabeli.
	 * 
	 *  @return UpdateValues UpdateValues kao String.
	 */
    String getUpdateValues();

    /**
	 * Vraca primarni kljuc tabele.
	 * 
	 *  @return PrimaryKey PrimaryKey kao String.
	 */
    String getPrimaryKeyValue();

    /**
	 * Vraca join deo upita.
	 * 
	 *  @return Join Join kao String.
	 */
    String getJoin();

    /**
	 * Vraca where uslov u upitu .
	 * 
	 *  @return SelectWhere SelectWhere kao String.
	 */
    String selectWhere();

    /**
	 * Vraca listu domenskih objekata nakon što dobije rezultat izvršavanja upita.
	 * 
	 *  @param ResultSet ResultSet kao ResultSet.
	 *  
	 *  @return List<GenericEntity>  kao List<GenericEntity>.
	 *  
	 *  @throws java.lang.Exception ako je rs null
	 *  
	 */
    List<GenericEntity> makeList(ResultSet rs) throws Exception;



}
