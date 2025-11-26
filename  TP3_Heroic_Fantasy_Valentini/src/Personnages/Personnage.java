/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personnages;

import Armes.Arme;
import Armes.Baton;
import Armes.Epee;
import java.util.ArrayList;
import tp3_heroic_fantasy_valentini.etreVivant; // import interface correctement

public abstract class Personnage implements etreVivant {

    public static int nbPersonnages;

    public String nom;
    protected int niveauVie;

    // Tableau dynamique pour stocker les armes
    protected ArrayList<Arme> inventaire = new ArrayList<>();
    protected Arme armeEnMain = null;

    public Personnage(String nom, int niveauVie) {
        this.nom = nom;
        this.niveauVie = Math.max(0, niveauVie);
        nbPersonnages++;
    }

    // ------------------------
    // MÉTHODES DE L'INTERFACE
    // ------------------------

    @Override
    public void seFatiguer() {
        niveauVie -= 10;
        if (niveauVie < 0) niveauVie = 0;
        System.out.println(nom + " est fatigue et perd 10 points de vie !");
    }

    @Override
    public boolean estVivant() {
        return niveauVie > 0;
    }

    @Override
    public void estAttaque(int points) {
        niveauVie -= points;
        if (niveauVie < 0) niveauVie = 0;
        System.out.println(nom + " subit " + points + " points de degats !");
    }

public void attaquer(Personnage cible) {
    if (armeEnMain == null) {
        System.out.println(nom + " n'a pas d'arme et ne peut pas attaquer !");
        return;
    }

    int degats = armeEnMain.getNiveauAttaque(); // base des dégâts

    // Cas spécial Magicien avec Baton
    if (this instanceof Magicien && armeEnMain instanceof Baton) {
        Baton baton = (Baton) armeEnMain;
        degats *= baton.getAge(); // multiplication par l'âge du bâton
        seFatiguer(); // le magicien se fatigue
        Magicien mag = (Magicien) this;
        if (mag.isSorcier()) { // magicien confirmé → dégâts divisés par 2
            degats /= 2;
        }
    }

    // Cas spécial Guerrier avec Epee
    else if (this instanceof Guerrier && armeEnMain instanceof Epee) {
        Epee epee = (Epee) armeEnMain;
        degats *= epee.getFinesse(); // multiplication par la finesse de l'épée
        seFatiguer(); // le guerrier se fatigue
        Guerrier guerrier = (Guerrier) this;
        if (guerrier.isACheval()) { // guerrier à cheval → dégâts divisés par 2
            degats /= 2;
        }
    }

    // Cas général si arme non spéciale
    else {
        seFatiguer(); // fatigue quand même
    }

    // Appliquer les dégâts à la cible
    cible.estAttaque(degats);

    System.out.println(nom + " attaque " + cible.nom + " avec " + armeEnMain.getNom() +
                       " et lui inflige " + degats + " points de degats !");
}

    public void ajouterArme(Arme a) {
        if (inventaire.size() < 5) {
            inventaire.add(a);
            System.out.println(a.getNom() + " ajoutee a l'inventaire de " + nom);
        } else {
            System.out.println(nom + " a deja 5 armes, impossible d'ajouter " + a.getNom());
        }
    }

    public Arme getArmeEnMain() {
        return armeEnMain;
    }

    public void equiperArme(String nomArme) {
        for (Arme a : inventaire) {
            if (a.getNom().equalsIgnoreCase(nomArme)) {
                armeEnMain = a;
                System.out.println(nom + " equipe l'arme : " + nomArme);
                return;
            }
        }
        System.out.println(nom + " ne possede pas l'arme : " + nomArme);
    }
    
    
    @Override
    public String toString() {
        String info = "Personnage : " + nom + " | Vie : " + niveauVie;
        if (armeEnMain != null) {
            info += " | Arme en main : " + armeEnMain;
        }
        return info;
    }

    public int nbArmesPredilection() {
        int count = 0;
        for (Arme a : inventaire) {
            if (this instanceof Guerrier && a instanceof Epee) count++;
            if (this instanceof Magicien && a instanceof Baton) count++;
        }
        return count;
    }
    
    
}