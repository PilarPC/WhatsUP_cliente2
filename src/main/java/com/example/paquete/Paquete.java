package com.example.paquete;

import java.io.Serializable;

public class Paquete implements Serializable {
    private String mensaje;
    private String  emisor = "Miguel";
    private int puertoE;
    private int puertoR;

    public Paquete(String mensaje, int puertoE, int getPuertoR) {
        this.mensaje = mensaje;
        this.puertoE = puertoE;
        this.puertoR = getPuertoR;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor= emisor;
    }

    public int getPuertoE() {
        return puertoE;
    }

    public void setPuertoE(int puertoE) {
        this.puertoE = puertoE;
    }

    public int getpPuertoR() {
        return puertoR;
    }

    public void setPuertoR(int getPuertoR) {
        this.puertoR = getPuertoR;
    }
}
