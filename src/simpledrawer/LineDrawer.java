/*
 * LineDrawer.java
 *
 *
 * This class can be given a SimpleLine object and draw it using a 
 * Graphics2D object.
 * 
 */
package simpledrawer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class LineDrawer implements drawInterface, scaleColour {

    private Shape line; // the line to be drawn

    public LineDrawer(Shape line) {
        this.line = line;
    }

    /* The colour can be made brighter or darker.
     * currentBrightness is a number between 0.75 and 1.25
     * which is used to scale the brightness.  Each of the colours
     * (red, green and blue) have their values mutiplied by
     * currentBrightness.  If currentBrightness is < 1 the colours
     * will get darker.  If it is > 1 they will get brighter.
     * We have to be careful the values don't go over 255 as
     * that's the maximum allowed.
     */
    @Override
    public Color scaleColour(Color c, float currentBrightness) {
        // get the red amount and scale by currentBrightness
        int red = (int) (c.getRed() * currentBrightness);
        // check we've not gone over 255
        red = red > 255 ? 255 : red;
        // do the same for green and blue
        int green = (int) (c.getGreen() * currentBrightness);
        green = green > 255 ? 255 : green;
        int blue = (int) (c.getBlue() * currentBrightness);
        blue = blue > 255 ? 255 : blue;
        Color scaledColour = new Color(red, green, blue);

        return scaledColour;
    }

    @Override
    public void drawShape(Graphics2D g2d, float currentBrightness) {
        Color c = scaleColour(line.getColour(), currentBrightness);
        g2d.setColor(c);
        // set the thickness of the line
        g2d.setStroke(new BasicStroke(line.getThickness()));

        g2d.drawLine(line.getVertices().get(0).x, 
                     line.getVertices().get(0).y, 
                     line.getVertices().get(1).x, 
                     line.getVertices().get(1).y);
    }
}
