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

    public VueloReserva(Vuelo vuelo, TipoVuelo tipoVuelo, Asiento asiento) { 
        this.vuelo = vuelo;
        this.tipoVuelo = tipoVuelo;
        this.asiento = asiento;
        this.codigoVueloReserva= (int) (Math.random()* ((10000 - 1000) + 1) + 1000);
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
    
    
     
    
    
    
}
