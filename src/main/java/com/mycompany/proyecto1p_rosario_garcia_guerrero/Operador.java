/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1p_rosario_garcia_guerrero;

/**
 *
 * @author julio
 */
public class Operador extends Usuario {
    double sueldo;
    
     public Operador (String cedula, String nombres, int edad, String mail, String user, String password, char rol, double sueldo){
        super(cedula, nombres,edad, mail, user, password, rol);
        this.sueldo = sueldo; 
   }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        
        return super.toString() +"Operador{" + "sueldo=" + sueldo + '}';
    }
     
   
    
}
