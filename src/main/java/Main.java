import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-11-11 19:13
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame f = new TankFrame();
        for (int i = 0; i < 5; i++) {
            f.enemies.add(new Tank(50 + i * 100, 60, Dir.DOWN, f));
        }
        while (true) {
            Thread.sleep(50);
            f.repaint();
        }
    }
}
