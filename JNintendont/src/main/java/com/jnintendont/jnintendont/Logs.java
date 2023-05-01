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
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Date;
public class Logs {
    private final File LOG_FILE;
    
    public Logs(String path) {
        this.LOG_FILE = new File(path);
    }
    
    public void escribirLog(String log) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE))) {
            writer.write(new Date() + log + "\n");
        }catch(IOException e) {
            System.err.println("Error: " +  e);
        }
    }
}
