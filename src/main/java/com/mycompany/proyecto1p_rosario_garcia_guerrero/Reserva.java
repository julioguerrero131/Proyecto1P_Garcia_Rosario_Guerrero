/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1p_rosario_garcia_guerrero;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Cliente Intel
 */

public class Reserva {

    private String codigoReserva;
    private Cliente cliente;
    private String fechaCompra;
    private double PrecioSubtotal;
    private int precioMillasTotal;
    private ArrayList<VueloReserva> vueloReservaL = new ArrayList();
    
    /**
     * Constructor de la clase Reserva, crea un objeto de tipo Reserva
     * @param cliente; de tipo Cliente
     * @param PrecioSubtotal; de tipo double
     * @param precioMillasTotal; de tipo int
     * @param vueloReservaL; de tipo ArrayList VueloReserva
     */

    public Reserva(Cliente cliente, double PrecioSubtotal, int precioMillasTotal, ArrayList<VueloReserva> vueloReservaL) {
        this.codigoReserva = codigoAleatorio();
        this.cliente = cliente;
        Date fechaActual = new Date();
        this.fechaCompra = new SimpleDateFormat("dd/MM/yyyy").format(fechaActual);
        this.PrecioSubtotal = PrecioSubtotal;
        this.precioMillasTotal = precioMillasTotal;
        this.vueloReservaL = vueloReservaL;
    }

    /**
     * Metodo que genera un codigo aleatorio de 5 letras
     * @return cadena; cadena de caracteres de 5 letras  
     */

    public static String codigoAleatorio() {  //cadena aleatoria para el codigo
        int longitud = 5;
        // El banco de caracteres
        String banco = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // La cadena en donde iremos agregando un carácter aleatorio
        String cadena = "";
        for (int x = 0; x < longitud; x++) {
            int indiceAleatorio = numeroAleatorioEnRango(0, banco.length() - 1);
            char caracterAleatorio = banco.charAt(indiceAleatorio);
            cadena += caracterAleatorio;
        }
        return cadena;
    }
    
    /**
     * Metodo que retornar un indice aleatorio de tipo int.
     * @param minimo; de tipo int
     * @param maximo; de tipo int
     * @return indice; Devuelve un indice aleatorio
     */

    public static int numeroAleatorioEnRango(int minimo, int maximo) {
        // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);

    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public double getPrecioSubtotal() {
        return PrecioSubtotal;
    }

    public ArrayList<VueloReserva> getVueloReservaL() {
        return vueloReservaL;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public void setPrecioSubtotal(double PrecioSubtotal) {
        this.PrecioSubtotal = PrecioSubtotal;
    }

    public void setVueloReservaL(ArrayList<VueloReserva> vueloReservaL) {
        this.vueloReservaL = vueloReservaL;
    }

    public int getPrecioMillasTotal() {
        return precioMillasTotal;
    }

    public void setPrecioMillasTotal(int precioMillasTotal) {
        this.precioMillasTotal = precioMillasTotal;
    }
    
    

    @Override
    public String toString() {
        return "Nombres:" + cliente.nombres + "\nCedula: " + cliente.cedula + "\nVuelo: " + this.getVueloReservaL().get(0).getVuelo().getCodigoVuelo() + "\nHora Salida: " + this.getVueloReservaL().get(0).getVuelo().getItinerario().getHoraSalida() + "\nHora Llegada: " + this.getVueloReservaL().get(0).getVuelo().getItinerario().getHoraLlegada() + "\nAvion: " + this.getVueloReservaL().get(0).getVuelo().getAvion().getCodigoAvion() + "\nPuerta Embarque: " + ((int)(Math.random()*20) + "\n" + "\n") 
                + "Nombres:" + cliente.nombres + "\nCedula: " + cliente.cedula + "\nVuelo: " + this.getVueloReservaL().get(1).getVuelo().getCodigoVuelo() + "\nHora Salida: " + this.getVueloReservaL().get(1).getVuelo().getItinerario().getHoraSalida() + "\nHora Llegada: " + this.getVueloReservaL().get(1).getVuelo().getItinerario().getHoraLlegada() + "\nAvion: " + this.getVueloReservaL().get(1).getVuelo().getAvion().getCodigoAvion() + "\nPuerta Embarque: " + ((int)(Math.random()*20)) + "\n" + "-------------------------------" + "\n";
    }

  

}
