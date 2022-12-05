/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1p_rosario_garcia_guerrero;

/**
 *
 * @author Cliente Intel
 */

public class VueloReserva {
    private int codigoVueloReserva;
    private Vuelo vuelo;
    private TipoVuelo tipoVuelo;
    private Asiento asiento;
    private TipoTarifa tipoTarifa;
    
    /**
     * Constructor que retorna un objeto de tipo VueloReserva
     * @param vuelo; De tipo Vuelo
     * @param tipoVuelo; de tipo TipoVuelo
     * @param asiento; de tipo Asiento
     * @param tipoTarifa; de tipo tipoTarifa
     */
    public VueloReserva(Vuelo vuelo, TipoVuelo tipoVuelo, Asiento asiento, TipoTarifa tipoTarifa) { 
        this.vuelo = vuelo;
        this.tipoVuelo = tipoVuelo;
        this.asiento = asiento;
        this.codigoVueloReserva= (int) (Math.random()* ((10000 - 1000) + 1) + 1000);
        this.tipoTarifa = tipoTarifa;
    }

    /**Metodo get
     * @return codigoVueloReserva valor a retornar
     */
    public int getCodigoVueloReserva() {
        return codigoVueloReserva;
    }

    /**Metodo set
     * @param codigoVueloReserva valor a retornar
     */
    public void setCodigoVueloReserva(int codigoVueloReserva) {
        this.codigoVueloReserva = codigoVueloReserva;
    }

    /**Metodo get
     * @return vuelo valor a retornar
     */
    public Vuelo getVuelo() {
        return vuelo;
    }

    /**Metodo set
     * @param vuelo valor a retornar
     */
    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    /**Metodo get
     * @return tipoVuelo valor a retornar
     */
    public TipoVuelo getTipoVuelo() {
        return tipoVuelo;
    }

    /**Metodo set
     * @param tipoVuelo valor a retornar
     */
    public void setTipoVuelo(TipoVuelo tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }

    /**Metodo get
     * @return asiento valor a retornar
     */
    public Asiento getAsiento() {
        return asiento;
    }

    /**Metodo set
     * @param asiento valor a retornar
     */
    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

    /**Metodo get
     * @return tipoTarifa valor a retornar
     */
    public TipoTarifa getTipoTarifa() {
        return tipoTarifa;
    }

    /**Metodo set
     * @param tipoTarifa valor a retornar
     */
    public void setTipoTarifa(TipoTarifa tipoTarifa) {
        this.tipoTarifa = tipoTarifa;
    }

    /**Metodo toString
     * @return informacion valor a retornar
     */
    @Override
    public String toString() {
        return "VueloReserva{" + "codigoVueloReserva=" + codigoVueloReserva + ", vuelo=" + vuelo + ", tipoVuelo=" + tipoVuelo + ", asiento=" + asiento + ", tipoTarifa=" + tipoTarifa + '}';
    }
    
    
    
     
    
    
    
}
