package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class SalidaString {


    public void salidaTexto(){
        try(PrintWriter pw= new PrintWriter(
                new FileWriter("texto.txt"))){
            String quijoti = " En un lugar de la mancha cuyo nombre no quiero acordarme";

            String[] palabras= quijoti.split("");

            for(int i= 0;i<palabras.length;i++){
                pw.println(palabras[i]);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
