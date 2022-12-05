package com.mycompany.proyecto1p_rosario_garcia_guerrero;

import java.util.ArrayList;
import java.util.Scanner;

public class ClienteVIP extends Cliente {

    private String tipoVIP;
    protected int millas;

    /**
     * Constructor que retorna un objeto de tipo ClienteVIP
     * 
     * @param cedula atributo heredado de la clase Cliente
     * @param nombres atributo heredado de la clase Cliente
     * @param edad atributo heredado de la clase Cliente
     * @param mail atributo heredado de la clase Cliente
     * @param user atributo heredado de la clase Cliente
     * @param password atributo heredado de la clase Cliente
     * @param rol atributo heredado de la clase Cliente
     * @param numTarjeta atributo heredado de la clase Cliente
     * @param tipoVIP atributo propio de la clase ClienteVIP
     * @param millas atributo propio de la clase ClienteVIP
     */
    
    public ClienteVIP(String cedula, String nombres, int edad, String mail, String user, String password, char rol, String numTarjeta, String tipoVIP, int millas) {
        super(cedula, nombres, edad, mail, user, password, rol, numTarjeta);
        this.tipoVIP = tipoVIP;
        this.millas = millas;
    }


    /**
     * ESte metodo retorna la linea de texto en formato String
     * 
     * @param reserva Objeto requerido para devolver String
     * @param millasCliente numero requerido para devolver String
     * @return String devuelve informacion acerca del pago
     */
    

    public String hacerPago(Reserva reserva, int millasCliente) {
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
        if (this.getTipoVIP().equals("GOLDEN PASS")) {
            System.out.println("Descuento: 20% (cliente vip GOLDEN PASS)");
            subtotal -= (subtotal * 0.2);
        }
        if (this.getTipoVIP().equals("PLATINUM PASS")) {
            System.out.println("Descuento: 30% (cliente vip GOLDEN PASS)");
            subtotal -= (subtotal * 0.3);
        }

        double iva = subtotal * 0.12;
        System.out.println(String.format("IVA: %.2f", iva));
        double total = subtotal + iva;
        System.out.println(String.format("TOTAL A PAGAR: %.2f", total));

        System.out.println("");
        System.out.println("Forma de Pago: ");
        System.out.println("1. Tarjeta de Credito \n2. Millas");
        System.out.println("");
        System.out.println("Elije tu forma de pago: ");
        String fp = sc.nextLine();

        if (fp.equals("1")) {
            System.out.println("Ingrese su tarjeta de credito: ");
            String t = sc.nextLine();
            while (!this.getNumTarjeta().equals(t)) {
                System.out.println("Tarjeta Incorrecta.");
                System.out.println("Ingrese su tarjeta de credito: ");
                t = sc.nextLine();
            }
            return "pago hecho en tarjeta";
        } else if (fp.equals("2")) {
            if (millasCliente >= reserva.getPrecioMillasTotal()) {
                return "pago hecho en milllas";
            } else {
                System.out.println("No posee millas Suficientes. Intente de nuevo.");
            }
        }

        return "millas insuficientes";
    }

    public String getTipoVIP() {
        return tipoVIP;
    }

    public void setTipoVIP(String tipoVIP) {
        this.tipoVIP = tipoVIP;
    }

    public int getMillas() {
        return millas;
    }

    public void setMillas(int millas) {
        this.millas = millas;
    }

    @Override
    public String toString() {
        return this.nombres + ",CLIENTE VIP " + this.tipoVIP + "," + this.cedula;
    }

}
