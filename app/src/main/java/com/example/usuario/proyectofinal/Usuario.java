package com.example.usuario.proyectofinal;

/**
 * Created by Usuario on 13/06/2017.
 */

public class Usuario {
    int idUsuario;
    String nombre;
    String email;
    String password;
    String gender;

    public Usuario(){}

    public Usuario(int idUsuario,String nombre, String email, String password, String gender) {
        this.idUsuario=idUsuario;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
