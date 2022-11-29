package TestJ;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import com.mycompany.proyecto1p_rosario_garcia_guerrero.ManejoArchivos;
import java.util.ArrayList;
/**
 *
 * @author julio
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<String> lineas = ManejoArchivos.LeeFichero("usuarios.txt");
        lineas.remove(0);
        System.out.println(lineas);
        
        System.out.println(lineas);
        
    }
    
}
