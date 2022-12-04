package com.mycompany.proyecto1p_rosario_garcia_guerrero;

import java.util.ArrayList;
import java.util.Scanner;

public class ClienteVIP extends Cliente {

    private String tipoVIP;
    protected int millas;

    public ClienteVIP(String cedula, String nombres, int edad, String mail, String user, String password, char rol, String numTarjeta, String tipoVIP, int millas) {
        super(cedula, nombres, edad, mail, user, password, rol, numTarjeta);
        this.tipoVIP = tipoVIP;
        this.millas = millas;
    }

    public void hacerPago(Reserva reserva, int millasCliente) {
        Scanner sc = new Scanner(System.in);

        System.out.println("");
        System.out.println("******************Paso 4*******************"); //PASO 4
        System.out.println("*****************************************");
        System.out.println("");

        String op = "n";
        while (op.equals("n")) {
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
            System.out.println("IVA: " + iva);
            double total = subtotal + iva;
            System.out.println("TOTAL A PAGAR: " + total);

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
                System.out.println("¿Estas seguro de pagar el vuelo (s/n) ? ");
                op = sc.nextLine().toLowerCase();
                while (!(op.equals("s") || op.equals("n"))) {
                    System.out.println("Opcion incorrecta.¿Estas seguro de pagar el vuelo (s/n)?. Recomendacion: Eliga una letra.");
                    op = sc.nextLine().toLowerCase();
                }
                if (op.equals("s")) {
                    System.out.println("Has comprado tu vuelo. El codigo de reserva es: " + reserva.getCodigoReserva());
                    reserva.setPrecioSubtotal(reserva.getPrecioSubtotal() + (reserva.getPrecioSubtotal() * 0.1));//aumento del 10% por pago en tarjeta
                }
            } else if (fp.equals("2")) {
                if (millasCliente >= reserva.getPrecioMillasTotal()) {
                    this.setMillas(millasCliente - reserva.getPrecioMillasTotal());
                    System.out.println("¿Estas seguro de pagar el vuelo (s/n) ? ");
                    op = sc.nextLine().toLowerCase();
                    while (!(op.equals("s") || op.equals("n"))) {
                        System.out.println("Opcion incorrecta.¿Estas seguro de pagar el vuelo (s/n)?. Recomendacion: Eliga una letra.");
                        op = sc.nextLine().toLowerCase();
                    }
                    if (op.equals("s")) {
                        System.out.println("Has comprado tu vuelo. El codigo de reserva es: " + reserva.getCodigoReserva());
                        reserva.setPrecioSubtotal(reserva.getPrecioSubtotal() + (reserva.getPrecioSubtotal() * 0.1));//aumento del 10% por pago en tarjeta
                    }
                } else {
                    op = "n";
                    System.out.println("No posee millas Suficientes. Intente de nuevo.");
                }
            }
        }
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

    

}
