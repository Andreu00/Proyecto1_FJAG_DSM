package proyecto_parejas;

import java.io.File;

public class Proyecto_Parejas {

    public static void main(String[] args) {
        clase1_FJAG clase1=new clase1_FJAG();
        clase2_DSM clase2 = new clase2_DSM();
        File archivo=new File("books.xml");
        
        clase1.abrirXML(archivo);
        clase1.recorrerYMostrar();
        clase1.insertarLibroEnDOM("sdf", "sdf", "sdf");
        clase2.borrar("sdf");
        clase2.guardarEnOtroArchivo("sdf");
        
    }
    
}
