/*
 * TriangleDrawer.java
 *
 *
 * This class can be given a SimpleTriangle object and draw it using a 
 * Graphics2D object.
 * 
 */
package simpledrawer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class TriangleDrawer implements drawInterface, scaleColour{

    private Shape triangle; // the triangle to be drawn

    public TriangleDrawer(Shape triangle) {
        this.triangle = triangle;
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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    // scale the brightness of the colour
        Color c = scaleColour(triangle.getColour(), currentBrightness);
        g2d.setColor(c);
        // set the thickness of the line
        g2d.setStroke(new BasicStroke(triangle.getThickness()));

        // draw the triangle
        g2d.drawLine(triangle.getVertices().get(0).x, 
                     triangle.getVertices().get(0).y, 
                     triangle.getVertices().get(1).x, 
                     triangle.getVertices().get(1).y);
        g2d.drawLine(triangle.getVertices().get(1).x, 
                     triangle.getVertices().get(1).y,
                     triangle.getVertices().get(2).x, 
                     triangle.getVertices().get(2).y);
        g2d.drawLine(triangle.getVertices().get(2).x, 
                     triangle.getVertices().get(2).y,
                     triangle.getVertices().get(0).x, 
                     triangle.getVertices().get(0).y);
    }
}
