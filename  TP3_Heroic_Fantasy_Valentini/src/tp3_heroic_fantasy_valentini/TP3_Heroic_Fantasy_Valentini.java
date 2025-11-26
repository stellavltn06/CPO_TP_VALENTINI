/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package tp3_heroic_fantasy_valentini;

import Armes.*;
import Personnages.*;
import java.util.ArrayList;

public class TP3_Heroic_Fantasy_Valentini {

    public static void main(String[] args) {

        // -----------------------
        //     CREATION ARMES
        // -----------------------
        Epee epee1 = new Epee("Excalibur", 7, 5);
        Epee epee2 = new Epee("Durandal", 4, 7);
        Baton baton1 = new Baton("Chene", 4, 5);
        Baton baton2 = new Baton("Charme", 5, 6);

        ArrayList<Arme> armes = new ArrayList<>();
        armes.add(epee1);
        armes.add(epee2);
        armes.add(baton1);
        armes.add(baton2);

        System.out.println("===== LISTE DES ARMES =====");
        armes.forEach(System.out::println);


        // -----------------------
        //   CREATION PERSONNAGES
        // -----------------------
        Magicien mag1 = new Magicien("Gandalf", 65, true);
        Magicien mag2 = new Magicien("Garcimore", 44, false);
        Guerrier g1 = new Guerrier("Conan", 78, false);
        Guerrier g2 = new Guerrier("Lannister", 45, true);

        ArrayList<Personnage> persos = new ArrayList<>();
        persos.add(mag1);
        persos.add(mag2);
        persos.add(g1);
        persos.add(g2);


        // -----------------------
        //   AJOUT ARMES
        // -----------------------
        mag1.ajouterArme(baton1);
        mag1.ajouterArme(epee1);

        mag2.ajouterArme(baton2);

        g1.ajouterArme(epee1);
        g1.ajouterArme(epee2);

        g2.ajouterArme(epee2);


        // -----------------------
        //   EQUIPER ARMES
        // -----------------------
        mag1.equiperArme("Chene");
        mag2.equiperArme("Charme");
        g1.equiperArme("Excalibur");
        g2.equiperArme("Durandal");


        // -----------------------
        //   AFFICHAGE
        // -----------------------
        System.out.println("\n===== PERSONNAGES EQUIPES =====");
        persos.forEach(System.out::println);


        // -----------------------
        //   ARMES DE PREDILECTION
        // -----------------------
        System.out.println("\nConan possede " + g1.nbArmesPredilection() + " epee(s) de predilection");
        System.out.println("Gandalf possede " + mag1.nbArmesPredilection() + " baton(s) de predilection");


        // -----------------------
        //   COMPTEURS
        // -----------------------
        System.out.println("\nNombre total de personnages : " + Personnage.nbPersonnages);
        System.out.println("Nombre de magiciens : " + Magicien.nbMagiciens);
        System.out.println("Nombre de guerriers : " + Guerrier.nbGuerriers);
        
        // Création d'un magicien et d'un guerrier pour le test
Magicien testMag = new Magicien("Merlin", 50, false);
Guerrier testGuer = new Guerrier("Arthur", 60, true);

// Affichage de leurs caractéristiques et des compteurs
System.out.println("\n=== Creation des personnages pour test ===");
System.out.println(testMag);
System.out.println(testGuer);
System.out.println("Nombre total de personnages : " + Personnage.nbPersonnages);
System.out.println("Nombre de magiciens : " + Magicien.nbMagiciens);
System.out.println("Nombre de guerriers : " + Guerrier.nbGuerriers);

// Fatigue du guerrier
System.out.println("\n=== Fatigue du guerrier ===");
testGuer.seFatiguer();

// Affichage du guerrier et vérification s'il est vivant
System.out.println(testGuer);
if(testGuer.estVivant()) {
    System.out.println(testGuer.nom + " est toujours vivant !");
} else {
    System.out.println(testGuer.nom + " est mort !");
}

// Attaque du guerrier sur le magicien
System.out.println("\n=== Le guerrier attaque le magicien ===");
testGuer.attaquer(testMag);

// Affichage après l'attaque
System.out.println(testMag);
System.out.println(testGuer);
    
    
    // Attaque du magicien sur le guerrier
System.out.println("\n=== Le magicien attaque le guerrier ===");
testMag.attaquer(testGuer);

// Affichage après l'attaque
System.out.println(testMag);
System.out.println(testGuer);

// Vérification si les deux personnages sont vivants
System.out.println("\n=== Verification de l'etat de vie ===");
System.out.println(testMag.nom + (testMag.estVivant() ? " est vivant !" : " est mort !"));
System.out.println(testGuer.nom + (testGuer.estVivant() ? " est vivant !" : " est mort !"));

}
}