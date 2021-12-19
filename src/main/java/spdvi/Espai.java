/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spdvi;

import com.fasterxml.jackson.databind.util.TypeKey;
import java.util.HashMap;

/**
 *
 * @author angel
 */
public class Espai {
    private String nom;
    private String registre;
    private HashMap<String,String> descripcions;
    private String municipi;
    private String adreca;
    private String email;
    private String web;
    private int telefon;
    private String tipus;
    //o podria ser un ENUM, esta clar que hem de fer un cmbBox amb els diferents tipus per a insertar
    private String modalitat;
    //el mateix d'adalt, pero en aquest cas amb un grup de checkBox
    private String gestor;
    private String serveis;
    //igual que amb modalitats
    private boolean visible;

    public Espai(String nom, String registre, HashMap<String, String> descripcions, String municipi, String adreca, String email, String web, int telefon, String tipus, String modalitat, String gestor, String serveis) {
        this.nom = nom;
        this.registre = registre;
        this.descripcions = descripcions;
        this.municipi = municipi;
        this.adreca = adreca;
        this.email = email;
        this.web = web;
        this.telefon = telefon;
        this.tipus = tipus;
        this.modalitat = modalitat;
        this.gestor = gestor;
        this.serveis = serveis;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRegistre() {
        return registre;
    }

    public void setRegistre(String registre) {
        this.registre = registre;
    }

    public HashMap<String, String> getDescripcions() {
        return descripcions;
    }

    public void setDescripcions(HashMap<String, String> descripcions) {
        this.descripcions = descripcions;
    }

    public String getMunicipi() {
        return municipi;
    }

    public void setMunicipi(String municipi) {
        this.municipi = municipi;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getModalitat() {
        return modalitat;
    }

    public void setModalitat(String modalitat) {
        this.modalitat = modalitat;
    }

    public String getGestor() {
        return gestor;
    }

    public void setGestor(String gestor) {
        this.gestor = gestor;
    }

    public String getServeis() {
        return serveis;
    }

    public void setServeis(String serveis) {
        this.serveis = serveis;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    
    private String desc(){
        String desc = "";
        for (String name: descripcions.keySet()) {
            String value = descripcions.get(name).toString();
            desc += (name + ": " + value + ", ");
        }  
        return desc;
    }
    
    @Override
    public String toString() {
        return  nom + ", " + registre + ", " + desc() + " " + municipi + ", " + adreca + ", " + email + ", " + web + ", " + telefon + ", " + tipus + ", " + modalitat + ", " + gestor + ", " + serveis;
    }
    
    
}
