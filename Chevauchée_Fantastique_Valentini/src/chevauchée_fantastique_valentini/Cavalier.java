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
