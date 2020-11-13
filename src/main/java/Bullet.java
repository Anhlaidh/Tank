import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-11-12 16:15
 */
public class Bullet {
    private static final int SPEED = 10;
    private int x;
    private int y;
    public static int WIDTH = 5 , HEIGHT = 5;
    private Dir dir;
    private boolean live = true;
    TankFrame tf = null;
    public  BufferedImage img;

    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.dir = dir;
        switch (dir) {
            case RIGHT:
                img = ResourceMgr.bulletR;
                break;
            case DOWN:
                img = ResourceMgr.bulletD;
                break;
            case UP:
                img = ResourceMgr.bulletU;
                break;
            case LEFT:
                img = ResourceMgr.bulletL;
            default:
        }
        this.x = x- img.getWidth() / 2;
        this.y = y-img.getHeight() / 2;

        this.tf = tf;
    }

    public void paint(Graphics g) {

        if (!live) {
            tf.bullets.remove(this);
        }
        Color c = g.getColor();
        g.drawImage(img, x, y, null);
        move();
    }

    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case RIGHT:
                x += SPEED;
            default:
        }
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
            live = false;
        }
    }
}
