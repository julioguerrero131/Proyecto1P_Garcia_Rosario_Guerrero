/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1p_rosario_garcia_guerrero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author Cliente Intel
 */
public class Vuelo extends Itinerario {

    private ArrayList<String> codigo = new ArrayList<>();
    private ArrayList<String> codigoAvion = new ArrayList<>();
    private ArrayList<String> lista_fechaSalida = new ArrayList<>();
    private ArrayList<String> lista_fechaLlegada = new ArrayList<>();
    private ArrayList<Double> precios = new ArrayList<>();
    private ArrayList<Double> precioMillas = new ArrayList<>();

    private ArrayList<String> lista_codigoitinerario = new ArrayList<>();
    private ArrayList<String> lista_codigoitinerario_retorno = new ArrayList<>();
    
    private ArrayList<String> codigo_retorno = new ArrayList<>();
    private ArrayList<String> codigoAvion_retorno = new ArrayList<>();
    private ArrayList<String> lista_fechaSalida_retorno = new ArrayList<>();
    private ArrayList<String> lista_fechaLlegada_retorno = new ArrayList<>();
    private ArrayList<Double> precios_retorno = new ArrayList<>();
    private ArrayList<Double> precioMillas_retorno = new ArrayList<>();
    

    public Vuelo(ArrayList<String> vuelo, ArrayList<String> itinerario) {
        super(itinerario);
        for (int i = 1; i <= vuelo.size() - 1; i++) {
            String[] lis = vuelo.get(i).split(",");
            codigo.add(lis[0]);
            codigoAvion.add(lis[1]);
        }

        System.out.println("-----ORIGEN-----");
        for (int x = 1; x <= lista_ori.size(); x++) {
            System.out.println(x + "." + " " + lista_ori.get(x - 1));
        }
        System.out.println("Elige punto de partida: ");
        int partida = sc.nextInt();
        sc.nextLine();

        System.out.println("-----DESTINO-----");
        for (int x = 1; x <= listades.size(); x++) {
            System.out.println(x + "." + " " + listades.get(x - 1));
        }

        System.out.println("Elige punto de destino: ");
        int destino = sc.nextInt();
        sc.nextLine();

        if (partida == 1 && destino == 1) {
            for (int i = 1; i <= itinerario.size() - 3; i++) {
                String[] lista_iti_verificacion = itinerario.get(i).split(",");

                for (int x = 0; x < lista_iti_verificacion.length; x++) {
                    if (lista_ori.get(partida - 1).equals(lista_iti_verificacion[x])) {
                        lista_codigoitinerario.add(lista_iti_verificacion[0]);
                    }
                }

            }
            for (int i = 1; i <= vuelo.size() - 1; i++) {
                String[] lista_vuelo = vuelo.get(i).split(",");
                for (int x = 0; x < lista_codigoitinerario.size(); x++) {
                    if (lista_codigoitinerario.get(x).equals(lista_vuelo[4])) {
                        codigo.add(lista_vuelo[0]);
                        codigoAvion.add(lista_vuelo[1]);
                        lista_fechaSalida.add(lista_vuelo[2]);
                        lista_fechaLlegada.add(lista_vuelo[3]);
                        precios.add(Double.parseDouble(lista_vuelo[5]));                     
                        precioMillas.add(Double.parseDouble(lista_vuelo[6]));                    
                    }
                        
                }
                
            }
            System.out.println("Fecha de salida: " + lista_fechaSalida.get(0));
            System.out.println("Fecha de retorno: " + lista_fechaSalida.get(0)); 
                  
            
        

        System.out.println(" ");
        System.out.println("*********************************PASO 1********************************");
        System.out.println(" ");

        System.out.println("-------------------------------VUELOS DISPONIBLES IDA---------------------");

        System.out.println(" ");

        for (int i = 1; i <= vuelo.size() - 1; i++) { //
            String[] lista_vuelo = vuelo.get(i).split(",");
            for (int x = 0; x < lista_codigoitinerario.size(); x++) {
                if (lista_codigoitinerario.get(x).equals(lista_vuelo[4])) {
                    System.out.println("----------------------------------------" + (x + 1) + "---------------------");
                    System.out.println("Codigo: " + codigo.get(i - 1));
                    System.out.println("Hora Salida: " + horaSalida.get(i - 1));
                    System.out.println("Hora Llegada: " + horaLlegada.get(i - 1));
                    System.out.println("Duracion: " + duracion.get(i - 1));
                    System.out.println("Avion: " + codigoAvion.get(i - 1));
                    System.out.println("Precio: " + precios.get(i - 1));
                    System.out.println("Costo Millas: " + precioMillas.get(i-1));
                }
            }
        }
        
        System.out.println("Elije el vuelo de ida: ");
        int ida= sc.nextInt();
        sc.nextLine();
        System.out.println("  ");
        System.out.println("TARIFAS: ");
        System.out.println(" ");
        System.out.println("A. Economy (+0) ");
        System.out.println("B. Premium Economy  (+60)");
        System.out.println("C. Premium Business (+90)");
        System.out.println("  ");
        System.out.println("Elije la tarifa para tu vuelo: ");
        String tipo_tarifa= sc.nextLine().toUpperCase();
        
        
        for (int i = 4; i <= itinerario.size() - 1; i++) {
            String[] lista_iti_retorno= itinerario.get(i).split(",");
            for (int x = 0; x < lista_iti_retorno.length; x++) {
                if (lista_ori.get(partida - 1).equals(lista_iti_retorno[x])) {
                    lista_codigoitinerario_retorno.add(lista_iti_retorno[0]);
                              
                }
            }
        }
        for (int i = 4; i <= vuelo.size() - 1; i++) {
          String[] lista_vuelo_retorno= vuelo.get(i).split(",");   
          for(int x=0; x<lista_codigoitinerario_retorno.size();x++){
          if (lista_codigoitinerario_retorno.get(x).equals(lista_vuelo_retorno[4])) {
                    codigo_retorno.add(lista_vuelo_retorno[0]);
                    codigoAvion_retorno.add(lista_vuelo_retorno[1]);
                    lista_fechaSalida_retorno.add(lista_vuelo_retorno[2]);
                    lista_fechaLlegada_retorno.add(lista_vuelo_retorno[3]);
                    precios_retorno.add(Double.parseDouble(lista_vuelo_retorno[5]));                     
                    precioMillas_retorno.add(Double.parseDouble(lista_vuelo_retorno[6]));              
          }              
          }

        }
        
        System.out.println(" ");
        
        System.out.println("-------------------------------VUELOS DISPONIBLES RETORNO---------------------");

        System.out.println(" ");
        
        
        for (int i = 4; i <= vuelo.size()-1; i++) {
            
          String[] lista_vuelo_retorno = vuelo.get(i).split(","); 
                  
          for (int x = 0; x <lista_codigoitinerario_retorno.size(); x++) {
             if (lista_codigoitinerario_retorno.get(x).equals(lista_vuelo_retorno[4])) {
                    System.out.println("----------------------------------------" + (x + 1) + "---------------------");
                    System.out.println("Codigo: " + codigo_retorno.get(x));
                    System.out.println("Hora Salida: " + horaSalida.get(3));
                    System.out.println("Hora Llegada: " + horaLlegada.get(4));
                    System.out.println("Duracion: " + duracion.get(x));
                    System.out.println("Avion: " + codigoAvion_retorno.get(x));
                    System.out.println("Precio: " + precios_retorno.get(x));
                    System.out.println("Costo Millas: " + precioMillas_retorno.get(x));                 
             } 
          }
        }
        System.out.println("Elije el vuelo de retorno: ");
        int retorno= sc.nextInt();
        sc.nextLine();
        System.out.println("  ");
        System.out.println("TARIFAS: ");
        System.out.println(" ");
        System.out.println("A. Economy (+0) ");
        System.out.println("B. Premium Economy  (+60)");
        System.out.println("C. Premium Business (+90)");
        System.out.println("  ");
        System.out.println("Elije la tarifa para tu vuelo: ");
        String tipo_tarifa_retorno= sc.nextLine().toUpperCase();
        
       
       if( tipo_tarifa.equals("A")){
           precios.get(ida-1);
       }else if(tipo_tarifa.equals("B")){
            Premium_Economy(ida);
       }else if(tipo_tarifa.equals("C")){
           Premium_Business(ida);
       }
       
      
       if( tipo_tarifa_retorno.equals("A") ){
           precios_retorno.get(retorno-1);
       }else if(tipo_tarifa_retorno.equals("B")){
           Premium_Economy_retorno(retorno);
       }else if(tipo_tarifa_retorno.equals("C")){
           Premium_Business_retorno(retorno);
       }       
        
       System.out.println("-----------------SUBTOTAL------------- ");
       System.out.println("El subtotal de tu vuelo es: " + (precios.get(ida-1)+ precios_retorno.get(retorno-1)));
       //nombre variable= precioMillas.get(ida-1) + precioMillas_retorno(retorno-1);
       System.out.println(precios.get(ida-1));
       System.out.println(precios_retorno.get(retorno-1));
        
        
        
        
        
        
        
    } else if (partida == 2 && destino == 2) {
            for (int i = 4; i <= itinerario.size() - 1; i++) {
            String[] lista_iti_verificacion = itinerario.get(i).split(",");

            for (int x = 0; x < lista_iti_verificacion.length; x++) {
                if (lista_ori.get(partida - 1).equals(lista_iti_verificacion[x])) {
                    lista_codigoitinerario.add(lista_iti_verificacion[0]);

                }
            }
        }
        for (int i = 1; i <= vuelo.size() - 1; i++) {
            String[] lista_vuelo = vuelo.get(i).split(",");
            if (lista_codigoitinerario.get(0).equals(lista_vuelo[4])) {
                System.out.println("Fecha de salida: " + lista_vuelo[2]);
                System.out.println("Fecha de retorno: " + lista_vuelo[3]);
                codigo.add(lista_vuelo[0]);
                codigoAvion.add(lista_vuelo[1]);
                lista_fechaSalida.add(lista_vuelo[2]);
                lista_fechaLlegada.add(lista_vuelo[3]);
//                    precios.add(Double.parseDouble(lista_vuelo[4]));
                precioMillas.add(Double.parseDouble(lista_vuelo[5]));
            }
        
        }
    }
    }
   public double Premium_Economy(int i){
       precios.set(i-1, (precios.get(i-1)-60));
       return precios.get(i-1);
   } 
   public double Premium_Business(int i){
       precios.set(i-1, (precios.get(i-1)-90));
       return precios.get(i-1);
   }
   public double Premium_Economy_retorno(int i){
       precios_retorno.set(i-1, (precios_retorno.get(i-1)-60));
       return precios_retorno.get(i-1);
   }
   
   public double Premium_Business_retorno(int i){
       precios_retorno.set(i-1, (precios_retorno.get(i-1)-90));
       return precios_retorno.get(i-1);
   }

    public ArrayList<String> getCodigo() {
        return codigo;
    }

    public void setCodigo(ArrayList<String> codigo) {
        this.codigo = codigo;
    }

    public ArrayList<String> getCodigoAvion() {
        return codigoAvion;
    }

    public void setCodigoAvion(ArrayList<String> codigoAvion) {
        this.codigoAvion = codigoAvion;
    }

    public ArrayList<String> getLista_fechaSalida() {
        return lista_fechaSalida;
    }

    public void setLista_fechaSalida(ArrayList<String> lista_fechaSalida) {
        this.lista_fechaSalida = lista_fechaSalida;
    }

    public ArrayList<String> getLista_fechaLlegada() {
        return lista_fechaLlegada;
    }

    public void setLista_fechaLlegada(ArrayList<String> lista_fechaLlegada) {
        this.lista_fechaLlegada = lista_fechaLlegada;
    }

    public ArrayList<Double> getPrecios() {
        return precios;
    }

    public void setPrecios(ArrayList<Double> precios) {
        this.precios = precios;
    }

    public ArrayList<Double> getPrecioMillas() {
        return precioMillas;
    }

    public void setPrecioMillas(ArrayList<Double> precioMillas) {
        this.precioMillas = precioMillas;
    }

    public ArrayList<String> getLista_codigoitinerario() {
        return lista_codigoitinerario;
    }

    public void setLista_codigoitinerario(ArrayList<String> lista_codigoitinerario) {
        this.lista_codigoitinerario = lista_codigoitinerario;
    }

    public ArrayList<String> getLista_codigoitinerario_retorno() {
        return lista_codigoitinerario_retorno;
    }

    public void setLista_codigoitinerario_retorno(ArrayList<String> lista_codigoitinerario_retorno) {
        this.lista_codigoitinerario_retorno = lista_codigoitinerario_retorno;
    }

    public ArrayList<String> getCodigo_retorno() {
        return codigo_retorno;
    }

    public void setCodigo_retorno(ArrayList<String> codigo_retorno) {
        this.codigo_retorno = codigo_retorno;
    }

    public ArrayList<String> getCodigoAvion_retorno() {
        return codigoAvion_retorno;
    }

    public void setCodigoAvion_retorno(ArrayList<String> codigoAvion_retorno) {
        this.codigoAvion_retorno = codigoAvion_retorno;
    }

    public ArrayList<String> getLista_fechaSalida_retorno() {
        return lista_fechaSalida_retorno;
    }

    public void setLista_fechaSalida_retorno(ArrayList<String> lista_fechaSalida_retorno) {
        this.lista_fechaSalida_retorno = lista_fechaSalida_retorno;
    }

    public ArrayList<String> getLista_fechaLlegada_retorno() {
        return lista_fechaLlegada_retorno;
    }

    public void setLista_fechaLlegada_retorno(ArrayList<String> lista_fechaLlegada_retorno) {
        this.lista_fechaLlegada_retorno = lista_fechaLlegada_retorno;
    }

    public ArrayList<Double> getPrecios_retorno() {
        return precios_retorno;
    }

    public void setPrecios_retorno(ArrayList<Double> precios_retorno) {
        this.precios_retorno = precios_retorno;
    }

    public ArrayList<Double> getPrecioMillas_retorno() {
        return precioMillas_retorno;
    }

    public void setPrecioMillas_retorno(ArrayList<Double> precioMillas_retorno) {
        this.precioMillas_retorno = precioMillas_retorno;
    }
    
    
    
}
    

//      

        

