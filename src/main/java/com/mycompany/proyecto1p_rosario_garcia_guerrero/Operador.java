/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1p_rosario_garcia_guerrero;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author julio
 */
public class Operador extends Usuario {

    double sueldo;

    public Operador(String cedula, String nombres, int edad, String mail, String user, String password, char rol, double sueldo) {
        super(cedula, nombres, edad, mail, user, password, rol);
        this.sueldo = sueldo;
    }

    //public void consultarReserva(){
//         ArrayList<String> listaCodigos = new ArrayList<>();
//         for(Vuelo v: Sistema.listaVuelos){
//             listaCodigos.add(v.getCodigoVuelo());
//         }
//         for (String codigo: listaCodigos){
//             int contador = 0;
//             for(Reserva r: Sistema.listaReservas){
//                 if(codigo.equals(r.getVueloReservaL().get(0).getVuelo().getCodigoVuelo())){
//                     contador++;
//                 }
//                 if(codigo.equals(r.getVueloReservaL().get(1).getVuelo().getCodigoVuelo())){
//                     contador++;
//                 }
//             }
//             System.out.println("Vuelo: " + codigo);
//             System.out.println("Cantidad Reservados: " + contador);
//             System.out.println("-----------------------");
//             
//         }
    //}
    @Override
    public void consultarReserva() {
        ArrayList<String> lineas = ManejoArchivos.LeeFichero("reservas.txt");
        ArrayList<String> listaCodigosR = new ArrayList<>();
        for (String l : lineas) {
            String[] lineasSeparadas = l.split(",");
            listaCodigosR.add(lineasSeparadas[1]);
        }
        for (Vuelo v : Sistema.listaVuelos) {
            int contador = 0;
            for (String c : listaCodigosR) {
                if (v.getCodigoVuelo().equals(c)) {
                    contador++;
                }
            }
            System.out.println("Vuelo: " + v.getCodigoVuelo());
            System.out.println("Cantidad Reservados: " + contador);
            System.out.println("-----------------------");
        }
    }
    
    public void consultarUsuario(){
        for(Usuario u: Sistema.listaUsuarios){
            if(u.getRol()=='O'){
                Operador operador = (Operador) u;
                System.out.println(u);
            } else if(u.getRol()=='S'){
                Cliente cliente = (Cliente) u;
                System.out.println(u);
            } else if(u.getRol()=='V'){
                ClienteVIP clienteVIP = (ClienteVIP) u;
                System.out.println(u);
            }
        }
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return this.nombres + ",OPERADOR," + this.sueldo;
    }

}
