/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_parejas;

import java.io.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import java.util.*;
import org.xml.sax.SAXException;

/**
 *
 * @author maget
 */
public class clase1_FJAG {
    Document documento;
    
    public int abrirXML(File archivo){
        try{
            System.out.println("Abriendo archivo...");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            factory.setIgnoringComments(true); //Ignorar Comentarios
            factory.setIgnoringElementContentWhitespace(true); //Ignorar Espacios en Blanco
            
            
            DocumentBuilder builder=factory.newDocumentBuilder();
            
            //para generar el DOM en memoria
            documento=builder.parse(archivo);
            
            System.out.println("DOM creado...");
            return 0;
        //He creado estas 3 excepciones debido a que en el ejemplo del ejercicio anteriormente realizado
        //utiliza la excepcion que agrupa todas en una, cosa que no es eficaz
        }catch(IOException ex){
            System.out.println(ex);
            return -1;
        } catch (SAXException ex) {
            System.out.println(ex);
            return -1;
        } catch (ParserConfigurationException ex) {
            System.out.println(ex);
            return -1;
        } 
    }
    
    public void recorrerYMostrar(){
        String[] datos=new String[7]; //vector que almacenará la informacion de cada nodo
        Node nodo=null;
        Node root=documento.getFirstChild();
        NodeList nodelist=root.getChildNodes(); //Muestra todo el contenido que almacena el nodo padre
        for(int i=0;i<nodelist.getLength();i++){
            nodo=nodelist.item(i);//node toma el valor de los hijos de raíz
            if(nodo.getNodeType()==Node.ELEMENT_NODE){//miramos nodos de tipo Element
                Node ntemp=null;
                int contador=1;
                //sacamos el valor del atributo publicado
                datos[0]=nodo.getAttributes().item(0).getNodeValue();
                //sacamos los valores de los hijos de nodo, Titulo y Autor
                NodeList nl2=nodo.getChildNodes();//obtenemos lista de hijos
                for(int j=0;j<nl2.getLength();j++){//iteramos en esa lista
                    ntemp=nl2.item(j);
                    if(ntemp.getNodeType()==Node.ELEMENT_NODE){

                    if(ntemp.getNodeType()==Node.ELEMENT_NODE){

                        //para conseguir el texto de titulo y autor, se
                        //puedo hacer con getNodeValue(), también con
                        //getTextContent() si es ELEMENT
                        datos[contador]=ntemp.getTextContent();
                    // también datos[contador]=ntemp.getChildNodes().item(0).getNodeValue();

                        contador++;

                    }
                    }
                //el array de String datos[] tiene los valores que necesitamos
            System.out.println(datos[0]+"--"+datos[2]+"--"+datos[1]);
                }//
            }
        }
    }
    
    
}
