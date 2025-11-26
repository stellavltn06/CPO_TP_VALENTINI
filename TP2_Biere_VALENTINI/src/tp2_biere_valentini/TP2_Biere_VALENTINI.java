/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp2_biere_valentini;

/**
 *
 * @author stell
 */
public class TP2_Biere_VALENTINI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
 // Bières créées via le constructeur
        BouteilleBiere b1 = new BouteilleBiere("Cuvee des trolls", 7.0, "Dubuisson");
        BouteilleBiere b2 = new BouteilleBiere("Leffe", 6.6, "Abbaye de Leffe");
        BouteilleBiere b3 = new BouteilleBiere("Heineken", 5.0, "Heineken");
        BouteilleBiere b4 = new BouteilleBiere("Karmeliet", 8.4, "Bosteels");

        // Test lireEtiquette()
        b1.lireEtiquette();
        b2.lireEtiquette();

        // Test decapsuler()
        b1.decapsuler();
        b1.decapsuler();  // provoque l’erreur volontairement

        // Test toString()
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
    }
}