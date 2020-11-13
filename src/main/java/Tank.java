import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-11-12 15:32
 */
public class Tank {
    int x ;
    int y ;
    Dir dir;
    TankFrame tf = null;
    private final static int SPEED = 5;
    boolean isMoving = false;
    BufferedImage img ;

    public Tank(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void paint(Graphics g) {

        switch (dir) {
            case RIGHT:
                img = ResourceMgr.tankR;
                break;
            case DOWN:
                img = ResourceMgr.tankD;
                break;
            case UP:
                img = ResourceMgr.tankU;
                break;
            case LEFT:
                img = ResourceMgr.tankL;
            default:
        }
        g.fillRect(x, y, 50, 50);
        g.drawImage(img, x, y, null);
        move();
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    private void move() {
        if (!isMoving) {
            return;
        }
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
    }

    public void fire() {
        tf.bullets.add(new Bullet(x + img.getWidth() / 2 , y + img.getHeight() / 2 , dir, this.tf));

    }
}
