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
    private int taille;

    public Plateau(int taille) {
        this.taille = taille;
        damier = new Damier[taille][taille];

        // Initialisation : toutes les cases sont allumées
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                damier[i][j] = new Damier(true);
            }
        }

        // Cavalier au centre
        int start = taille / 2;
        cavalier = new Cavalier(start, start);
        damier[start][start].eteindre();
    }

    public boolean deplacementValide(int x, int y) {
        int dx = Math.abs(x - cavalier.getX());
        int dy = Math.abs(y - cavalier.getY());

        boolean mouvementCavalier =
                (dx == 2 && dy == 1) || (dx == 1 && dy == 2);

        return mouvementCavalier &&
               x >= 0 && y >= 0 &&
               x < taille && y < taille &&
               damier[x][y].estAllumee();
    }

    public void deplacerCavalier(int x, int y) {
        cavalier.deplacer(x, y);
        damier[x][y].eteindre();
    }

    public boolean victoire() {
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                if (damier[i][j].estAllumee()) {
                    return false;
                }
            }
        }
        return true;
    }

    public Damier getCase(int x, int y) {
        return damier[x][y];
    }

    public Cavalier getCavalier() {
        return cavalier;
    }

    public int getTaille() {
        return taille;
    }
}
