/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chevauchée_fantastique_valentini;

/**
 *
 * @author stell
 */
public class Cavalier {
    private int x;
    private int y;

    public Cavalier(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void deplacer(int nx, int ny) {
        x = nx;
        y = ny;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
