package tp2_biere_valentini;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author stell
 */
public class BouteilleBiere {
  
String nom;
    double degreAlcool;
    String brasserie;
    boolean ouverte;

    // Constructeur demandé en question 10
    public BouteilleBiere(String unNom, double unDegre, String uneBrasserie) {
        nom = unNom;
        degreAlcool = unDegre;
        brasserie = uneBrasserie;
        ouverte = false; // toujours fermé à la création
    }

    // Méthode lireEtiquette() – question 5
    public void lireEtiquette() {
        System.out.println(
            "Bouteille de " + nom + " (" + degreAlcool + " degres)\nBrasserie : " + brasserie
        );
    }

    // Méthode decapsuler() – question 12
    public boolean decapsuler() {
        if (!ouverte) {
            ouverte = true;
            System.out.println(nom + " est maintenant ouverte !");
            return true;
        } else {
            System.out.println("Erreur : biere deja ouverte !");
            return false;
        }
    }

    // Méthode toString() – question 13
    @Override
    public String toString() {
        String chaine_a_retourner;
        chaine_a_retourner = nom + " (" + degreAlcool + " degres) Ouverte ? ";
        if (ouverte == true) chaine_a_retourner += "oui";
        else chaine_a_retourner += "non";
        return chaine_a_retourner;
    }
}