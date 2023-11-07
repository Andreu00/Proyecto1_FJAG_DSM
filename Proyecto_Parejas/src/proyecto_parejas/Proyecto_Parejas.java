package proyecto_parejas;

import java.io.File;

public class Proyecto_Parejas {

    public static void main(String[] args) {
        clase1_FJAG clase1=new clase1_FJAG();
        File archivo=new File("books.xml");
        
        clase1.abrirXML(archivo);
        clase1.recorrerYMostrar();
    }
    
}
