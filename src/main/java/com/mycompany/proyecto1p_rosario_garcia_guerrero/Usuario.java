/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1p_rosario_garcia_guerrero;

/**
 *
 * @author Cliente Intel
 */
public abstract class Usuario {
    protected String cedula;
    protected String nombres;
    protected int edad;
    protected String mail;
    protected String user;
    protected String password;
    protected char rol;
    
    public Usuario(String cedula, String nombres, int edad, String mail, String user, String password, char rol){
        this.cedula = cedula;
        this.nombres = nombres;
        this.edad = edad;
        this.mail = mail;
        this.user = user;
        this.password = password;
        this.rol = rol;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getRol() {
        return rol;
    }

    public void setRol(char rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" + "cedula=" + cedula + ", nombres=" + nombres + ", edad=" + edad + ", mail=" + mail + ", user=" + user + ", password=" + password + ", rol=" + rol + '}';
    }
    
    
    
}
