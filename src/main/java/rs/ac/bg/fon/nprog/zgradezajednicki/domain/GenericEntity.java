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
 * @author Sara
 */
public interface GenericEntity extends Serializable {//ovo je opsti domenski objekat kod profesora

    String getTableName();

    String getColumnNamesForInsert();

    String getInsertValues();
    
    String getAlijas();

    void setId(Long id);

    String getUpdateValues();

    String getPrimaryKeyValue();

    String getJoin();

    String selectWhere();

    List<GenericEntity> makeList(ResultSet rs) throws Exception;



}
