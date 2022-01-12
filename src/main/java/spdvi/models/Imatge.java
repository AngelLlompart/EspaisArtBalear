package spdvi.models;

import java.awt.image.BufferedImage;
import java.net.URL;

/**
 *
 * @author Jaume
 */
public class Imatge {
    
    private String id;
    private String imatge;
    private String espai;

    public Imatge(String id, String imatge, String espai) {
        this.id = id;
        this.imatge = imatge;
        this.espai = espai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImatge() {
        return imatge;
    }

    public void setImatge(String imatge) {
        this.imatge = imatge;
    }

    public String getEspai() {
        return espai;
    }

    public void setEspai(String espai) {
        this.espai = espai;
    }

    @Override
    public String toString() {
        return "Imatges{" + "id=" + id + ", imatge=" + imatge + ", espai=" + espai + '}';
    }
}
