package com.developers.carlos.uppy.modelos;

/**
 * Created by carlos on 29/09/16.
 */

public class Mascota {

    private String nombre;
    private int foto;
    private int cantidadMeGusta;

    public Mascota(String nombre, int foto, int cantidadMeGusta) {
        this.nombre = nombre;
        this.foto = foto;
        this.cantidadMeGusta = cantidadMeGusta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getCantidadMeGusta() {
        return cantidadMeGusta;
    }

    public void setCantidadMeGusta(int cantidadMeGusta) {
        this.cantidadMeGusta = cantidadMeGusta;
    }
}
