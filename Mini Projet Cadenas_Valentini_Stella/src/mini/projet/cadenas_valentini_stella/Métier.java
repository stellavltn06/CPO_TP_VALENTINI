package mini.projet.cadenas_valentini_stella;

import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author stell
 */
public class Métier {
    private static final int LONGUEUR_CODE = 4;
    private static final int MAX_TENTATIVES = 5;
    private static final int MIN_CHIFFRE = 0;
    private static final int MAX_CHIFFRE = 9;
   
    private int[] codeSecret;
    private int tentativesRestantes;
    private boolean estGagne;
   
    public Métier() {
        démarrerJeu();
}
   
    public final void démarrerJeu() {
        codeSecret = générerCodeSecret();
        tentativesRestantes = MAX_TENTATIVES;
        estGagne = false;
    }
   
    private int[] générerCodeSecret() {
        Random rand = new Random();
        int[] code = new int[LONGUEUR_CODE];
        for (int i = 0; i < LONGUEUR_CODE; i++) {
            code[i] = rand.nextInt(MAX_CHIFFRE - MIN_CHIFFRE + 1) + MIN_CHIFFRE;
        }
        return code;
    }
   
    public int[] testerCombinaison(int[] essai) throws IllegalArgumentException {
        // Validation basique
        if (essai == null || essai.length != LONGUEUR_CODE) {
            throw new IllegalArgumentException("L'essai doit être un tableau de " + LONGUEUR_CODE + " chiffres.");
        }
       
        if (estPartieTerminee() && !estGagne) {
            return new int[]{0, 0, 0};
        }

        int exacts = 0;
        int tropHauts = 0;
        int tropBas = 0;

        for (int i = 0; i < LONGUEUR_CODE; i++) {
            if (essai[i] == codeSecret[i]) {
                exacts++;
            } else if (essai[i] > codeSecret[i]) {
                tropHauts++;
            } else { // essai[i] < codeSecret[i]
                tropBas++;
            }
        }
        tentativesRestantes--;
        if (exacts == LONGUEUR_CODE) {
            estGagne = true;
        }
       
        return new int[]{exacts, tropHauts, tropBas};
    }
   
    public boolean estPartieTerminee() {
        return estGagne || tentativesRestantes <= 0;
    }
   
    public int getTentativesEffectuees() {
        return MAX_TENTATIVES - tentativesRestantes;
    }
   
    public int getMaxTentatives() {
        return MAX_TENTATIVES;
    }

    public boolean estGagne() {
        return estGagne;
    }
   
    public String getCodeSecretString() {
         return arrayToString(codeSecret);
    }
   
    private String arrayToString(int[] arr) {
        if (arr == null) return "";
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i);
        }
        return sb.toString();
    }
}
