

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-11-13 15:25
 */
public class test {
    @Test
    public void test(){
        try {
            BufferedImage image = ImageIO.read(new File("src\\main\\resources\\images\\tank.png"));
            assertNotNull(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
