/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2_relation_1_valentini;

/**
 *
 * @author stell
 */
public class Voiture {
  String modele;
    String marque;
    int nbPortes;
    Personne proprietaire;

    // Constructeur avec 3 paramètres
    public Voiture(String modele, String marque, int nbPortes) {
        this.modele = modele;
        this.marque = marque;
        this.nbPortes = nbPortes;
        this.proprietaire = null; // pas de propriétaire au départ
    }

    @Override
    public String toString() {
        String info = marque + " " + modele + " (" + nbPortes + " portes)";
        if (proprietaire != null) {
            info += " - Proprietaire : " + proprietaire.prenom + " " + proprietaire.nom;
        }
        return info;
    }
}
