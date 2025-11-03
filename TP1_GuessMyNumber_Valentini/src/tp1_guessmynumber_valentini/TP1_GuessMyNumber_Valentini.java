/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp1_guessmynumber_valentini;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author stell
 */
public class TP1_GuessMyNumber_Valentini {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                
        int maxEssais = 0;
        int maxNombre = 0;

        // 1. Choix de la difficulté
        Scanner sc = new Scanner(System.in);
        System.out.println("Choisissez le niveau de difficulte : facile, normal, difficile");
        String difficulte = sc.nextLine().toLowerCase();

        switch (difficulte) {
            case "facile":
                maxNombre = 50;
                maxEssais = 15;
                break;
            case "normal":
                maxNombre = 100;
                maxEssais = 10;
                break;
            case "difficile":
                maxNombre = 200;
                maxEssais = 5;
                break;
            default:
               System.out.println("Niveau inconnu, on utilise normal par défaut.");
                maxNombre = 100;
                maxEssais = 10;
        }
        
        int nombre;
        int saisie = 0;
        int compteur = 0;
        
        Random generateurAleat = new Random(); 
        nombre = generateurAleat.nextInt(maxNombre + 1);
        

        while (saisie != nombre && compteur<maxEssais) {
            System.out.println("Saisissez un nombre entre 0 et " +maxNombre + ":");
            saisie = sc.nextInt();  // lire un entier
            compteur=compteur+1;
            
            if (saisie < nombre) {
                if (Math.abs(saisie - nombre) > maxNombre / 2) {
                    System.out.println("Vraiment trop petit !");
                } else {
                    System.out.println("Trop petit !");
                }
                
            } else if (saisie > nombre) {
                if (Math.abs(saisie - nombre) > maxNombre / 2) {
                    System.out.println("Vraiment trop grand !");
                } else {
                    System.out.println("Trop grand !");
                    }
                }
            }
        
    
            if (saisie == nombre) {
            System.out.println("Gagne ! Vous avez trouve le nombre !");
            System.out.println("Nombre de tentatives : " + compteur);
        } else {
            System.out.println("Perdu ! Le nombre etait : " + nombre);
        }

        sc.close();
    }
}