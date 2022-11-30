/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1p_rosario_garcia_guerrero;
import java.util.ArrayList;
/**
 *
 * @author julio
 */
public class Avion {
    
    private String codigoAvion;
    private int capacidad;
    private ArrayList<Asiento> asientosAvion = new ArrayList(); 

    public Avion(String codigoAvion, int capacidad) {
        this.codigoAvion = codigoAvion;
        this.capacidad = capacidad;
        for (Asiento a: Sistema.listaAsientos){
            if (a.getCodigoAvion().equals(codigoAvion)){
                asientosAvion.add(a);
            }
        }
    }

    public String getCodigoAvion() {
        return codigoAvion;
    }

    public void setCodigoAvion(String codigoAvion) {
        this.codigoAvion = codigoAvion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public ArrayList<Asiento> getAsientosAvion() {
        return asientosAvion;
    }

    public void setAsientosAvion(ArrayList<Asiento> asientosAvion) {
        this.asientosAvion = asientosAvion;
    }

    @Override
    public String toString() {
        return "Avion{" + "codigoAvion=" + codigoAvion + ", capacidad=" + capacidad + ", asientosAvion=" + asientosAvion + '}';
    }
    
    
    
    
}
