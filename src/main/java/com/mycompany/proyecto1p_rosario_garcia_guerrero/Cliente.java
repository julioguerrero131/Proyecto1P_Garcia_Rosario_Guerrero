package com.mycompany.proyecto1p_rosario_garcia_guerrero;

import java.util.ArrayList;
import java.util.Scanner;
import manejoArchivos.ManejoArchivos;

public class Cliente extends Usuario {

    protected String numTarjeta;

    public Cliente(String cedula, String nombres, int edad, String mail, String user, String password, char rol, String numTarjeta) {
        super(cedula, nombres, edad, mail, user, password, rol);
        this.numTarjeta = numTarjeta;
    }

    @Override
    public void consultarReserva() {
        for (Reserva reserva1 : Sistema.listaReservas) {
            if (reserva1.getCliente().getCedula().equals(this.cedula)) {
                System.out.println(reserva1.toString());
            }
        }
    }

    public Reserva hacerReserva() {
        ArrayList<VueloReserva> vuelosReservaL = new ArrayList();
        Reserva reserva = new Reserva(this, 0, 0, vuelosReservaL);
        Scanner sc = new Scanner(System.in);

        int opcion1 = Itinerario.elegirOrigen(Sistema.origenes);
        int opcion2 = Itinerario.elegirDestino(Sistema.destinos);
        String origen = Sistema.origenes.get(opcion1 - 1);
        String destino = Sistema.destinos.get(opcion2 - 1);

        ArrayList<Vuelo> vuelosIdaL = new ArrayList();
        ArrayList<Vuelo> vuelosRetornoL = new ArrayList();
        for (Vuelo v : Sistema.listaVuelos) {
            if (origen.equals(v.getItinerario().getOrigen()) && !vuelosIdaL.contains(v)) {
                vuelosIdaL.add(v);
            }
        }
        for (Vuelo v : Sistema.listaVuelos) {
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
            opTarifaRetorno = sc.nextLine().toUpperCase();
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

        VueloReserva vueloRI = new VueloReserva(vueloIda, TipoVuelo.IDA, null, tipoTarifaIda); //VueloReserva de ida 
        reserva.getVueloReservaL().add(vueloRI);
        VueloReserva vueloRT = new VueloReserva(vueloRetorno, TipoVuelo.VUELTA, null, tipoTarifaRetorno); //VueloReserva de retorno 
        reserva.getVueloReservaL().add(vueloRT);
        reserva.setPrecioSubtotal(reserva.getPrecioSubtotal() + precioVueloIda + precioVueloRetorno);
        reserva.setPrecioMillasTotal(reserva.getPrecioMillasTotal() + vueloRI.getVuelo().getPrecioMillas() + vueloRT.getVuelo().getPrecioMillas());
        System.out.println("Reserva Creada con Exito.");

        return reserva;
    }

    public Reserva escogerAsientos(Reserva reserva) {
        System.out.println("");
        System.out.println("******************Paso 2*******************"); //PASO 2**************************************************
        System.out.println("*****************************************");
        System.out.println("");
        System.out.println("-----------Asientos------------");
        System.out.println("");

        String codigoAvIda = reserva.getVueloReservaL().get(0).getVuelo().getAvion().getCodigoAvion();
        Asiento as1 = Vuelo.asignarAsiento(codigoAvIda);
        String codigoAvRetorno = reserva.getVueloReservaL().get(1).getVuelo().getAvion().getCodigoAvion();
        Asiento as2 = Vuelo.asignarAsiento(codigoAvRetorno);

        if (as1 == null || as2 == null) {
            System.out.println("No se encontraron asientos disponibles. Reserve nuevamente.");
            return null;
        }
        System.out.println("Para tu vuelo de ida " + reserva.getVueloReservaL().get(0).getVuelo().getCodigoVuelo() + " se te ha asignado el asiento " + as1.getNumAsiento());
        System.out.println("Para tu vuelo de retorno " + reserva.getVueloReservaL().get(1).getVuelo().getCodigoVuelo() + " se te ha asignado el asiento " + as2.getNumAsiento());
        reserva.getVueloReservaL().get(0).setAsiento(as1);
        reserva.getVueloReservaL().get(1).setAsiento(as2);
        return reserva;
    }

    public void hacerPago(Reserva reserva) {
        Scanner sc = new Scanner(System.in);

        System.out.println("");
        System.out.println("******************Paso 4*******************"); //PASO 4
        System.out.println("*****************************************");
        System.out.println("");

        System.out.println("--------------------------PAGO--------------------------");
        System.out.println("");
        System.out.println("Descripción:");
        System.out.println("");
        double subtotal = reserva.getPrecioSubtotal();
        System.out.println("Subtotal: " + subtotal);

        double iva = subtotal * 0.12;
        System.out.println(String.format("IVA: %.2f", iva));
        double total = subtotal + iva;
        System.out.println(String.format("TOTAL A PAGAR: %.2f", total));

        System.out.println("");
        System.out.println("Forma de Pago: ");
        System.out.println("1. Tarjeta de Credito \n2. Millas");

        String fp = sc.nextLine();
        while (!fp.equals("1")) { //validacion solo paga con tarjeta
            System.out.println("Elija otra forma de pago: ");
            System.out.println("1. Tarjeta de Credito \n2. Millas");
            fp = sc.nextLine();
        }
        System.out.println("Ingrese su tarjeta de credito: "); //validacion ingresa el cliente su tarjeta correctamente
        String t = sc.nextLine();
        while (!this.getNumTarjeta().equals(t)) {
            System.out.println("Tarjeta Incorrecta. Intente nuevamente.");
            System.out.println("Ingrese su tarjeta de credito: ");
            t = sc.nextLine();
        }
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    @Override
    public String toString() {
        return this.nombres + ",CLIENTE ESTANDAR," + this.cedula;
    }

}
