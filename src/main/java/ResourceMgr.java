import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-11-13 15:54
 */
public class ResourceMgr {
    public static BufferedImage tankL,tankU,tankR, tankD;
    public static BufferedImage bulletL,bulletU,bulletR, bulletD;
    static {
        try {
            tankL = ImageIO.read(new File("src\\main\\resources\\images\\tankL.gif"));
            tankU = ImageIO.read(new File("src\\main\\resources\\images\\tankU.gif"));
            tankR = ImageIO.read(new File("src\\main\\resources\\images\\tankR.gif"));
            tankD = ImageIO.read(new File("src\\main\\resources\\images\\tankD.gif"));

            bulletL = ImageIO.read(new File("src\\main\\resources\\images\\bulletL.gif"));
            bulletR = ImageIO.read(new File("src\\main\\resources\\images\\bulletR.gif"));
            bulletU = ImageIO.read(new File("src\\main\\resources\\images\\bulletU.gif"));
            bulletD = ImageIO.read(new File("src\\main\\resources\\images\\bulletD.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
