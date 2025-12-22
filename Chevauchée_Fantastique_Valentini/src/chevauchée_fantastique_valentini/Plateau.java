/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chevauchée_fantastique_valentini;

/**
 *
 * @author stell
 */
public class Plateau {
    private Damier[][] damier;
    private Cavalier cavalier;
    private int lignes;
    private int colonnes;

    public Plateau(int lignes, int colonnes) {
        this.lignes = lignes;
        this.colonnes = colonnes;

        damier = new Damier[lignes][colonnes];

        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                damier[i][j] = new Damier(true);
            }
        }

        // Cavalier au centre
        int x = lignes / 2;
        int y = colonnes / 2;
        cavalier = new Cavalier(x, y);
        damier[x][y].eteindre();
    }
    
    public Damier getCase(int x, int y) {
    return damier[x][y];
}

public Cavalier getCavalier() {
    return cavalier;
}

public int getLignes() {
    return lignes;
}

public int getColonnes() {
    return colonnes;
}

// Vérifie si le déplacement du cavalier est valide
public boolean deplacementValide(int x, int y) {
    int dx = Math.abs(cavalier.getX() - x);
    int dy = Math.abs(cavalier.getY() - y);

    // mouvement du cavalier (2 + 1)
    if (!((dx == 2 && dy == 1) || (dx == 1 && dy == 2))) {
        return false;
    }

    // reste dans le plateau
    if (x < 0 || x >= lignes || y < 0 || y >= colonnes) {
        return false;
    }

    // la case doit être encore allumée
    return damier[x][y].estAllumee();
}

// Déplace réellement le cavalier
public void deplacerCavalier(int x, int y) {
    // éteint l'ancienne case
    damier[cavalier.getX()][cavalier.getY()].eteindre();

    // déplace le cavalier
    cavalier.deplacer(x, y);
}

public boolean victoire() {
    for (int i = 0; i < lignes; i++) {
        for (int j = 0; j < colonnes; j++) {
            // si une case est allumée et ce n'est pas la position du cavalier
            if (damier[i][j].estAllumee() && !(i == cavalier.getX() && j == cavalier.getY())) {
                return false; // pas encore gagné
            }
        }
    }
    return true; // toutes les cases sont éteintes => victoire
}

}