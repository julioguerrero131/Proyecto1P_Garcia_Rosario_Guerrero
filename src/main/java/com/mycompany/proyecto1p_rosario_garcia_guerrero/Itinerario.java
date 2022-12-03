/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1p_rosario_garcia_guerrero;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Cliente Intel
 */
public class Itinerario {

    private String codigoItinerario;
    private String origen;
    private String destino;
    private String horaSalida;
    private String horaLlegada;
    private String duracion;

    public Itinerario(String codigoItinerario, String origen, String destino, String horaSalida, String horaLlegada, String duracion) {
        this.codigoItinerario = codigoItinerario;
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.duracion = duracion;
    }

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

    //getters y setters
    public String getCodigoItinerario() {
        return codigoItinerario;
    }

    public void setCodigoItinerario(String codigoItinerario) {
        this.codigoItinerario = codigoItinerario;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Itinerario{" + "codigoItinerario=" + codigoItinerario + ", origen=" + origen + ", destino=" + destino + ", horaSalida=" + horaSalida + ", horaLlegada=" + horaLlegada + ", duracion=" + duracion + '}';
    }

}
