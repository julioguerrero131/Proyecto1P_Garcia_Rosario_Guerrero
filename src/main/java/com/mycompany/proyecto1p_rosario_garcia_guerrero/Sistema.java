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
    public static ArrayList<Asiento> listaAsientos = new ArrayList();
    public static ArrayList<Itinerario> listaItinerarios = new ArrayList();
    public static ArrayList<Avion> listaAviones = new ArrayList();
    public static ArrayList<Vuelo> listaVuelos = new ArrayList();
    public static ArrayList<Usuario> listaUsuarios = new ArrayList();

    
//    private static ArrayList<Reserva> listaReserva;
//    private static ArrayList<String> vuelos = ManejoArchivos.LeeFichero("vuelos.txt");
//    public static ArrayList<String> archivoUsuario = ManejoArchivos.LeeFichero("usuarios.txt");
//    public static ArrayList<String> listaAsiento = ManejoArchivos.LeeFichero("asientos.txt");
//    public static ArrayList<String> listaClientes = ManejoArchivos.LeeFichero("clientes.txt");
//    public static ArrayList<String> listaOperadores = ManejoArchivos.LeeFichero("operadores.txt");
    
//    public static ArrayList<Usuario>lista_usuarios= new ArrayList<>();

    public static void main(String[] args) {
        // TODO code application logic here
        cargarAsientos("asientos.txt");
        cargarAviones("aviones.txt");
        cargarItinerarios("itinerarios.txt");
        cargarVuelos("vuelos.txt");
        cargarUsuarios("usuarios.txt", "clientes.txt","operadores.txt");
        
        //ver si todo se cargo correctamente
        int cont = 1;
        System.out.print("---------------Asientos--------------\n");
        for (Asiento a:listaAsientos){
            System.out.println(cont+". "+a);
            cont++;
        }
        System.out.print("---------------Aviones--------------\n");
        cont = 1;
        for (Avion a:listaAviones){
            System.out.println(cont+". "+a);
            cont++;
        }
        cont=1;
        System.out.print("---------------Itinerarios--------------\n");
        for (Itinerario iti:listaItinerarios){
            System.out.println(cont+". "+iti);
            cont++;
        }
         cont=1;
        System.out.print("---------------Vuelos--------------\n");
        for (Vuelo v:listaVuelos){
            System.out.println(cont+". "+v);
            cont++;
        }
         cont=1;
        System.out.print("---------------Usuarios--------------\n");
        for (Usuario u:listaUsuarios){
            System.out.println(cont+". "+u);
            cont++;
        }

    }

    //Comienzo carga de Archivos
    public static void cargarAsientos(String archivoAsientos){
        ArrayList<String> lineasAsientos = ManejoArchivos.LeeFichero(archivoAsientos);
        System.out.println(lineasAsientos); //****************
         
         for(int i=1; i< lineasAsientos.size(); i++){
            String [] datos = lineasAsientos.get(i).split(",");
            System.out.println(datos); //****************
            Asiento asi = new Asiento(datos[0],datos[1],Disponibilidad.valueOf(datos[2]));
            listaAsientos.add(asi);
        }
    }
    
    public static void cargarAviones(String archivoAviones){
        ArrayList<String> lineasAvion = ManejoArchivos.LeeFichero(archivoAviones);
         
         for(int i=1; i< lineasAvion.size(); i++){
            String [] datos = lineasAvion.get(i).split(",");
            Avion avi = new Avion(datos[0],Integer.parseInt(datos[1]));
            listaAviones.add(avi);
        }
    }
    
    public static void cargarItinerarios(String archivoItinerario){
        ArrayList<String> lineasItinerario = ManejoArchivos.LeeFichero(archivoItinerario);
         
         for(int i=1; i< lineasItinerario.size(); i++){
            String [] datos = lineasItinerario.get(i).split(",");
            Itinerario iti = new Itinerario(datos[0],datos[1],datos[2], datos[3], datos[4],  datos[5]);
            listaItinerarios.add(iti);
        }
    
     }
    
    public static void cargarVuelos(String archivoVuelos){
        ArrayList<String> lineasVuelo = ManejoArchivos.LeeFichero(archivoVuelos);
         
         for(int i=1; i< lineasVuelo.size(); i++){
            String [] datos = lineasVuelo.get(i).split(",");
            Vuelo vue = new Vuelo(datos[0],datos[2],datos[3],Double.parseDouble(datos[5]),Integer.parseInt(datos[6]));
            
            for (Avion avion:listaAviones){
                if (avion.getCodigoAvion().equals(datos[1]))
                    vue.setAvion(avion);
            }
            
            for (Itinerario itinerario:listaItinerarios){
                if (itinerario.getCodigoItinerario().equals(datos[4]))
                    vue.setItinerario(itinerario);
            }
            
           listaVuelos.add(vue);
            
        }
    }
    
    public static void cargarUsuarios(String archivoUsuarios, String archivoClientes, String archivoOperadores){
        
        ArrayList<String> lineasUsuario = ManejoArchivos.LeeFichero(archivoUsuarios);
        ArrayList<String> lineasClientes = ManejoArchivos.LeeFichero(archivoClientes);
        lineasClientes.remove(0);
        ArrayList<String> lineasOperadores  = ManejoArchivos.LeeFichero(archivoOperadores);
        lineasOperadores.remove(0);
         
         for(int i=1; i< lineasUsuario.size(); i++){
            String [] datosU = lineasUsuario.get(i).split(",");
            if (datosU[6].charAt(0)=='O'){
                for (String l:lineasOperadores){
                    String[] datosO = l.split(",");
                    if (datosO[0].equals(datosU[0])){
                        Operador operador = new Operador(datosU[0], datosU[1], Integer.parseInt(datosU[2]), datosU[3], datosU[4],datosU[5] ,datosU[6].charAt(0), Double.parseDouble(datosO[1]));
                        listaUsuarios.add(operador);
                        }
                    }
            }
            if (datosU[6].charAt(0)=='S'){
                    for (String l:lineasClientes){
                        String[] datosS = l.split(",");
                        if (datosS[0].equals(datosU[0])){
                            Cliente cliente = new Cliente(datosU[0], datosU[1], Integer.parseInt(datosU[2]), datosU[3], datosU[4],datosU[5] ,datosU[6].charAt(0), datosS[1]);
                            listaUsuarios.add(cliente);
                        }
                    }
            }
            if (datosU[6].charAt(0)=='V'){
                    for (String l:lineasClientes){
                        String[] datosV = l.split(",");
                        if (datosV[0].equals(datosU[0])){
                            ClienteVIP clienteVip = new ClienteVIP(datosU[0], datosU[1], Integer.parseInt(datosU[2]), datosU[3], datosU[4],datosU[5] ,datosU[6].charAt(0), datosV[1], datosV[2], Integer.parseInt(datosV[3]));
                            listaUsuarios.add(clienteVip);
                        }
                    }
            }

            }
        }
    }
    

    //Fin carga de Archivos
    
//    public static String ingresoSesionUsuario() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("USUARIO: ");
//        String u = sc.nextLine().toLowerCase();
//        return u;
//    }
//
//    public static String ingresoSesionContraseña() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Contraseña: ");
//        String p = sc.nextLine().toLowerCase();
//        return p;
//    }
//    
//    public static boolean verificarUsuario(String u){
//        for(int i=1; i< archivoUsuario.size()-1; i++){
//            String []usuarios= archivoUsuario.get(i).split(",");
//            Usuario usuario_dato= new Usuario(usuarios[0],usuarios[1],Integer.parseInt(usuarios[2]), usuarios[3], usuarios[4], usuarios[5], usuarios[6].charAt(0));
//            lista_usuarios.add(usuario_dato);
//        }
//               for(Usuario usu: lista_usuarios){
//                  if(u.equals(usu.getUser())){
//                return true;
//            }
//            
//        }
//        
//        return false;
//    }
//    
//
////     
////     public static void cargarVuelos(String archivoVuelos){
////        ArrayList<String> lineasVuelo = ManejoArchivos.LeeFichero(archivoVuelos);
////         
////         for(int i=1; i< lineasVuelo.size()-1; i++){
////            String [] datosItinerario = lineasVuelo.get(i).split(",");
////            String codigoAvion = datosItinerario[1];
////            for (Avion a:listaAviones){
////                if(codigoAvion.equals(a.getCodigoAvion())){
////                    
////                }
////                listaItinerarios.add(iti);
////            }
////            Vuelo vue = new Vuelo(datosItinerario[0],           a               ,datosItinerario[2], datosItinerario[3], datosItinerario[4],  datosItinerario[5]);
////     }
////     
////     
////    
//    public static boolean verificarContraseña(String p){
//        for(Usuario usu: lista_usuarios){
//            if(p.equals(usu.getPassword())){
//                return true;
//            }
//        }
//        return false;
//    }
//    
//    
//    
//    
//    public static void iniciarSesion(ArrayList<String> listaUsuario) {
//        System.out.println("+++++++++++++++++++++++++++++++++++\n");
//        System.out.println("\n             BIENVENIDO AL SISTEMA                     \n");
//        System.out.println("+++++++++++++++++++++++++++++++++++\n");
//
//        String u = ingresoSesionUsuario();
//        String p = ingresoSesionContraseña();
//        
//        while(verificarUsuario(u)== false || verificarContraseña(p)==false){
//         // Si el usuario ingresado no es correcto, entonces true -> 1
//         // Si la contra ingresada no es correcta, entonces true --> 1
//            System.out.println("Contraseña o Usuario incorrectos. Intente de nuevo.\n");
//            u = ingresoSesionUsuario();
//            p= ingresoSesionContraseña();            
//        }
//        
//        for(Usuario usu: lista_usuarios){
//            if(u.equals(usu.getUser())){
//                if(usu.getRol()=='O'){
//                    
//                }
//            }else{
//                int op = mostrarMenuCliente();
//                switch(op){
//                    case 1:
//                        Vuelo v = new Vuelo(vuelos, itinerarios);
//                        
//                    case 2:
//                    case 3:
//            }
//        }
//        
//        }
//    }
//    
//    public static int mostrarMenuCliente(){
//        Scanner sc = new Scanner(System.in); 
//        System.out.println("1. Comprar tickets aereos.");
//        System.out.println("2. Consultar Reservas.");
//        System.out.println("3. Salir.");
//        System.out.println("");
//        System.out.println("Elija una opción:");
//        int op = sc.nextInt();
//        sc.nextLine();
//        return op;
//    }
//    
//        public static int mostrarMenuOperador(){
//            Scanner sc = new Scanner(System.in);
//            System.out.println("1. Consultar Usuarios.");
//            System.out.println("2. Consultar Reservas.");
//            System.out.println("3. Salir.");
//             System.out.println("");
//            System.out.println("Elija una opción:");
//            int op = sc.nextInt();
//            sc.nextLine();
//            return op;
//        }


