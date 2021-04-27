package com.example.proy_electiva1;


import java.io.Serializable;

public class csContinente implements Serializable {
    private String nombre;
    private char img;
    public csContinente(String nombre, char img){
        this.nombre=nombre;
        this.img=img;
    }

    public String getNombre(){
        return nombre;
    }

    public char getImg(){
        return img;
    }
}
