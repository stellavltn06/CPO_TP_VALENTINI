/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Armes;

/**
 *
 * @author stell
 */
public abstract class Arme {

    protected String nom;
    protected int niveauAttaque;

    public Arme(String nom, int niveauAttaque) {
        this.nom = nom;
        if (niveauAttaque < 0) this.niveauAttaque = 0;
        else if (niveauAttaque > 100) this.niveauAttaque = 100;
        else this.niveauAttaque = niveauAttaque;
    }

    public String getNom() {
        return nom;
    }

    public int getNiveauAttaque() {
        return niveauAttaque;
    }

    @Override
    public String toString() {
        return "Arme : " + nom + " | Niveau d'attaque : " + niveauAttaque;
    }
}
