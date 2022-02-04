package org.example;

import java.io.*;

public class CopyBytes {


    public static final int BUFFER_SIZE= 1024-16;
    public static final int EOF =-1;
    public static void copyBytes(String src,String dst){

        try(BufferedInputStream in= new BufferedInputStream(new FileInputStream(src));

            BufferedOutputStream out= new BufferedOutputStream(new FileOutputStream(dst));
        ){
            int cantidadBytesLeidos = 0;
            byte[] buffer =new byte[BUFFER_SIZE];

            while((cantidadBytesLeidos= in.read(buffer,0,BUFFER_SIZE)) !=EOF){
                out.write(buffer,0,cantidadBytesLeidos);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
