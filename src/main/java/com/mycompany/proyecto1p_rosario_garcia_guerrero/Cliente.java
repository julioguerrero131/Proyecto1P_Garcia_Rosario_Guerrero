package com.mycompany.proyecto1p_rosario_garcia_guerrero;

public class Cliente extends Usuario {
    protected String numTarjeta;
    
    public Cliente (String cedula, String nombres, int edad, String mail, String user, String password, char rol, String numTarjeta){
        super(cedula, nombres,edad, mail, user, password, rol);
        this.numTarjeta = numTarjeta; 
   }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    @Override
    public String toString() {
        return super.toString() + "Cliente{" + "numTarjeta=" + numTarjeta + '}';
    }

    
    
}
