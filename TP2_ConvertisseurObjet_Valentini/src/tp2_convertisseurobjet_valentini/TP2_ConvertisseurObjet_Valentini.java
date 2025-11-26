/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp2_convertisseurobjet_valentini;

import java.util.Scanner;

/**
 *
 * @author stell
 */
public class TP2_ConvertisseurObjet_Valentini {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
        Convertisseur conv = new Convertisseur();
        double valeur, resultat;
        int choix;

        do {
            System.out.println("=== MENU CONVERTISSEUR ===");
            System.out.println("1 : Celsius vers Kelvin");
            System.out.println("2 : Kelvin vers Celsius");
            System.out.println("3 : Fahrenheit vers Celsius");
            System.out.println("4 : Celsius vers Fahrenheit");
            System.out.println("5 : Kelvin vers Fahrenheit");
            System.out.println("6 : Fahrenheit vers Kelvin");
            System.out.println("0 : Quitter");
            System.out.print("Votre choix : ");
            choix = sc.nextInt();

            if (choix != 0) {
                System.out.print("Entrez la temperature a convertir : ");
                valeur = sc.nextDouble();

                switch (choix) {
                    case 1 -> {
                        resultat = conv.CelciusVersKelvin(valeur);
                        System.out.println("Resultat : " + resultat);
                    }
                    case 2 -> {
                        resultat = conv.KelvinVersCelcius(valeur);
                        System.out.println("Resultat : " + resultat);
                    }
                    case 3 -> {
                        resultat = conv.FarenheitVersCelcius(valeur);
                        System.out.println("Resultat : " + resultat);
                    }
                    case 4 -> {
                        resultat = conv.CelciusVersFarenheit(valeur);
                        System.out.println("Resultat : " + resultat);
                    }
                    case 5 -> {
                        resultat = conv.KelvinVersFarenheit(valeur);
                        System.out.println("Resultat : " + resultat);
                    }
                    case 6 -> {
                        resultat = conv.FarenheitVersKelvin(valeur);
                        System.out.println("Resultat : " + resultat);
                    }
                    default ->
                        System.out.println("Choix invalide !");
                }

                System.out.println("Conversions realisees : " + conv);
                System.out.println();
            }

        } while (choix != 0);

        System.out.println("Programme termine.");
    }
}