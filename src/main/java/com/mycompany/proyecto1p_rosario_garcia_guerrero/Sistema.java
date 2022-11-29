/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.proyecto1p_rosario_garcia_guerrero;

import java.util.ArrayList;
import manejoArchivos.ManejoArchivos;
import java.util.Scanner;

/**
 *
 * @author julio
 */
public class Sistema {

    /**
     * @param args the command line arguments
     */
//    private static ArrayList<Usuario> listaUsuario;
//    Scanner sc= new Scanner(System.in);
    private static ArrayList<Reserva> listaReserva;
    private static ArrayList<String> itinerarios = ManejoArchivos.LeeFichero("itinerarios.txt");
    private static ArrayList<String> vuelos = ManejoArchivos.LeeFichero("vuelos.txt");
    public static ArrayList<String> archivoUsuario = ManejoArchivos.LeeFichero("usuarios.txt");
    public static ArrayList<String> listaAsiento = ManejoArchivos.LeeFichero("asientos.txt");
    public static ArrayList<String> listaClientes = ManejoArchivos.LeeFichero("clientes.txt");
    public static ArrayList<String> listaOperadores = ManejoArchivos.LeeFichero("operadores.txt");
    
    public static ArrayList<Usuario>lista_usuarios= new ArrayList<>();

    public static void main(String[] args) {
        // TODO code application logic here

        iniciarSesion(archivoUsuario);

    }

    public static String ingresoSesionUsuario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("USUARIO: ");
        String u = sc.nextLine().toLowerCase();
        return u;
    }

    public static String ingresoSesionContraseña() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Contraseña: ");
        String p = sc.nextLine().toLowerCase();
        return p;
    }
    
    public static boolean verificarUsuario(String u){
        for(int i=1; i< archivoUsuario.size()-1; i++){
            String []usuarios= archivoUsuario.get(i).split(",");
            Usuario usuario_dato= new Usuario(usuarios[0],usuarios[1],Integer.parseInt(usuarios[2]), usuarios[3], usuarios[4], usuarios[5], usuarios[6].charAt(0));
            lista_usuarios.add(usuario_dato);
        }
               for(Usuario usu: lista_usuarios){
                  if(u.equals(usu.getUser())){
                return true;
            }
            
        }
        
        return false;
    }
    
    public static boolean verificarContraseña(String p){
        for(Usuario usu: lista_usuarios){
            if(p.equals(usu.getPassword())){
                return true;
            }
        }
        return false;
    }
    
    
    public static void iniciarSesion(ArrayList<String> listaUsuario) {
        System.out.println("+++++++++++++++++++++++++++++++++++\n");
        System.out.println("\n             BIENVENIDO AL SISTEMA                     \n");
        System.out.println("+++++++++++++++++++++++++++++++++++\n");

        String u = ingresoSesionUsuario();
        String p = ingresoSesionContraseña();
        
        while(verificarUsuario(u)== false || verificarContraseña(p)==false){
         // Si el usuario ingresado no es correcto, entonces true -> 1
         // Si la contra ingresada no es correcta, entonces true --> 1
            System.out.println("Contraseña o Usuario incorrectos. Intente de nuevo.\n");
            u = ingresoSesionUsuario();
            p= ingresoSesionContraseña();            
        }
        
        for(Usuario usu: lista_usuarios){
            if(u.equals(usu.getUser())){
                if(usu.getRol()=='O'){
                    
                }
            }else{
                
            }
        }
        
        }
}
