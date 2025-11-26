package Armes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author stell
 */
public class Baton extends Arme{
    
    private final int age; // <100

    // Constructeur
    public Baton(String nom, int niveauAttaque, int age) {
        super(nom, niveauAttaque); // appel du constructeur de la classe Arme
        
        // On limite l'âge à 0-99
        if (age < 0) {
            this.age = 0;
        } else if (age >= 100) {
            this.age = 99;
        } else {
            this.age = age;
        }
    }

    // Getter pour l'âge
    public int getAge() {
        return age;
    }

    // Redéfinition de toString pour afficher toutes les infos
    @Override
    public String toString() {
        return "Baton : " + nom + " | Niveau d'attaque : " + niveauAttaque + " | age : " + age;
    }
}
