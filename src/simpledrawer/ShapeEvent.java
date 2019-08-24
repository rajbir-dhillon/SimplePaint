/*
 * ShapeEvent.java
 *
 *
 * Represents a shape event holding data for a shape read from file
 *
 */
package simpledrawer;

import java.awt.*;
import java.lang.reflect.Field;

public class ShapeEvent {

    // Shape start location
    private int xStart, yStart;
    // Shape end location
    private int xEnd, yEnd;
    // Shape characteristics
    private Color colour;
    private int thickness;
    // Type of shape e.g. line or oval
    private ShapeType shapeType;

    private String eventType; // currently always SHAPE

    public ShapeEvent(int xs, int ys, int xe, int ye, Color c, int t, ShapeType st, String eType) {
        xStart = xs;
        yStart = ys;
        xEnd = xe;
        yEnd = ye;
        colour = c;
        thickness = t;
        shapeType = st;
        eventType = eType;
    }

    /** 
     * Default constructor will create a default shape
     */
    public ShapeEvent() {
        this(0, 0, 0, 0, Color.BLACK, 0, ShapeType.LINE, "SHAPE");
    }

    public int getXStart() {
        return xStart;
    }

    public void setXStart(int xStart) {
        this.xStart = xStart;
    }

    public int getYStart() {
        return yStart;
    }

    public void setYStart(int yStart) {
        this.yStart = yStart;
    }

    public int getXEnd() {
        return xEnd;
    }

    public void setXEnd(int xEnd) {
        this.xEnd = xEnd;
    }

    public int getYEnd() {
        return yEnd;
    }

    public void setYEnd(int yEnd) {
        this.yEnd = yEnd;
    }

    public Color getColour() {
        return colour;
    }

    public void setColour(Color colour) {
        this.colour = colour;
    }

    /**
     * The method converts the string representation of the colour passed to it
     * to the corresponding static constant of class Color e.g. "red" will be
     * converted to Color.RED. The strange code is an example of "reflection".
     * See
     * http://stackoverflow.com/questions/5822384/getting-a-color-from-a-string-input
     * for more explanation.
     *
     * @param colour string representation of the Color required
     */
    public void setColourByString(String colour) {
        try {
            Color c;
            Field f = Color.class.getField(colour.toUpperCase());
            this.colour = (Color) f.get(null);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
            this.colour = Color.BLACK;
        }
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public ShapeType getShapeType() {
        return shapeType;
    }

    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return "ShapeEvent{" + "xStart=" + xStart + ", yStart=" + yStart + ", xEnd=" + xEnd + ", yEnd=" + yEnd + ", colour=" + colour + ", thickness=" + thickness + ", shapeType=" + shapeType + ", eventType=" + eventType + '}';
    }
    
}
