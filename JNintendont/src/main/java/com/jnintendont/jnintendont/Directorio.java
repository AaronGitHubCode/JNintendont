/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jnintendont.jnintendont;

/**
 *
 * @author aaron
 */
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;
public class Directorio extends Logs{
    private final String PATH;
    
    private double porcentaje = 0D;
    
    public Directorio(String path) {
        super(path);
        this.PATH = path;
        
        File directorio = new File(path);
        
        if(directorio.isDirectory()) {
            for(String s : directorio.list()) {
                if(s.split(Pattern.quote("."))[s.split(Pattern.quote(".")).length  - 1].equals("iso")) {
                    try {
                        File nuevoDirectorio = new File(path + "/" + s.split(Pattern.quote("."))[0]);
                        File gameIso = new File(path + "/" + s);
                        nuevoDirectorio.mkdir();
                        gameIso.renameTo(new File(nuevoDirectorio + "/game.iso"));
                        porcentaje += (100 / directorio.list().length);
                    }catch(Exception e) {
                        System.err.println("Error: " + e);
                    }
                }
            }
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("./UltimoDirectorio"))){
                writer.write(path);
            }catch(IOException e){
                System.err.println("Error: " + e);
            }
        }else {
            System.out.println("No es un directorio");
        }
    }
    
    public double getPorcentaje() {
        return this.porcentaje;
    }
    
    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
}
