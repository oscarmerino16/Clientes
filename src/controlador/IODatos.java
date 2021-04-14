/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.CLientes;

/**
 *
 * @author alumnodaw
 */
public class IODatos {
    
    public static void guardarDatos(ArrayList<CLientes>vCLientes){
      //Guardar==Escaribir 
      File f = new File("Clientes.dat");
      
        if (f.exists()) {
           try {
               f.createNewFile();
           } catch (IOException ex) {
               Logger.getLogger(IODatos.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        
         try (FileOutputStream fo = new FileOutputStream(f);
        ObjectOutputStream escribir = new ObjectOutputStream(fo);){

        
        escribir.writeObject(vCLientes);
         
        
    }   catch (FileNotFoundException ex) {
            Logger.getLogger(IODatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IODatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    } 
    
     public static ArrayList<CLientes> cargarClientes(){
        ArrayList<CLientes> vCliente = new ArrayList();
        String ruta = "Clientes.dat";
        File f = new File(ruta);

        //crear fichero si no existe
        if (!f.exists()) {

            try {
                f.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(IODatos.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //leer fichero
        try (FileInputStream fi = new FileInputStream(f);
        ObjectInputStream leer = new ObjectInputStream(fi);){

            vCliente = (ArrayList<CLientes>) leer.readObject();

        } catch (IOException ex) {
            Logger.getLogger(IODatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IODatos.class.getName()).log(Level.SEVERE, null, ex);
        }

      //devuelve el vector
      return vCliente;
    }
    
    
}
