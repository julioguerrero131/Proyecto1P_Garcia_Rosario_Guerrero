/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1p_rosario_garcia_guerrero;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Cliente Intel
 */
public class Itinerario {

    private String codigoItinerario;
    private String origen;
    private String destino;
    private String horaSalida;
    private String horaLlegada;
    private String duracion;
    
    /**
     * Constructor que retorna un objeto de tipo Itinerario
     * @param codigoItinerario; de tipo String
     * @param origen; de tipo String
     * @param destino; de tipo String
     * @param horaSalida; de tipo String
     * @param horaLlegada; de tipo String
     * @param duracion; de tipo String
     */
    public Itinerario(String codigoItinerario, String origen, String destino, String horaSalida, String horaLlegada, String duracion) {
        this.codigoItinerario = codigoItinerario;
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.duracion = duracion;
    }
    /**
     * Metodo que retorna el indice de tipo int
     * @param lista; de tipo ArrayList String 
     * @return int; Devuelve un indice seleccionado por el Cliente para el Origen
     */
    public static int elegirOrigen(ArrayList<String> lista) {
        System.out.println("------ORIGEN-----");
        int cont = 1;
        for (String o : lista) {
            System.out.println(cont + "." + o);
            cont++;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Elegir punto partida: ");
        int op = sc.nextInt();
        sc.nextLine();
        return op;
    }
    
    /**
     * Metodo que retorna un indice de tipo int 
     * @param lista; de tipo ArrayList String 
     * @return int; Duvuelve indice seleccionado por el Cliente para el Destino
     */

    public static int elegirDestino(ArrayList<String> lista) {
        System.out.println("------DESTINO-----");
        int cont = 1;
        for (String o : lista) {
            System.out.println(cont + "." + o);
            cont++;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Elegir punto partida: ");
        int op = sc.nextInt();
        sc.nextLine();
        return op;
    }

    /**
     * @return codigoItinerario
     */
    //getters y setters
    public String getCodigoItinerario() {
        return codigoItinerario;
    }
/**
 * @param codigoItinerario, String
 */
    public void setCodigoItinerario(String codigoItinerario) {
        this.codigoItinerario = codigoItinerario;
    }
/**
 * @return origen
 */
    public String getOrigen() {
        return origen;
    }
/**
 * @param origen, String
 */
    public void setOrigen(String origen) {
        this.origen = origen;
    }
/**
 * @return destino
 */
    public String getDestino() {
        return destino;
    }
/**
 * @param destino String
 */
    public void setDestino(String destino) {
        this.destino = destino;
    }
/**
 * @return String
 */
    public String getHoraSalida() {
        return horaSalida;
    }
/**
 * @param horaSalida, String
 */
    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }
/**
 * @return String
 */
    public String getHoraLlegada() {
        return horaLlegada;
    }
/**
 * @param horaLlegada, String
 */
    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }
/**
 * @return String
 */
    public String getDuracion() {
        return duracion;
    }
/**
 * @param duracion, String
 */
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

/**
 * @return String
 */
    @Override
    public String toString() {
        return "Itinerario{" + "codigoItinerario=" + codigoItinerario + ", origen=" + origen + ", destino=" + destino + ", horaSalida=" + horaSalida + ", horaLlegada=" + horaLlegada + ", duracion=" + duracion + '}';
    }

}
