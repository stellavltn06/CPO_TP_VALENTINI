///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
// */
package tp1_statistiques_valentini;
//
import java.util.Random;
import java.util.Scanner;
//
///**
// *
// * @author stell
// */
public class TP1_Statistiques_Valentini {
//
//    /**
//     * @param args the command line arguments
//     */
public static void main(String[] args) {
//    
        int[] des = new int[6];
        int i;       
        int m;
        int lancer; 
        
//        //demande de saisie a l'utilisateur du nb de lancer m voulu
       System.out.println("Veuillez saisir le nombre de lancer de des :");
        Scanner sc = new Scanner (System.in);
        m=sc.nextInt();
//        
//        //boucle de m itérations, et à chaque itérations, tirage d'un nombre aléatoire entre 0 et 5
        for (i=0;i<m;i=i+1){
            Random generateurAleat = new Random();
            lancer=generateurAleat.nextInt(6);
            des[lancer]=des[lancer]+1; //on ajoute 1 à la face lancer
                    }
        
//        //affichage des résultats pour chaque face
        for (i=0;i<des.length;i=i+1){
            double pourcentage;
            pourcentage=((double)des[i]/m)*100;
            System.out.println("Face " +(i+1)+ " : " + des[i] + " = " + pourcentage + "% ");
        }
//        // TODO code application logic here
    }
//    
}
