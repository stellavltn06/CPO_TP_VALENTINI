/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personnages;

public class Guerrier extends Personnage {

    public static int nbGuerriers = 0;

    private boolean aCheval;

    public Guerrier(String nom, int niveauVie, boolean aCheval) {
        super(nom, niveauVie);
        this.aCheval = aCheval;

        nbGuerriers++;
        nbPersonnages++;
    }

    public boolean isACheval() {
        return aCheval;
    }

    public void setACheval(boolean aCheval) {
        this.aCheval = aCheval;
    }

public void detruire() {
    nbGuerriers--;     // décrémente le compteur spécifique
    nbPersonnages--;   // décrémente le compteur général
    System.out.println(nom + " le guerrier a été détruit. NbGuerriers = " + nbGuerriers);
}

public void attaquer(Personnage cible) {
    System.out.println(nom + " attaque " + cible.nom + " !");
    cible.estAttaque(30); // ou 20 selon la classe
}

}