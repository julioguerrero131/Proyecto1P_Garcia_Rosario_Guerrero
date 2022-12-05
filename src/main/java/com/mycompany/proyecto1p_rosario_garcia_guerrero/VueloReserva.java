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

    public int getCodigoVueloReserva() {
        return codigoVueloReserva;
    }

    public void setCodigoVueloReserva(int codigoVueloReserva) {
        this.codigoVueloReserva = codigoVueloReserva;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public TipoVuelo getTipoVuelo() {
        return tipoVuelo;
    }

    public void setTipoVuelo(TipoVuelo tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

    public TipoTarifa getTipoTarifa() {
        return tipoTarifa;
    }

    public void setTipoTarifa(TipoTarifa tipoTarifa) {
        this.tipoTarifa = tipoTarifa;
    }

    @Override
    public String toString() {
        return "VueloReserva{" + "codigoVueloReserva=" + codigoVueloReserva + ", vuelo=" + vuelo + ", tipoVuelo=" + tipoVuelo + ", asiento=" + asiento + ", tipoTarifa=" + tipoTarifa + '}';
    }
    
    
    
     
    
    
    
}
