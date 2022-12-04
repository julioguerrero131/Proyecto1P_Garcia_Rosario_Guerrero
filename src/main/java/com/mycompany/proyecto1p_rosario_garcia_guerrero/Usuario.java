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

    public Usuario(String cedula, String nombres, int edad, String mail, String user, String password, char rol) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.edad = edad;
        this.mail = mail;
        this.user = user;
        this.password = password;
        this.rol = rol;
    }

    public abstract void consultarReserva();

    public void ingresarDatosCliente() {
        System.out.println("");
        System.out.println("******************Paso 3*******************"); //PASO 3
        System.out.println("*****************************************");
        System.out.println("");

        Scanner sc = new Scanner(System.in);
        String continuar = "s";
        //(continuar.equals("n")) {
        if(continuar.equals("s")){
            System.out.println("-------------------------DATOS PASAJERO---------------------------");
            String[] nombreApellido = this.getNombres().split(" ");
            System.out.println("Nombres: " + nombreApellido[0]);
            System.out.println("Apellidos: " + nombreApellido[1]);

            System.out.println("Correo:" + this.getMail());
//            String correo = sc.nextLine();
            int cont = 0;
//            while (cont == 0) {
//                if (correo.equals(this.getMail())) {
//                    cont++;
//                }
//                if (cont == 0) {
//                    System.out.println("Ingrese el correo con el que se regitró: ");
//                    correo = sc.nextLine();
//                }
//            }

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
//            String numDocumento = sc.nextLine();
//            cont = 0;
//            while (cont == 0) {
//                if (numDocumento.equals(this.getCedula())) {
//                    cont++;
//                }
//                if (cont == 0) {
//                    System.out.println("Ingrese su numero de documento :");
//                    numDocumento = sc.nextLine();
//                }
//            }

            System.out.println("");
            System.out.println("Desea guardar los datos del pasajero y continuar con el pago (s/n)? ");
            continuar = sc.nextLine().toLowerCase();
            while (!continuar.equals("s") && !continuar.equals("n")) { //validacion
                System.out.println("Opcion incorrecta. Desea guardar los datos del pasajero y continuar con el pago (s/n)? ");
                continuar = sc.nextLine().toLowerCase();
            }
            if (continuar.equals("n")) {
                Sistema.mostrarMenu(this);
            }
        } 
        System.out.println("Ha completado el paso 3");
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
