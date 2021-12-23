package spdvi.pojos;

import java.awt.image.BufferedImage;

/**
 *
 * @author Jaume
 */
public class Imatges {
    
    private int id;
    private BufferedImage imatge;
    private String espai;

    public Imatges(int id, BufferedImage imatge, String espai) {
        this.id = id;
        this.imatge = imatge;
        this.espai = espai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BufferedImage getImatge() {
        return imatge;
    }

    public void setImatge(BufferedImage imatge) {
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
