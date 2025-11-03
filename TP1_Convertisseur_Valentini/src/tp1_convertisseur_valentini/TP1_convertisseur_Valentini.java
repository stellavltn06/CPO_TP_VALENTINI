/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp1_convertisseur_valentini;

import java.util.Scanner;

/**
 *
 * @author stell
 */
public class TP1_convertisseur_Valentini {

    // Méthodes de conversion
    public static double KelvinVersCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static double FahrenheitVersCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double CelsiusVersFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // On utilise les méthodes précédentes pour simplifier
    public static double KelvinVersFahrenheit(double kelvin) {
        return CelsiusVersFahrenheit(KelvinVersCelsius(kelvin));
    }

    public static double FahrenheitVersKelvin(double fahrenheit) {
        return CelsiusVersKelvin(FahrenheitVersCelsius(fahrenheit));
    }

    public static double CelsiusVersKelvin(double celsius) {
        return celsius + 273.15;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Saisie de la valeur
        System.out.print("Bonjour, saisissez une valeur : ");
        double valeur = sc.nextDouble();

        // Menu
        System.out.println("Saisissez la conversion que vous souhaitez effectuer :");
        System.out.println("1) De Celsius vers Kelvin");
        System.out.println("2) De Kelvin vers Celsius");
        System.out.println("3) De Celsius vers Fahrenheit");
        System.out.println("4) De Fahrenheit vers Celsius");
        System.out.println("5) De Kelvin vers Fahrenheit");
        System.out.println("6) De Fahrenheit vers Kelvin");
        System.out.print("Votre choix : ");

        int choix = sc.nextInt();
        double resultat = 0;
        String uniteDepart = null;
        String uniteArrivee = null;

        switch (choix) {
            case 1 -> {
                resultat = CelsiusVersKelvin(valeur);
                uniteDepart = "°C";
                uniteArrivee = "K";
            }
            case 2 -> {
                resultat = KelvinVersCelsius(valeur);
                uniteDepart = "K";
                uniteArrivee = "°C";
            }
            case 3 -> {
                resultat = CelsiusVersFahrenheit(valeur);
                uniteDepart = "°C";
                uniteArrivee = "°F";
            }
            case 4 -> {
                resultat = FahrenheitVersCelsius(valeur);
                uniteDepart = "°F";
                uniteArrivee = "°C";
            }
            case 5 -> {
                resultat = KelvinVersFahrenheit(valeur);
                uniteDepart = "K";
                uniteArrivee = "°F";
            }
            case 6 -> {
                resultat = FahrenheitVersKelvin(valeur);
                uniteDepart = "°F";
                uniteArrivee = "K";
            }
            default -> {
                System.out.println("Choix invalide !");
                System.exit(0);
            }
        }

        System.out.println(valeur + " " + uniteDepart + " est egal a " + resultat + " " + uniteArrivee);
    }
}
        // TODO code application logic here
    
    