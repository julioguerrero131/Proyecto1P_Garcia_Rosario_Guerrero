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
public abstract class Usuario {

    protected String cedula;
    protected String nombres;
    protected int edad;
    protected String mail;
    protected String user;
    protected String password;
    protected char rol;

    /**
     * Constructor que retorna un objeto de tipo Usuario
     *
     * @param cedula atributo propio de la clase Usuario
     * @param nombres atributo propio de la clase Operador
     * @param edad atributo propio de la clase Operador
     * @param mail atributo propio de la clase Operador
     * @param user atributo propio de la clase Operador
     * @param password atributo propio de la clase Operador
     * @param rol atributo propio de la clase Operador
     */
    public Usuario(String cedula, String nombres, int edad, String mail, String user, String password, char rol) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.edad = edad;
        this.mail = mail;
        this.user = user;
        this.password = password;
        this.rol = rol;
    }

    /**
     * Este metodo abstracto retorna void y sirve para ser sobreescrito por las clases hijas 
     * No recibe parametros
     */
    public abstract void consultarReserva();

    /**
     * Este metodo retorna void 
     * No recibe parametros
     * Retorna la informacion del cliente
     */
    public void ingresarDatosCliente() {
        System.out.println("");
        System.out.println("******************Paso 3*******************"); //PASO 3
        System.out.println("*****************************************");
        System.out.println("");

        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------------DATOS PASAJERO---------------------------");
        String[] nombreApellido = this.getNombres().split(" ");
        System.out.println("Nombres: " + nombreApellido[0]);
        System.out.println("Apellidos: " + nombreApellido[1]);

        System.out.println("Correo:" + this.getMail());
        int cont = 0;

        System.out.println("Genero (1. Masculino - 2. Femenino):");
        String genero = sc.nextLine();
        cont = 0;
        while (cont == 0) {
            if (genero.equals("1")) {
                cont++;
            }
            if (genero.equals("2")) {
                cont++;
            }
            if (cont == 0) {
                System.out.println("Genero (1. Masculino - 2. Femenino). Ingrese el numero:");
                genero = sc.nextLine();
            }
        }

        System.out.println("Nacionalidad:");
        String nacionalidad = sc.nextLine();

        System.out.println("Tipo de Documento (1. Cedula - 2. Pasaporte):");
        String tipoDocumento = sc.nextLine();
        cont = 0;
        while (cont == 0) {
            if (tipoDocumento.equals("1")) {
                cont++;
            }
            if (tipoDocumento.equals("2")) {
                cont++;
            }
            if (cont == 0) {
                System.out.println("Tipo de Documento (1. Cedula - 2. Pasaporte). Ingrese el numero:");
                genero = sc.nextLine();
            }
        }

        System.out.println("Numero de Documento:" + this.getCedula());
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getRol() {
        return rol;
    }

    public void setRol(char rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" + "cedula=" + cedula + ", nombres=" + nombres + ", edad=" + edad + ", mail=" + mail + ", user=" + user + ", password=" + password + ", rol=" + rol + '}';
    }

}
