/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1p_rosario_garcia_guerrero;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Cliente Intel
 */
public class test {
    public static void main(String[] args) {
        Date fecha1= new Date();
        String fecha= new SimpleDateFormat("dd/MM/yyyy").format(fecha1);
//        System.out.println(LocalDate.now());
        System.out.println(fecha);
    }
}
