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
    public static ArrayList<Reserva> listaReservas = new ArrayList();

    public static ArrayList<String> origenes = new ArrayList();
    public static ArrayList<String> destinos = new ArrayList();

//    private static ArrayList<Reserva> listaReserva;
//    private static ArrayList<String> vuelos = ManejoArchivos.LeeFichero("vuelos.txt");
//    public static ArrayList<String> archivoUsuario = ManejoArchivos.LeeFichero("usuarios.txt");
//    public static ArrayList<String> listaAsiento = ManejoArchivos.LeeFichero("asientos.txt");
//    public static ArrayList<String> listaClientes = ManejoArchivos.LeeFichero("clientes.txt");
//    public static ArrayList<String> listaOperadores = ManejoArchivos.LeeFichero("operadores.txt");
//    public static ArrayList<Usuario>lista_usuarios= new ArrayList<>();
    
    /**ESte metodo sirve para ejecutar el programa
     * 
     * @param args 
     * Retorna void
     */
    public static void main(String[] args) {
        // TODO code application logic here
        cargarAsientos("asientos.txt");
        cargarAviones("aviones.txt");
        cargarItinerarios("itinerarios.txt");
        cargarVuelos("vuelos.txt");
        cargarUsuarios("usuarios.txt", "clientes.txt", "operadores.txt");

        Usuario usuario = iniciarSesion();
        boolean fin = false;
        while (fin == false) {
            fin = mostrarMenu(usuario);
        }
    }

    //Comienzo carga de Archivos
    
    /**Este metodo retorna void 
     * 
     * @param archivoAsientos String necesario con la lectura del archivo
     * Retorna una lista con los elementos del archivoAsientos
     */
    public static void cargarAsientos(String archivoAsientos) {
        ArrayList<String> lineasAsientos = ManejoArchivos.LeeFichero(archivoAsientos);

        for (int i = 1; i < lineasAsientos.size(); i++) {
            String[] datos = lineasAsientos.get(i).split(",");
            Asiento asi = new Asiento(datos[0], datos[1], Disponibilidad.valueOf(datos[2]));
            listaAsientos.add(asi);
        }
    }

    /**Este metodo retorna void
     * 
     * @param archivoAviones String con la lectura del archivo
     * Retorna lista con los elementos del archivoAviones
     */
    
    public static void cargarAviones(String archivoAviones) {
        ArrayList<String> lineasAvion = ManejoArchivos.LeeFichero(archivoAviones);

        for (int i = 1; i < lineasAvion.size(); i++) {
            String[] datos = lineasAvion.get(i).split(",");
            Avion avi = new Avion(datos[0], Integer.parseInt(datos[1]));
            listaAviones.add(avi);
        }
    }

    /** Este metodo retorna void
     * 
     * @param archivoItinerario String con la lectura del archivo
     * Retorna lista con los elementos del archivoItinerario
     */
    public static void cargarItinerarios(String archivoItinerario) {
        ArrayList<String> lineasItinerario = ManejoArchivos.LeeFichero(archivoItinerario);

        for (int i = 1; i < lineasItinerario.size(); i++) {
            String[] datos = lineasItinerario.get(i).split(",");
            Itinerario iti = new Itinerario(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5]);
            listaItinerarios.add(iti);

            if (!origenes.contains(datos[1])) {
                origenes.add(datos[1]);
            }
            if (!destinos.contains(datos[2])) {
                destinos.add(datos[2]);
            }

        }

    }

    /**ESte metodo retorna void
     * 
     * @param archivoVuelos String con la lectura del archivo
     * Retorna lista con los elementos del archivoVuelos
     */
    
    public static void cargarVuelos(String archivoVuelos) {
        ArrayList<String> lineasVuelo = ManejoArchivos.LeeFichero(archivoVuelos);

        for (int i = 1; i < lineasVuelo.size(); i++) {
            String[] datos = lineasVuelo.get(i).split(",");
            Vuelo vue = new Vuelo(datos[0], datos[2], datos[3], Double.parseDouble(datos[5]), Integer.parseInt(datos[6]));

            for (Avion avion : listaAviones) {
                if (avion.getCodigoAvion().equals(datos[1])) {
                    vue.setAvion(avion);
                }
            }

            for (Itinerario itinerario : listaItinerarios) {
                if (itinerario.getCodigoItinerario().equals(datos[4])) {
                    vue.setItinerario(itinerario);
                }
            }

            listaVuelos.add(vue);

        }
    }

    /** Este metodo retorna void
     * 
     * @param archivoUsuarios String con la lectura del archivo
     * @param archivoClientes String con la lectura del archivo
     * @param archivoOperadores  String con la lectura del archivo
     * Retorna lista con los elementos de tipo Usuario
     */
    public static void cargarUsuarios(String archivoUsuarios, String archivoClientes, String archivoOperadores) {

        ArrayList<String> lineasUsuario = ManejoArchivos.LeeFichero(archivoUsuarios);
        ArrayList<String> lineasClientes = ManejoArchivos.LeeFichero(archivoClientes);
        lineasClientes.remove(0);
        ArrayList<String> lineasOperadores = ManejoArchivos.LeeFichero(archivoOperadores);
        lineasOperadores.remove(0);

        for (int i = 1; i < lineasUsuario.size(); i++) {
            String[] datosU = lineasUsuario.get(i).split(",");
            if (datosU[6].charAt(0) == 'O') {
                for (String l : lineasOperadores) {
                    String[] datosO = l.split(",");
                    if (datosO[0].equals(datosU[0])) {
                        Operador operador = new Operador(datosU[0], datosU[1], Integer.parseInt(datosU[2]), datosU[3], datosU[4], datosU[5], datosU[6].charAt(0), Double.parseDouble(datosO[1]));
                        listaUsuarios.add(operador);
                    }
                }
            }
            if (datosU[6].charAt(0) == 'S') {
                for (String l : lineasClientes) {
                    String[] datosS = l.split(",");
                    if (datosS[0].equals(datosU[0])) {
                        Cliente cliente = new Cliente(datosU[0], datosU[1], Integer.parseInt(datosU[2]), datosU[3], datosU[4], datosU[5], datosU[6].charAt(0), datosS[1]);
                        listaUsuarios.add(cliente);
                    }
                }
            }
            if (datosU[6].charAt(0) == 'V') {
                for (String l : lineasClientes) {
                    String[] datosV = l.split(",");
                    if (datosV[0].equals(datosU[0])) {
                        ClienteVIP clienteVip = new ClienteVIP(datosU[0], datosU[1], Integer.parseInt(datosU[2]), datosU[3], datosU[4], datosU[5], datosU[6].charAt(0), datosV[1], datosV[2], Integer.parseInt(datosV[3]) + 1000);
                        listaUsuarios.add(clienteVip);
                    }
                }
            }

        }
    }
    
    /**Este metodo retorna linea de texto de tipo String
     * No recibe parametros
     * @return String Devuelve el user ingresado por el Usuario
     */

    //Metodos para iniciar Sesion
    public static String ingresoSesionUsuario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Usuario: ");
        String u = sc.nextLine().toLowerCase();
        return u;
    }

    public static String ingresoSesionContraseña() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Contraseña: ");
        String p = sc.nextLine().toLowerCase();
        return p;
    }

    public static boolean verificarUsuario(String u) { //
        for (Usuario usu : listaUsuarios) {
            if (u.equals(usu.getUser())) {
                return true;
            }
        }
        return false;
    }

    public static boolean verificarContraseña(String p) {
        for (Usuario usu : listaUsuarios) {
            if (p.equals(usu.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public static Usuario iniciarSesion() {
        System.out.println("+++++++++++++++++++++++++++++++++++\n");
        System.out.println("\n             BIENVENIDO AL SISTEMA                     \n");
        System.out.println("+++++++++++++++++++++++++++++++++++\n");

        String u = ingresoSesionUsuario();
        String p = ingresoSesionContraseña();

        while (verificarUsuario(u) == false || verificarContraseña(p) == false) {
            // Si el usuario ingresado no es correcto, entonces true -> 1
            // Si la contra ingresada no es correcta, entonces true --> 1
            System.out.println("Contraseña o Usuario incorrectos. Intente de nuevo.\n");
            u = ingresoSesionUsuario();
            p = ingresoSesionContraseña();
        }

        for (Usuario usu : listaUsuarios) {
            if (u.equals(usu.getUser())) {
                return usu;
            }

        }

//        char rol;
//        for (Usuario usu : listaUsuarios) {
//            if (u.equals(usu.getUser())) {
//                rol = usu.getRol();  
//           }
//        if ()
        return null;
    }

    //menu
    public static boolean mostrarMenu(Usuario usuario) {
        Scanner sc = new Scanner(System.in);

        if (usuario.getRol() == 'O') {
            Operador operador = (Operador) usuario;
            int opcion = mostrarMenuOperador(); //acciones del operador
            if (opcion == 1) {
                operador.consultarUsuario();
            } else if (opcion == 2) {
                operador.consultarReserva();
            } else if (opcion == 3) {
                return true;
            }

        } else {
            int opcion = mostrarMenuCliente(); //acciones de clientes
            Cliente cliente = (Cliente) usuario;
            if (opcion == 1) {

                //Paso 1
                Reserva reserva = cliente.hacerReserva(); // hace la reserva

                System.out.println("¿Desea Continuar? (S/N)"); //quiere continuar?
                String continuar = sc.nextLine().toLowerCase();
                while (!(continuar.equals("s") || continuar.equals("n"))) {
                    System.out.println("Opcion incorrecta.¿Estas seguro de pagar el vuelo (s/n)?. Recomendacion: Eliga una letra.");
                    continuar = sc.nextLine().toLowerCase();
                }

                if (continuar.equals("s")) {

                    //Paso 2
                    reserva = cliente.escogerAsientos(reserva);
                    System.out.println("¿Desea Continuar? (s/n)");
                    continuar = sc.nextLine().toLowerCase();
                    while (!(continuar.equals("s") || continuar.equals("n"))) {
                        System.out.println("Opcion incorrecta.¿Estas seguro de pagar el vuelo (s/n)?. Recomendacion: Eliga una letra.");
                        continuar = sc.nextLine().toLowerCase();
                    }

                    if (continuar.equals("s") && reserva != null) {

                        //Paso 3
                        cliente.ingresarDatosCliente();
                        System.out.println("");
                        System.out.println("Desea guardar los datos del pasajero y continuar con el pago (s/n)? ");
                        continuar = sc.nextLine().toLowerCase();
                        while (!continuar.equals("s") && !continuar.equals("n")) { //validacion
                            System.out.println("Opcion incorrecta. Desea guardar los datos del pasajero y continuar con el pago (s/n)? ");
                            continuar = sc.nextLine().toLowerCase();
                        }
                        if (continuar.equals("s")) {
                            System.out.println("Ha completado el paso 3");

                            //Paso 4
                            if (cliente instanceof ClienteVIP) {
                                ClienteVIP clientevip = (ClienteVIP) cliente;

                                String pago = clientevip.hacerPago(reserva, clientevip.getMillas()); //pago del cliente VIP
                                while (pago.equals("millas insuficientes")) { //Se repite si no tiene millas suficientes
                                    System.out.println("No posee millas suficientes. Intente con otro metodo de pago.");
                                    pago = clientevip.hacerPago(reserva, clientevip.getMillas());
                                }
                                System.out.println("¿Estas seguro de pagar el vuelo (s/n) ? "); //validacion si quiere continuar
                                String op = sc.nextLine().toLowerCase();
                                while (!(op.equals("s") || op.equals("n"))) {
                                    System.out.println("Opcion incorrecta.¿Estas seguro de pagar el vuelo (s/n)?. Recomendacion: Eliga una letra.");
                                    op = sc.nextLine().toLowerCase();
                                }
                                if (op.equals("s")) {
                                    System.out.println("Has comprado tu vuelo. El codigo de reserva es: " + reserva.getCodigoReserva());

                                    if (pago.equals("pago hecho en tarjeta")) {
                                        reserva.setPrecioSubtotal(reserva.getPrecioSubtotal() + (reserva.getPrecioSubtotal() * 0.1));//aumento del 10% por pago en tarjeta

                                        //escritura archivo reservas.txt
                                        String informacionida = (reserva.getCodigoReserva() + "," + String.valueOf(reserva.getVueloReservaL().get(0).getVuelo().getCodigoVuelo()) + "," + reserva.getCliente().nombres + "," + reserva.getFechaCompra() + "," + String.valueOf(reserva.getPrecioSubtotal()));
                                        manejoArchivos.ManejoArchivos.EscribirArchivo("reservas.txt", informacionida);
                                        String informacionret = (reserva.getCodigoReserva() + "," + String.valueOf(reserva.getVueloReservaL().get(1).getVuelo().getCodigoVuelo()) + "," + reserva.getCliente().nombres + "," + reserva.getFechaCompra() + "," + String.valueOf(reserva.getPrecioSubtotal()));
                                        manejoArchivos.ManejoArchivos.EscribirArchivo("reservas.txt", informacionret);
                                        listaReservas.add(reserva);
                                        //escritura archivo consultarReservas.txt
                                        manejoArchivos.ManejoArchivos.EscribirArchivo("consultarReserva.txt", reserva.getCliente().getNombres() + "," + reserva.getCliente().getCedula() + "," + reserva.getVueloReservaL().get(0).getVuelo().getCodigoVuelo() + "," + reserva.getVueloReservaL().get(0).getVuelo().getItinerario().getHoraSalida() + "," + reserva.getVueloReservaL().get(0).getVuelo().getItinerario().getHoraLlegada() + "," + reserva.getVueloReservaL().get(0).getVuelo().getAvion().getCodigoAvion() + "," + String.valueOf((int) (Math.random() * 20)));
                                        manejoArchivos.ManejoArchivos.EscribirArchivo("consultarReserva.txt", reserva.getCliente().getNombres() + "," + reserva.getCliente().getCedula() + "," + reserva.getVueloReservaL().get(1).getVuelo().getCodigoVuelo() + "," + reserva.getVueloReservaL().get(1).getVuelo().getItinerario().getHoraSalida() + "," + reserva.getVueloReservaL().get(1).getVuelo().getItinerario().getHoraLlegada() + "," + reserva.getVueloReservaL().get(1).getVuelo().getAvion().getCodigoAvion() + "," + String.valueOf((int) (Math.random() * 20)));
                                        
                                        //escritura archivo pagos.txt
                                        int num1 = (int) (Math.random() * 9);
                                        int num2 = (int) (Math.random() * 9);
                                        int num3 = (int) (Math.random() * 9);
                                        int num4 = (int) (Math.random() * 9);
                                        String idPago = String.valueOf(num1) + String.valueOf(num2) + String.valueOf(num3) + String.valueOf(num4);
                                        manejoArchivos.ManejoArchivos.EscribirArchivo("pagos.txt", idPago + "," + reserva.getCodigoReserva() + "," + String.format("%.2f", reserva.getPrecioSubtotal()) + ",TC");   
                                        
                                    } else if (pago.equals("pago hecho en millas")) {
                                        clientevip.setMillas(clientevip.getMillas() - reserva.getPrecioMillasTotal());
                                        reserva.setCliente(clientevip);

                                        //escritura archivo reservas.txt
                                        String informacionida = (reserva.getCodigoReserva() + "," + String.valueOf(reserva.getVueloReservaL().get(0).getVuelo().getCodigoVuelo()) + "," + reserva.getCliente().nombres + "," + reserva.getFechaCompra() + "," + String.valueOf(reserva.getPrecioSubtotal()));
                                        manejoArchivos.ManejoArchivos.EscribirArchivo("reservas.txt", informacionida);
                                        String informacionret = (reserva.getCodigoReserva() + "," + String.valueOf(reserva.getVueloReservaL().get(1).getVuelo().getCodigoVuelo()) + "," + reserva.getCliente().nombres + "," + reserva.getFechaCompra() + "," + String.valueOf(reserva.getPrecioSubtotal()));
                                        manejoArchivos.ManejoArchivos.EscribirArchivo("reservas.txt", informacionret);
                                        listaReservas.add(reserva);
                                        //escritura archivo consultarReservas.txt
                                        manejoArchivos.ManejoArchivos.EscribirArchivo("consultarReserva.txt", reserva.getCliente().getNombres() + "," + reserva.getCliente().getCedula() + "," + reserva.getVueloReservaL().get(0).getVuelo().getCodigoVuelo() + "," + reserva.getVueloReservaL().get(0).getVuelo().getItinerario().getHoraSalida() + "," + reserva.getVueloReservaL().get(0).getVuelo().getItinerario().getHoraLlegada() + "," + reserva.getVueloReservaL().get(0).getVuelo().getAvion().getCodigoAvion() + "," + String.valueOf((int) (Math.random() * 20)));
                                        manejoArchivos.ManejoArchivos.EscribirArchivo("consultarReserva.txt", reserva.getCliente().getNombres() + "," + reserva.getCliente().getCedula() + "," + reserva.getVueloReservaL().get(1).getVuelo().getCodigoVuelo() + "," + reserva.getVueloReservaL().get(1).getVuelo().getItinerario().getHoraSalida() + "," + reserva.getVueloReservaL().get(1).getVuelo().getItinerario().getHoraLlegada() + "," + reserva.getVueloReservaL().get(1).getVuelo().getAvion().getCodigoAvion() + "," + String.valueOf((int) (Math.random() * 20)));
                                        
                                        //escritura archivo pagos.txt
                                        int num1 = (int) (Math.random() * 9);
                                        int num2 = (int) (Math.random() * 9);
                                        int num3 = (int) (Math.random() * 9);
                                        int num4 = (int) (Math.random() * 9);
                                        String idPago = String.valueOf(num1) + String.valueOf(num2) + String.valueOf(num3) + String.valueOf(num4);
                                        manejoArchivos.ManejoArchivos.EscribirArchivo("pagos.txt", idPago + "," + reserva.getCodigoReserva() + "," + reserva.getPrecioMillasTotal() + ",M");
                                    }
                                    
                                }

                            } else {
                                cliente.hacerPago(reserva); //pago del cliente estandar
                                System.out.println("¿Estas seguro de pagar el vuelo (s/n) ? ");
                                String op = sc.nextLine().toLowerCase();
                                while (!(op.equals("s") || op.equals("n"))) {
                                    System.out.println("Opcion incorrecta.¿Estas seguro de pagar el vuelo (s/n)?. Recomendacion: Eliga una letra.");
                                    op = sc.nextLine().toLowerCase();
                                }
                                if (op.equals("s")) {
                                    System.out.println("Has comprado tu vuelo. El codigo de reserva es: " + reserva.getCodigoReserva());
                                    reserva.setPrecioSubtotal(reserva.getPrecioSubtotal() + (reserva.getPrecioSubtotal() * 0.1));//aumento del 10% por pago en tarjeta

                                    //escritura archivo reservas.txt
                                    String informacionida = (reserva.getCodigoReserva() + "," + String.valueOf(reserva.getVueloReservaL().get(0).getVuelo().getCodigoVuelo()) + "," + reserva.getCliente().nombres + "," + reserva.getFechaCompra() + "," + String.valueOf(reserva.getPrecioSubtotal()));
                                    manejoArchivos.ManejoArchivos.EscribirArchivo("reservas.txt", informacionida);
                                    String informacionret = (reserva.getCodigoReserva() + "," + String.valueOf(reserva.getVueloReservaL().get(1).getVuelo().getCodigoVuelo()) + "," + reserva.getCliente().nombres + "," + reserva.getFechaCompra() + "," + String.valueOf(reserva.getPrecioSubtotal()));
                                    manejoArchivos.ManejoArchivos.EscribirArchivo("reservas.txt", informacionret);
                                    listaReservas.add(reserva);
                                    //escritura archivo consultarReservas.txt
                                    manejoArchivos.ManejoArchivos.EscribirArchivo("consultarReserva.txt", reserva.getCliente().getNombres() + "," + reserva.getCliente().getCedula() + "," + reserva.getVueloReservaL().get(0).getVuelo().getCodigoVuelo() + "," + reserva.getVueloReservaL().get(0).getVuelo().getItinerario().getHoraSalida() + "," + reserva.getVueloReservaL().get(0).getVuelo().getItinerario().getHoraLlegada() + "," + reserva.getVueloReservaL().get(0).getVuelo().getAvion().getCodigoAvion() + "," + String.valueOf((int) (Math.random() * 20)));
                                    manejoArchivos.ManejoArchivos.EscribirArchivo("consultarReserva.txt", reserva.getCliente().getNombres() + "," + reserva.getCliente().getCedula() + "," + reserva.getVueloReservaL().get(1).getVuelo().getCodigoVuelo() + "," + reserva.getVueloReservaL().get(1).getVuelo().getItinerario().getHoraSalida() + "," + reserva.getVueloReservaL().get(1).getVuelo().getItinerario().getHoraLlegada() + "," + reserva.getVueloReservaL().get(1).getVuelo().getAvion().getCodigoAvion() + "," + String.valueOf((int) (Math.random() * 20)));
                                    
                                    //escritura archivo pagos.txt
                                    int num1 = (int) (Math.random() * 9);
                                    int num2 = (int) (Math.random() * 9);
                                    int num3 = (int) (Math.random() * 9);
                                    int num4 = (int) (Math.random() * 9);
                                    String idPago = String.valueOf(num1) + String.valueOf(num2) + String.valueOf(num3) + String.valueOf(num4);
                                    manejoArchivos.ManejoArchivos.EscribirArchivo("pagos.txt", idPago + "," + reserva.getCodigoReserva() + "," + String.format("%.2f", reserva.getPrecioSubtotal()) + ",TC");
                                }
                            }
                        }
                    }
                }

            } else if (opcion == 2) {
                cliente.consultarReserva();
            } else if (opcion == 3) {
                return true;
            }

        }

        return false;
    }

    public static int mostrarMenuCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Comprar tickets aereos.");
        System.out.println("2. Consultar Reservas.");
        System.out.println("3. Salir.");
        System.out.println("");
        System.out.println("Elija una opción:");
        int op = sc.nextInt();
        sc.nextLine();
        return op;
    }

    public static int mostrarMenuOperador() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Consultar Usuarios.");
        System.out.println("2. Consultar Reservas.");
        System.out.println("3. Salir.");
        System.out.println("");
        System.out.println("Elija una opción:");
        int op = sc.nextInt();
        sc.nextLine();
        return op;
    }

}
