/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp0_hello_world_valentini;

import java.util.Scanner;

/**
 *
 * @author stell
 */
public class TP0_Hello_World_VALENTINI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Bonjour");
        
        String prenom; 
        Scanner sc ; 
        sc = new Scanner (System.in) ; 
        System.out.println("Quel est votre prénom ?"); 
        prenom = sc.nextLine(); 
        System.out.println("Bonjour " + prenom);
        
        System.out.println("Au revoir");
        // TODO code application logic here
    }
    
}
