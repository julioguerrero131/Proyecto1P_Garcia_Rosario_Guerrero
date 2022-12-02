/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1p_rosario_garcia_guerrero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author Cliente Intel
 */
public class Vuelo {
    
    private String codigoVuelo;
    private Avion avion;
    private String fechaSalida;
    private String fechaLlegada;
    private Itinerario itinerario;
    private double precio;
    private int precioMillas;
    
    public Vuelo(String codigoVuelo, String fechaSalida, String fechaLlegada, double precio, int precioMillas){
        this.codigoVuelo = codigoVuelo;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.precio = precio;
        this.precioMillas = precioMillas;
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Itinerario getItinerario() {
        return itinerario;
    }

    public void setItinerario(Itinerario itinerario) {
        this.itinerario = itinerario;
    }
    
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getPrecioMillas() {
        return precioMillas;
    }

    public void setPrecioMillas(int precioMillas) {
        this.precioMillas = precioMillas;
    }

    @Override
    public String toString() {
        return "CODIGO:"+this.codigoVuelo+"\nHORA SALIDA:"+this.itinerario.getHoraSalida()+
                "\nHORA LLEGADA:"+this.itinerario.getHoraLlegada()+"\nDURACION:"+this.itinerario.getDuracion()+
                "\nAVION:"+this.avion.getCodigoAvion()+"\nPRECIO:"+this.precio+"\nCOSTO MILLAS:"+this.precioMillas;
    }
    
    
    
}
    

//      

        

