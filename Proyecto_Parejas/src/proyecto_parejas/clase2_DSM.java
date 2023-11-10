package proyecto_parejas;

import java.io.File;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class clase2_DSM {

    Document documento;

    public int borrar(String tituloo) {
        System.out.println("Buscando libro para borrar con el titulo: " + tituloo);
        try {

            //lo utilizo para para obtener el elemento raiz "elemento principal"
            Node raiz = documento.getDocumentElement();

            //busco todos los elementos con el nombre especificado que son descendientes de documento "documento es el element que le he hemos dado"
            NodeList n = documento.getElementsByTagName("Titulo");

            //creo variable de tipo none 
            Node n1;

            //recorro n y asigno cada nodo de de n a la variable n1 cada vuelta del bucle, esto me permite trabajar cada con cada nodo individual de n.
            for (int i = 0; i < n.getLength(); i++) {
                n1 = n.item(i);

                if (n1.getNodeType() == Node.ELEMENT_NODE) // verifico si n1 es un elemento
                {
                    if (n1.getChildNodes().item(0).getNodeValue().equals(tituloo)) {//compruebo si el primer hij de n1 tiene el titulo que proporcionas en tituloo
                        System.out.println("Borrando el nodo <Libro> con título" + tituloo);  //doy alerta 

                        n1.getParentNode().getParentNode().removeChild(n1.getParentNode());
                    }
                }
            }
      
        System.out.println("Nodo Borrado");

        return 0;

    
    }catch(Exception e){
    System.out.println(e);
        e.printStackTrace();
        return -1;
    }
}
    public void guardarEnOtroArchivo(String nuevoArchivo) {
try {
Source src = new DOMSource(documento); // Definimos el origen
StreamResult rst = new StreamResult(new File(nuevoArchivo)); // Definimos el resultado

// Declaramos el Transformer que tiene el método .transform() que necesitamos.

Transformer transformer = TransformerFactory.newInstance().newTransformer();
// Opción para indentar el archivo
transformer.setOutputProperty(OutputKeys.INDENT, "yes");
transformer.transform(src, (javax.xml.transform.Result) rst);
System.out.println("Archivo creado del DOM con éxito");
}
catch (Exception e) {
e.printStackTrace();
}
    }
}

    
