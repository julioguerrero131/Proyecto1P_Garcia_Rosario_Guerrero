/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1p_rosario_garcia_guerrero;

/**
 *
 * @author Cliente Intel
 */
public class Asiento {
    
    private String codigoAvion;
    private String numAsiento;
    private Disponibilidad disponible;
    
    
    /**
     * Constructor que sirve para crear objetos de tipo Asiento
     * @param codigoAvion; de tipo String
     * @param numAsiento; de tipo String
     * @param disponible; de tipo Disponibilidad
     */
    
    public Asiento(String codigoAvion, String numAsiento, Disponibilidad disponible) {
        this.codigoAvion = codigoAvion;
        this.numAsiento = numAsiento;
        this.disponible = disponible;
    }

    public String getCodigoAvion() {
        return codigoAvion;
    }

    public void setCodigoAvion(String codigoAvion) {
        this.codigoAvion = codigoAvion;
    }

    public String getNumAsiento() {
        return numAsiento;
    }

    public void setNumAsiento(String numAsiento) {
        this.numAsiento = numAsiento;
    }

    public Disponibilidad getDisponible() {
        return disponible;
    }

    public void setDisponible(Disponibilidad disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Asiento{" + "codigoAvion=" + codigoAvion + ", numAsiento=" + numAsiento + ", disponible=" + disponible + '}';
    }
    
    
    
}

