import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-11-11 19:26
 */
public class TankFrame extends Frame {
    public static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;
    Tank tank = new Tank(50, 50, Dir.DOWN,this);
    List<Bullet> bullets = new ArrayList<Bullet>();

    public TankFrame() throws HeadlessException {
        setResizable(false);
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setTitle("Tank War");
        setVisible(true);

        //匿名内部类
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.addKeyListener(new MyKeyListener());

    }

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }
    // 自动调用 paint

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        tank.paint(g);
        g.setColor(c);
        c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("bullet nums:" + bullets.size(), 20, 60);
        g.setColor(c);
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }

    }

    private class MyKeyListener extends KeyAdapter {
        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                case KeyEvent.VK_SPACE:
                    tank.fire();
                    break;
                default:
                    return;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if (!bD && !bL && !bU && !bR) {
                tank.setMoving(false);
            } else {
                tank.setMoving(true);

                if (bL) {
                    tank.setDir(Dir.LEFT);
                }

                if (bU) {
                    tank.setDir(Dir.UP);
                }
                if (bR) {
                    tank.setDir(Dir.RIGHT);
                }
                if (bD) {
                    tank.setDir(Dir.DOWN);
                }

            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
                    return;
            }
            setMainTankDir();

        }
    }
}
