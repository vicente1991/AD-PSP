package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UsandoFile {

    public void escribir() {
        File f= new File("file.txt");

        try(PrintWriter pw= new PrintWriter(new FileWriter(f)
                
        )){

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
