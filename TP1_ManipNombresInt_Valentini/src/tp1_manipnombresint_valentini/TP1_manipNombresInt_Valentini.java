/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp1_manipnombresint_Valentini;

import java.util.Scanner;

/**
 * date 24/10
 * @author stella
 * Saisie et manipulation de nombres
 */
public class TP1_manipNombresInt_Valentini{

    private static int nb1;
    private static int nb2;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer le nombre 1 :");  
        nb1=sc.nextInt();
        System.out.println("Entrer le nombre 2 :");  
        nb2=sc.nextInt();
        System.out.println("La somme de vos nombres est : " + (nb1+nb2));
        System.out.println("La difference de vos nombres est : " + (nb1-nb2));
        System.out.println("Le produit de vos nombres est : " + (nb1*nb2));
        System.out.println("Le quotient entier de vos nombres est : " + (nb1/nb2));
        System.out.println("Le reste de la division euclidienne de vos nombres est : " + (nb1%nb2));
    }
   
}