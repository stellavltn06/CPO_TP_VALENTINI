package chevauchée_fantastique_valentini;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author stell
 */
public class Damier {
    private boolean allumee;

    public Damier (boolean allumee) {
        this.allumee = allumee;
    }

    public boolean estAllumee() {
        return allumee;
    }

    public void eteindre() {
        allumee = false;
    }
    
    public void allumer() {
        allumee = true;
    }
    
}
