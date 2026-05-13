/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Funciones;

import java.util.Scanner;

/**
 *
 * @author Andrés
 */
public class Teclado {
    Scanner opcion = new Scanner(System.in);
    
    /**
     * Metodo que permite mostrar por consola mensajes informativos
     * @param Mensaje Es la variable que contiene el mensaje que se mostrará
     */
    public void msn(String Mensaje){
        System.out.println(Mensaje);
    }
    
    /** 
     * Metodo que permite mostrar por consola mensajes de error
     * @param Mensaje 
     */
    public void msnError(String Mensaje){
        System.err.println(Mensaje);
    }
    
    /**
     *  
     * @param Mensaje
     * @return 
     */
    public String capText(String Mensaje){
        this.msn(Mensaje);
        return this.opcion.nextLine();
    }
    
    public int capInt(String Mensaje){
        try{
        return Integer.parseInt(capText(Mensaje));
        }catch(Exception e){
            this.msnError("El dato ingresado no es valido.");
            return capInt(Mensaje);
        }
    }
}
