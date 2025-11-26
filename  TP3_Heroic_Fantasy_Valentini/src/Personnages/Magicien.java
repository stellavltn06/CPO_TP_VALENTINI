/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author stell
 */
package Personnages;

public class Magicien extends Personnage {

    public static int nbMagiciens = 0;  // Compteur total

    private boolean estSorcier; // true = sorcier, false = magicien normal

    public Magicien(String nom, int niveauVie, boolean estSorcier) {
        super(nom, niveauVie);
        this.estSorcier = estSorcier;

        nbMagiciens++;
        nbPersonnages++;
    }

    public boolean isSorcier() {
        return estSorcier;
    }

    public void setSorcier(boolean estSorcier) {
        this.estSorcier = estSorcier;
    }

    public void detruire() {
    nbMagiciens--;     // décrémente le compteur spécifique
    nbPersonnages--;   // décrémente le compteur général
    System.out.println(nom + " le magicien a été détruit. NbMagiciens = " + nbMagiciens);
}
    public void attaquer(Personnage cible) {
    System.out.println(nom + " attaque " + cible.nom + " !");
    cible.estAttaque(20); // magicien inflige 20 points
}

}