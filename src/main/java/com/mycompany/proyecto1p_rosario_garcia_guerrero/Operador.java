/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1p_rosario_garcia_guerrero;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author julio
 */
public class Operador extends Usuario {

    double sueldo;
    
    /**
     * Constructor que retorna un objeto de tipo Operador
     * @param cedula atributo heredado de la clase Uusuario
     * @param nombres atributo heredado de la clase Uusuario
     * @param edad atributo heredado de la clase Uusuario
     * @param mail atributo heredado de la clase Uusuario
     * @param user atributo heredado de la clase Uusuario
     * @param password atributo heredado de la clase Uusuario
     * @param rol atributo heredado de la clase Uusuario
     * @param sueldo atributo propio de la clase Operador
     */

    public Operador(String cedula, String nombres, int edad, String mail, String user, String password, char rol, double sueldo) {
        super(cedula, nombres, edad, mail, user, password, rol);
        this.sueldo = sueldo;
    }
    
    @Override
    
    /**
     * Este metodo retorna void
     * No recibe parametros
     * Retorna una lista de los vuelos y las reservas en cada uno
     */
    
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
    
    /**Este metodo retorna void
     * No recibe parametros
     * Retorna una lista de los usuarios 
     */
    
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
/**
 * @return sueldo 
 */
    public double getSueldo() {
        return sueldo;
    }
/**
 * @param sueldo, double 
 */
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
/**
 * @return String 
 */
    @Override
    public String toString() {
        return this.nombres + ",OPERADOR," + this.sueldo;
    }

}
