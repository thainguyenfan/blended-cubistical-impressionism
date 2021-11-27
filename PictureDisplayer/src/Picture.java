import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

public class Picture {

    private String path;
    private long dots;
    private BufferedImage img;


    public Picture() {
    }

    public Picture(String path, long dots) {
        this.path = path;
        this.dots = dots;
        readFile();
    }

    public List<Map<String, Object>> getListPoints() {
        List<Map<String, Object>> points = new ArrayList<>();
        int width = this.img.getWidth();
        int height = this.img.getHeight();
        for (int i =0; i < dots; i++) {
            
            int x = (int) (Math.random() * width);
            int y = (int) (Math.random() * height);
            Map<String, Object> map = new HashMap<>();
            map.put("x", x);
            map.put("y", y);
            map.put("color", getColorEachPoint(x, y));
            // System.out.println("x : " + x + " | y: " + y + " random: " + random + " width: " + width + " height: " + height);
            // System.out.println(getColorEachPoint(x, y));
            points.add(map);
        }
        return points;
    }

    public Color getColorEachPoint(int x, int y) {

            int imagem = img.getRGB(x, y);
            return new Color(imagem, true);

    }

    public void readFile() {
        try {
            this.img = ImageIO.read(new File(path));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int getWidth() {
        return this.img.getWidth();
    }

    public int getHeight() {
        return this.img.getHeight();
    }
}
