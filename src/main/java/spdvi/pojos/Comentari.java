/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spdvi.pojos;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author angel
 */
public class Comentari {
    private String usuari;
    private String espai;
    private String text;
    private LocalDate data;
    private LocalTime hora;

    public Comentari(String usuari, String espai, String text, LocalDate data, LocalTime hora) {
        this.usuari = usuari;
        this.espai = espai;
        this.text = text;
        this.data = data;
        this.hora = hora;
    }

    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }

    public String getEspai() {
        return espai;
    }

    public void setEspai(String espai) {
        this.espai = espai;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return usuari + " - " + data + ", " + hora + " - " + text;
    }
    
    
}
