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
    /**
     * Constructor que retorna un objeto de tipo Avion
     * @param codigoAvion; de tipo String
     * @param capacidad; de tipo int
     */
    
    public Avion(String codigoAvion, int capacidad) {
        this.codigoAvion = codigoAvion;
        this.capacidad = capacidad;
        for (Asiento a: Sistema.listaAsientos){
            if (a.getCodigoAvion().equals(codigoAvion)){
                asientosAvion.add(a);
            }
        }
    }

    /**
     * @return getCodigoAvion
     */
    public String getCodigoAvion() {
        return codigoAvion;
    }
    /**
     * @param codigoAvion, String
     */
    public void setCodigoAvion(String codigoAvion) {
        this.codigoAvion = codigoAvion;
    }
/**
 * @return capacidad
 */
    public int getCapacidad() {
        return capacidad;
    }
/**
 * @param capacidad, int
 */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
/**
 * @return ArrayList Asiento 
 */
    public ArrayList<Asiento> getAsientosAvion() {
        return asientosAvion;
    }
/**
 * @param asientosAvion, ArrayList Asiento 
 */
    public void setAsientosAvion(ArrayList<Asiento> asientosAvion) {
        this.asientosAvion = asientosAvion;
    }
/**
 * @return String 
 */
    @Override
    public String toString() {
        return "Avion{" + "codigoAvion=" + codigoAvion + ", capacidad=" + capacidad + ", asientosAvion=" + asientosAvion + '}';
    }
    
    
    
    
}
