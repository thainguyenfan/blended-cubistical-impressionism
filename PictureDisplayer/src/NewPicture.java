import java.util.List;
import java.util.Map;
import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JPanel;

public class NewPicture extends JPanel {

    private List<Map<String, Object>> fillCells;
    private int oldWidth;
    private int oldHeight;
    private static final int SCALE = 7;

    public NewPicture() {
        //
    }

    public NewPicture(List<Map<String, Object>> fillCells, int width, int height) {
        this.fillCells = fillCells;
        this.oldHeight = height;
        this.oldWidth = width;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // g.setColor(Color.WHITE);
        // BufferedImage image = new BufferedImage(oldWidth, oldHeight,
        // BufferedImage.TYPE_INT_RGB);
        // for (Map<String, Object> fillCell : fillCells) {
        // int x = (int) fillCell.get("x");
        // int y = (int) fillCell.get("y");
        // Color color = (Color) fillCell.get("color");

        // // int cellX = 7 + (x * 7);
        // // int cellY = 7 + (y * 7);
        // // g.setColor(color);
        // // g.fillRect(x, y, 7, 7);
        // try {
        // image.setRGB(x, y, 7, 7, new int[] { color.getRed(), color.getGreen(),
        // color.getBlue() }, 1, 1);
        // } catch (Exception ex) {
        // //
        // }
        // }
        // g.drawImage(image, 0, 0, this);

        for (Map<String, Object> fillCell : fillCells) {
            int x = (int) fillCell.get("x");
            int y = (int) fillCell.get("y");
            Color color = (Color) fillCell.get("color");

            g.setColor(color);
            g.fillRect(x, y, SCALE, SCALE);
        }
        g.setColor(Color.WHITE);
        g.drawRect(0, 0, oldWidth, oldHeight);

        // for (int i = SCALE; i <= oldWidth; i += SCALE) {
        // g.drawLine(i, SCALE, i, oldHeight + SCALE);
        // }

        // for (int i = SCALE; i <= oldHeight; i += SCALE) {
        // g.drawLine(SCALE, i, oldWidth + SCALE, i);
        // }

        setSize(oldWidth, oldHeight);

    }

}
