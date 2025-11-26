/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2_relation_1_valentini;

/**
 *
 * @author stell
 */
public class Personne {
 String prenom;
    String nom;
    int nbVoitures;
    Voiture[] liste_voitures;

    public Personne(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
        this.nbVoitures = 0;
        this.liste_voitures = new Voiture[3]; // Peut posséder jusqu'à 3 voitures
    }

    // Méthode pour ajouter une voiture à cette personne
    public boolean ajouter_voiture(Voiture voiture_a_ajouter) {
        if (voiture_a_ajouter.proprietaire != null) {
            // La voiture a déjà un propriétaire => ajout impossible
            return false;
        }
        if (nbVoitures >= liste_voitures.length) {
            // Tableau plein => ajout impossible
            return false;
        }
        // Ajout possible
        liste_voitures[nbVoitures] = voiture_a_ajouter;
        nbVoitures++;
        voiture_a_ajouter.proprietaire = this; // On indique que cette personne est le propriétaire
        return true;
    }

    @Override
    public String toString() {
        String info = prenom + " " + nom + " possede " + nbVoitures + " voiture(s) :\n";
        for (int i = 0; i < nbVoitures; i++) {
            info += "  - " + liste_voitures[i] + "\n";
        }
        return info;
    }
}