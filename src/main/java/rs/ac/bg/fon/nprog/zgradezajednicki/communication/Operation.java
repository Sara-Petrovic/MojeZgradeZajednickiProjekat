/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.nprog.zgradezajednicki.communication;

import java.io.Serializable;

/**
 *
 * @author Sara
 */
public enum Operation implements Serializable{
    LOGIN, 
    UCITAJ_LISTU_MESTA,
    UNESI_STAMBENU_ZAJEDNICU,
    UCITAJ_LISTU_STAMBENIH_ZAJEDNICA,//SVE
    NADJI_STAMBENE_ZAJEDNICE,
    OBRISI_STAMBENU_ZAJEDNICU,
    ZAPAMTI_STAMBENU_ZAJEDNICU,
    UCITAJ_STAMBENU_ZAJEDNICU,
    UNESI_VLASNIKA_POSEBNOG_DELA,
    ZAPAMTI_VLASNIKA_POSEBNOG_DELA,
    NADJI_VLASNIKE_POSEBNIH_DELOVA,
    UCITAJ_LISTU_VLASNIKA_POSEBNIH_DELOVA,//!!!
    UCITAJ_VLASNIKA_POSEBNOG_DELA,
    KREIRAJ_SEDNICU_SKUPSTINE,
    ZAPAMTI_SEDNICU_SKUPSTINE,
    NADJI_SEDNICE_SKUPSTINA,
    KRAJ
    
}
