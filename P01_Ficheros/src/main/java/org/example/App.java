package org.example;
import java.io.IOException;
import java.nio.file.*;

public class App {
    
    public static void main(String[] args) throws IOException {

        SalidaBytes s = new SalidaBytes();
        s.escribir();

        Path p1= Paths.get("temario","java.txt");
        System.out.println(p1.toAbsolutePath().toString());

        Path p2= FileSystems.getDefault().getPath("java","javanio.txt");
        System.out.println(p2.toAbsolutePath().toString());

        Path p3= Paths.get(System.getProperty("user.home"),"Documents","java");
        System.out.println(p3.toAbsolutePath().toString());

        Path notas= Paths.get("notas.txt");
        if(Files.exists(notas)){
            Path bakDir= Paths.get("backup");
            System.out.println(bakDir.toAbsolutePath().toString());

            if(!Files.exists(bakDir)){
                Files.createDirectories(bakDir);
            }

            Path backfile= bakDir.resolve( Paths.get("notas.backdir"));

            if(Files.exists(backfile)){
                String oldCompleteFilename = backfile.getFileName().toString();
                String oldFileName= oldCompleteFilename.split("")[0];
                String oldVersion = oldFileName.split(".")[1];
                backfile = bakDir.resolve(
                        Paths.get(oldFileName + "Notas-1-dam")
                );
            }
            Files.copy(notas,backfile, StandardCopyOption.REPLACE_EXISTING);
        }
    }


}
