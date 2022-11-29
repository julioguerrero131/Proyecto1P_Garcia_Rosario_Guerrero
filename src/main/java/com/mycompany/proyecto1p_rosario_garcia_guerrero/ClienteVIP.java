package com.mycompany.proyecto1p_rosario_garcia_guerrero;
import java.util.ArrayList;

public class ClienteVIP extends Cliente{
    protected String tipoVIP;
    protected int millas;
    protected ArrayList<ClienteVIP> listaClientesVIP;

    public ClienteVIP(String cedula, String nombres, int edad, String mail, String user, String password, char rol, int num_tarjeta, String tipoVIP, int millas){
     super(cedula, nombres,edad, mail, user, password, rol, num_tarjeta);
     this.tipoVIP = tipoVIP;
     this.millas = millas;
    }
    
    public int acumuladorMillas(){
        int millasIniciales = 1000;
        int totalMillas = 0;
        for(Usuario u: Sistema.lista_usuarios){
            if(u.getRol()=='V'){
                for(ClienteVIP cl1 : listaClientesVIP){
                    totalMillas = cl1.getMillas() + millasIniciales; 
                }          
            }
        } 
        return totalMillas;
    }
    
    public ArrayList<ClienteVIP> consultarClienteVIP(ArrayList<Usuario>lista_usuario,ArrayList<String>listaClientes){
        for(int i=1; i<listaClientes.size(); i++){
            String []cliente= listaClientes.get(i).split(",");
            for(Usuario u:lista_usuario){
                if(u.getCedula().equals(cliente[0])){
                    ClienteVIP clientePrueba = new ClienteVIP(u.getCedula(), u.getNombres(),u.getEdad(), u.getMail(), u.getUser(), u.getPassword(), u.getRol(), Integer.parseInt(cliente[1]), cliente[2], Integer.parseInt(cliente[3]));
                    listaClientesVIP.add(clientePrueba);
                }
            }
        } 
        return listaClientesVIP;
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


