/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tp3_heroic_fantasy_valentini;

/**
 *
 * @author stell
 */
public interface etreVivant {
    // La fatigue fait perdre des points de vie
    void seFatiguer();

    // Retourne true si le personnage est vivant (vie > 0)
    boolean estVivant();

    // Le personnage subit une attaque de 'points' points
    void estAttaque(int points);
}
