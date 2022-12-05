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
public class Vuelo extends Sistema {

    private String codigoVuelo;
    private Avion avion;
    private String fechaSalida;
    private String fechaLlegada;
    private Itinerario itinerario;
    private double precio;
    private int precioMillas;
    
    /**
     * Constructor que genera un objeto de tipo Vuelo
     * @param codigoVuelo; de tipo String
     * @param fechaSalida; de tipo String
     * @param fechaLlegada; de tipo String
     * @param precio; de tipo double
     * @param precioMillas ; de tipo int
     */
    
    public Vuelo(String codigoVuelo, String fechaSalida, String fechaLlegada, double precio, int precioMillas) {
        this.codigoVuelo = codigoVuelo;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.precio = precio;
        this.precioMillas = precioMillas;
    }
    
    /**
     * Metodo que retorna un asiento dependiendo de su Disponibilidad
     * @param codigoAv; de tipo String
     * @return asiento; Retorna un asiento si existe disponibilidad, null si no existe disponibilidad
     */
     
    //String codigoAv = avion.getCodigoAvion();
    public static Asiento asignarAsiento(String codigoAv){
        for (Asiento asiento: Sistema.listaAsientos) {
            if(asiento.getCodigoAvion().equals(codigoAv)){
                if(asiento.getDisponible().equals(Disponibilidad.S)){
                    asiento.setDisponible(Disponibilidad.N);
                    return asiento;
                }
            }
        }
        return null;
    }
    
    /**Metodo get
     * @return codigoVuelo valor a retornar
     */
    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    /**Metodo set
     * @param codigoVuelo valor a retornar
     */
    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    /**Metodo get
     * @return avion valor a retornar
     */
    public Avion getAvion() {
        return avion;
    }

    /**Metodo set
     * @param avion valor a retornar
     */
    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    /**Metodo get
     * @return fechaSalida valor a retornar
     */
    public String getFechaSalida() {
        return fechaSalida;
    }

    /**Metodo set
     * @param fechaSalida valor a retornar
     */
    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /**Metodo get
     * @return fechaLlegada valor a retornar
     */
    public String getFechaLlegada() {
        return fechaLlegada;
    }

    /**Metodo set
     * @param fechaLlegada valor a retornar
     */
    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    /**Metodo get
     * @return itinerario valor a retornar
     */
    public Itinerario getItinerario() {
        return itinerario;
    }

    /**Metodo set
     * @param itinerario valor a retornar
     */
    public void setItinerario(Itinerario itinerario) {
        this.itinerario = itinerario;
    }

    /**Metodo get
     * @return precio valor a retornar
     */
    public double getPrecio() {
        return precio;
    }

    /**Metodo set
     * @param precio valor a retornar
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**Metodo get
     * @return precioMillas valor a retornar
     */
    public int getPrecioMillas() {
        return precioMillas;
    }

    /**Metodo set
     * @param precioMillas valor a retornar
     */
    public void setPrecioMillas(int precioMillas) {
        this.precioMillas = precioMillas;
    }
 
    /**Metodo toString
     * @return informacion valor a retornar
     */
    @Override
    public String toString() {
        return "CODIGO:" + this.codigoVuelo + "\nHORA SALIDA:" + this.itinerario.getHoraSalida()
                + "\nHORA LLEGADA:" + this.itinerario.getHoraLlegada() + "\nDURACION:" + this.itinerario.getDuracion()
                + "\nAVION:" + this.avion.getCodigoAvion() + "\nPRECIO:" + this.precio + "\nCOSTO MILLAS:" + this.precioMillas;
    }

}

//      

