package com.example.proy_electiva1;

public class csdesglo {
    private String nombre;
    private char img;
    public csdesglo(String nombre, char img){
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

