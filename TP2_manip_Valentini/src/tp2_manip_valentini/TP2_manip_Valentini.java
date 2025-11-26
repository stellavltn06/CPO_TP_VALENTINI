/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp2_manip_valentini;

/**
 *
 * @author stell
 */
public class TP2_manip_Valentini {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Création de 2 tartiflettes
        Tartiflette assiette1 = new Tartiflette(500);
        Tartiflette assiette2 = new Tartiflette(600);

        // assiette3 référence la même tartiflette que assiette2
        Tartiflette assiette3 = assiette2;

        // Affichage des calories
        System.out.println("Assiette 1 : " + assiette1.nbCalories); // 500
        System.out.println("Assiette 2 : " + assiette2.nbCalories); // 600
        System.out.println("Assiette 3 : " + assiette3.nbCalories); // 600

        // Incrémenter les calories de assiette2
        assiette2.nbCalories += 50;

        // Vérifier que assiette3 a aussi changé
        System.out.println("Apres modification :");
        System.out.println("Assiette 2 : " + assiette2.nbCalories); // 650
        System.out.println("Assiette 3 : " + assiette3.nbCalories); // 650

        // Échanger les références assiette1 et assiette2
        Tartiflette temp = assiette1;
        assiette1 = assiette2;
        assiette2 = temp;

        System.out.println("Apres echange :");
        System.out.println("Assiette 1 : " + assiette1.nbCalories); // 650
        System.out.println("Assiette 2 : " + assiette2.nbCalories); // 500

        // Question 6 : Est-ce correct ?
        // Moussaka assiette666 = assiette1; // ❌ NON, types différents
        // Moussaka assiette667 = new Tartiflette(); // ❌ NON, types différents

        // Tableau de 10 moussakas
        Moussaka[] plateau = new Moussaka[10];
        for (int i = 0; i < plateau.length; i++) {
            plateau[i] = new Moussaka(400 + i * 10); // Chaque moussaka a des calories différentes
        }

        // Affichage des calories des moussakas
        for (int i = 0; i < plateau.length; i++) {
            System.out.println("Moussaka " + i + " : " + plateau[i].nbCalories + " calories");
        }
    }
}
