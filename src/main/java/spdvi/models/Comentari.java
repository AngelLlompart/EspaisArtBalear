/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spdvi.models;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author angel
 */
public class Comentari {
    private String email;
    private String espai;
    private String text;
    private LocalDate data;
    private LocalTime hora;
    private String usuari;

    public Comentari(String email, String espai, String text, LocalDate data, LocalTime hora, String usuari) {
        this.email = email;
        this.espai = espai;
        this.text = text;
        this.data = data;
        this.hora = hora;
        this.usuari = usuari;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
