/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1p_rosario_garcia_guerrero;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Cliente Intel
 */
public class test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Numero de Documento:");
        String numDocumento = sc.nextLine();
        while (!(numDocumento.length() == 10) || numDocumento == null || !numDocumento.matches("[0-9]+")) { //validacion
            System.out.println("Numero de Documento (Ingrese un numero valido):");
            numDocumento = sc.nextLine();
        }
        System.out.println("");

//        Date fecha1= new Date();
//        String fecha= new SimpleDateFormat("dd/MM/yyyy").format(fecha1);
////        System.out.println(LocalDate.now());
//        System.out.println(fecha);
//        String cadena = codigoAleatorio();
//        System.out.println(cadena);
//        //String aleatorio
//        
//    }
//    
//    public static String codigoAleatorio() {  //cadena aleatoria para el codigo
//        int longitud  = 5;
//        // El banco de caracteres
//        String banco = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        // La cadena en donde iremos agregando un carácter aleatorio
//        String cadena = "";
//        for (int x = 0; x < longitud; x++) {
//            int indiceAleatorio = numeroAleatorioEnRango(0, banco.length() - 1);
//            char caracterAleatorio = banco.charAt(indiceAleatorio);
//            cadena += caracterAleatorio;
//        }
//        return cadena;
//    }
//    public static int numeroAleatorioEnRango(int minimo, int maximo) {
//        // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
//        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }
}
