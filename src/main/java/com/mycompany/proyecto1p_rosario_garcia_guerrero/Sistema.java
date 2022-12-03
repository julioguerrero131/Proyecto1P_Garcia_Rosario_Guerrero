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
    public static void main(String[] args) {
        // TODO code application logic here
        cargarAsientos("asientos.txt");
        cargarAviones("aviones.txt");
        cargarItinerarios("itinerarios.txt");
        cargarVuelos("vuelos.txt");
        cargarUsuarios("usuarios.txt", "clientes.txt", "operadores.txt");

        Usuario usuario = iniciarSesion();
        mostrarMenu(usuario);

    }

    //Comienzo carga de Archivos
    public static void cargarAsientos(String archivoAsientos) {
        ArrayList<String> lineasAsientos = ManejoArchivos.LeeFichero(archivoAsientos);

        for (int i = 1; i < lineasAsientos.size(); i++) {
            String[] datos = lineasAsientos.get(i).split(",");
            Asiento asi = new Asiento(datos[0], datos[1], Disponibilidad.valueOf(datos[2]));
            listaAsientos.add(asi);
        }
    }

    public static void cargarAviones(String archivoAviones) {
        ArrayList<String> lineasAvion = ManejoArchivos.LeeFichero(archivoAviones);

        for (int i = 1; i < lineasAvion.size(); i++) {
            String[] datos = lineasAvion.get(i).split(",");
            Avion avi = new Avion(datos[0], Integer.parseInt(datos[1]));
            listaAviones.add(avi);
        }
    }

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
                        ClienteVIP clienteVip = new ClienteVIP(datosU[0], datosU[1], Integer.parseInt(datosU[2]), datosU[3], datosU[4], datosU[5], datosU[6].charAt(0), datosV[1], datosV[2], Integer.parseInt(datosV[3]));
                        listaUsuarios.add(clienteVip);
                    }
                }
            }

        }
    }

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
    public static void mostrarMenu(Usuario usuario) {
        Scanner sc = new Scanner(System.in);
        if (usuario.getRol() == 'O') {

            int opcion = mostrarMenuOperador(); //acciones del operador
            switch (opcion) {
                case 1:
                case 2:
                case 3:

            }

        } else {

            int opcion = mostrarMenuCliente(); //acciones de clientes
            switch (opcion) {
                case 1:

                    ArrayList<VueloReserva> vuelosReservaL = new ArrayList();
                    Cliente cliente = (Cliente) usuario;
                    Reserva reserva = new Reserva(cliente, 0, vuelosReservaL);
                    
                    String continuar = "S";
                    while (!(continuar.equals("N"))) {
                        int opcion1 = Itinerario.elegirOrigen(origenes);
                        int opcion2 = Itinerario.elegirDestino(destinos);
                        String origen = origenes.get(opcion1 - 1);
                        String destino = destinos.get(opcion2 - 1);

                        ArrayList<Vuelo> vuelosIdaL = new ArrayList();
                        ArrayList<Vuelo> vuelosRetornoL = new ArrayList();
                        for (Vuelo v : listaVuelos) {
                            if (origen.equals(v.getItinerario().getOrigen()) && !vuelosIdaL.contains(v)) {
                                vuelosIdaL.add(v);
                            }
                        }
                        for (Vuelo v : listaVuelos) {
                            if (destino.equals(v.getItinerario().getOrigen()) && !vuelosRetornoL.contains(v)) {
                                vuelosRetornoL.add(v);
                            }
                        }

                        System.out.println("Fecha Salida: " + vuelosIdaL.get(0).getFechaSalida());
                        System.out.println("Fecha Llegada: " + vuelosRetornoL.get(0).getFechaLlegada());

                        System.out.println("");
                        System.out.println("******************Paso 1*******************"); //PASO 1
                        System.out.println("*****************************************");
                        System.out.println("");

                        System.out.println("----------------------Vuelos Disponibles IDA------------------------");

                        for (int i = 0; i < vuelosIdaL.size(); i++) { //VUELOS IDA
                            System.out.println("----------------" + (i + 1) + "-------------------");
                            System.out.println(vuelosIdaL.get(i));
                        }

                        System.out.println("Eliga el vuelo de ida: ");
                        int opVueloIda = sc.nextInt();
                        sc.nextLine();

                        while (!(opVueloIda > 0 && opVueloIda <= vuelosIdaL.size())) { //valida la opcion escogida
                            System.out.println("Elija una opcion existente:");
                            opVueloIda = sc.nextInt();
                            sc.nextLine();
                        }

                        Vuelo vueloIda = vuelosIdaL.get(opVueloIda - 1); //obtener el vuelo de ida

                        System.out.println("");
                        System.out.println("TARIFAS:");
                        System.out.println("");
                        System.out.println("A.Economy (+0) \nB. Premium economy (+60)\nC. Premium (+90)");
                        System.out.println("");
                        System.out.println("Elije la tarifa de vuelo: ");
                        String opTarifaIda = sc.nextLine().toUpperCase();

                        while (!(opTarifaIda.equals("A") || opTarifaIda.equals("B") || opTarifaIda.equals("C"))) { //valida la opcion escogida
                            System.out.println("Elija una opcion existente:");
                            opTarifaIda = sc.nextLine().toUpperCase();
                        }

                        double precioVueloIda = 0;

                        TipoTarifa tipoTarifaIda = TipoTarifa.UNDEFINED; //obtener la tarifa de ida

                        switch (opTarifaIda) {
                            case "A":
                                precioVueloIda = vueloIda.getPrecio();
                                tipoTarifaIda = TipoTarifa.ECONOMY;
                                break;
                            case "B":
                                precioVueloIda = vueloIda.getPrecio() + 60;
                                tipoTarifaIda = TipoTarifa.PREMIUMECONOMY;
                                break;
                            case "C":
                                precioVueloIda = vueloIda.getPrecio() + 90;
                                tipoTarifaIda = TipoTarifa.PREMIUMBUSINESS;
                                break;
                            default:
                                break;
                        }

                        System.out.println("----------------------Vuelos Disponibles RETORNO------------------------");

                        for (int i = 0; i < vuelosRetornoL.size(); i++) { //VUELOS RETORNO
                            System.out.println("----------------" + (i + 1) + "-------------------");
                            System.out.println(vuelosRetornoL.get(i));
                        }

                        System.out.println("Eliga el vuelo de retorno: ");
                        int opVueloRetorno = sc.nextInt();
                        sc.nextLine();

                        while (!(opVueloRetorno > 0 && opVueloRetorno <= vuelosRetornoL.size())) { //valida la opcion escogida
                            System.out.println("Elija una opcion existente:");
                            opVueloRetorno = sc.nextInt();
                            sc.nextLine();
                        }
                        Vuelo vueloRetorno = vuelosRetornoL.get(opVueloRetorno - 1);

                        System.out.println("");
                        System.out.println("TARIFAS:");
                        System.out.println("");
                        System.out.println("A.Economy (+0) \nB. Premium economy (+60)\nC. Premium (+90)");
                        System.out.println("");
                        System.out.println("Elije la tarifa de vuelo: ");
                        String opTarifaRetorno = sc.nextLine().toUpperCase();

                        while (!(opTarifaRetorno.equals("A") || opTarifaRetorno.equals("B") || opTarifaRetorno.equals("C"))) { //valida la opcion escogida
                            System.out.println("Elija una opcion existente:");
                            opTarifaRetorno = sc.nextLine();
                        }

                        TipoTarifa tipoTarifaRetorno = TipoTarifa.UNDEFINED;
                        double precioVueloRetorno = 0;

                        switch (opTarifaRetorno) {
                            case "A":
                                precioVueloRetorno = vueloRetorno.getPrecio();
                                tipoTarifaRetorno = TipoTarifa.ECONOMY;
                                break;
                            case "B":
                                precioVueloRetorno = vueloRetorno.getPrecio() + 60;
                                tipoTarifaRetorno = TipoTarifa.PREMIUMECONOMY;
                                break;
                            case "C":
                                precioVueloRetorno = vueloRetorno.getPrecio() + 90;
                                tipoTarifaRetorno = TipoTarifa.PREMIUMBUSINESS;
                                break;
                            default:
                                break;
                        }

                        System.out.println("////////////////////SUBTOTAL/////////////////////////");
                        System.out.println("El subtotal de tu vuelo es: " + (precioVueloIda + precioVueloRetorno));
                        System.out.println("¿Desea Continuar? (S/N)");
                        continuar = sc.nextLine().toUpperCase();

                        VueloReserva vueloRI = new VueloReserva(vueloIda, TipoVuelo.IDA, null, tipoTarifaIda); //VueloReserva de ida ************************************
                        reserva.getVueloReservaL().add(vueloRI);
                        VueloReserva vueloRT = new VueloReserva(vueloRetorno, TipoVuelo.VUELTA, null, tipoTarifaRetorno); //VueloReserva de retorno ************************************
                        reserva.getVueloReservaL().add(vueloRT);
                        reserva.setPrecioSubtotal( reserva.getPrecioSubtotal() + precioVueloIda + precioVueloRetorno );
                            
                        }
                    }
                    System.out.println("");
                    System.out.println("******************Paso 2*******************"); //PASO 2**************************************************
                    System.out.println("*****************************************");
                    System.out.println("");

                    System.out.println("-----------Asientos------------");
                    System.out.println("");

                    System.out.println("");
                    System.out.println("******************Paso 3*******************"); //PASO 3
                    System.out.println("*****************************************");
                    System.out.println("");

                    String continuar2 = "N";
                    while (continuar2.equals("N")) {
                        System.out.println("-------------------------DATOS PASAJERO---------------------------");
                        String[] nombreApellido = usuario.getNombres().split(" ");
                        System.out.println("Nombres: " + nombreApellido[0]);
                        System.out.println("Apellidos: " + nombreApellido[1]);
                        System.out.println("Correo:");
                        String correo = sc.nextLine();
                        System.out.println("Genero(1. Masculino - 2. Femenino):");
                        String genero = sc.nextLine();
                        while (!genero.equals("1") && !genero.equals("2")) { //validacion
                            System.out.println("Genero(1. Masculino - 2. Femenino). Ingrese el numero:");
                            genero = sc.nextLine();
                        }
                        System.out.println("Nacionalidad:");
                        String nacionalidad = sc.nextLine();
                        System.out.println("Tipo de Documento(1. Cedula - 2. Pasaporte):");
                        String tipoDocumento = sc.nextLine();
                        while (!tipoDocumento.equals("1") && !tipoDocumento.equals("2")) { //validacion
                            System.out.println("Tipo de Documento (1. Masculino - 2. Femenino). Ingrese el numero:");
                            genero = sc.nextLine();
                        }
                        sc.nextLine();
                        System.out.println("Numero de Documento:");
                        String numDocumento = sc.nextLine();
                        while (!(numDocumento.length() == 10) || numDocumento == null || !numDocumento.matches("[0-9]+")) { //validacion
                            System.out.println("Tipo de Documento (1. Masculino - 2. Femenino). Ingrese el numero:");
                            genero = sc.nextLine();
                        }
                        System.out.println("");

                        System.out.println("Desea guardar los datos del pasajero y continuar con el pago (S/N)? ");
                        continuar2 = sc.nextLine().toUpperCase();
                        while (!continuar2.equals("S") && !continuar2.equals("N")) { //validacion
                            System.out.println("Desea guardar los datos del pasajero y continuar con el pago (S/N)? ");
                            continuar2 = sc.nextLine().toUpperCase();
                        }

                    }
                    System.out.println("Ha completado el paso 3");

                    System.out.println("");
                    System.out.println("******************Paso 4*******************"); //PASO 4
                    System.out.println("*****************************************");
                    System.out.println("");
                    System.out.println("--------------------------PAGO--------------------------");
                    System.out.println("");
                    System.out.println("Descripción:");
                    System.out.println("");

                    System.out.println("Subtotal: " +  );
                    
                    }

                case 2:
                case 3:

            }
        }
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
