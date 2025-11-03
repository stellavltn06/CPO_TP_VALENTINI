/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp0_addition_valentini;

/**
 *
 * @author stell
 */
public class TP0_Addition_Valentini {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int nb;
        int result; // resultat 
        int ind; //indice  
// initialisation 
        nb=5;  
    result=0;  
// addition des nb premiers entiers  
    ind=1; 
    while (ind< nb) {  
        result=result+ind; ind++; 
}  
// affichage du resultat  
System.out.println("la somme des "+ nb + " entiers est: "+result);
        // TODO code application logic here
    }
    
}
