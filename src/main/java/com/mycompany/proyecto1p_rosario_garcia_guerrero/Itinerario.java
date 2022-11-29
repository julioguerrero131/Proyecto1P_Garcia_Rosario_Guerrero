/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1p_rosario_garcia_guerrero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Cliente Intel
 */
public class Itinerario {

    protected ArrayList<String> origen = new ArrayList<>(); //repetidos
    protected ArrayList<String> destino = new ArrayList<>(); //repetidos
    protected ArrayList<String> duracion = new ArrayList<>(); //repetidos
    protected ArrayList<String> horaSalida = new ArrayList<>(); //repetidos
    protected ArrayList<String> horaLlegada = new ArrayList<>(); //repetidos

    Scanner sc = new Scanner(System.in);

    ArrayList<String> lista_ori = new ArrayList<>(); // Lista de origen sin repetirse
    ArrayList<String> codigoiti = new ArrayList<>(); // Lista de codigos de itinerarios 
    ArrayList<String> listades = new ArrayList<>(); // Lista de destino sin repetirse
    
    ArrayList<String> lista_ori_copia = new ArrayList<>(); //Lista de origenes para verificacion 
    ArrayList<String> listades_copia = new ArrayList<>();
    
    public Itinerario() {

    }

    public Itinerario(ArrayList<String> itinerario) {
        for (int i = 1; i <= itinerario.size() - 1; i++) {
            
            String[] lista = itinerario.get(i).split(",");
            codigoiti.add(lista[0]);

            origen.add(lista[1]);
            destino.add(lista[2]);
            duracion.add(lista[5]);
            horaSalida.add(lista[3]);
            horaLlegada.add(lista[4]);
            
//            System.out.println(codigoiti);
            if (!lista_ori.contains(lista[1])) {
                lista_ori.add(lista[1]);
                lista_ori_copia.add(lista[1]);

            } else if (!listades.contains(lista[2])) {
                listades.add(lista[2]);
                listades_copia.add(lista[2]);
            }

        }

    }

}
