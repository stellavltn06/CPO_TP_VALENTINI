/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Armes;

/**
 *
 * @author stell
 */
public class Epee extends Arme {
   
    
    private final int finesse; 

    
    public Epee(String nom, int niveauAttaque, int finesse) {
        super(nom, niveauAttaque); 
        
        
        if (finesse < 0) {
            this.finesse = 0;
        } else if (finesse >= 100) {
            this.finesse = 99;
        } else {
            this.finesse = finesse;
        }
    }

    // Getter pour la finesse
    public int getFinesse() {
        return finesse;
    }

    // Redéfinition de toString pour afficher toutes les infos
    @Override
    public String toString() {
        return "Epee : " + nom + " | Niveau d'attaque : " + niveauAttaque + " | Finesse : " + finesse;
    }  
}
