/*
 * DrawingPanel.java
 *
 *
 * A specialised JPanel used as the canvas for simple drawings.
 *
 * NOT created using the NetBeans GUI builder
 */
package simpledrawer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import static simpledrawer.ShapeType.*;

public class DrawingPanel extends JPanel {

    // current settings used when drawing
    private int currentThickness;
    private Color currentColor;
    private ShapeType currentShapeType;
    private float currentBrightness;
    private int currentRotation;

    private List<Point> currentPoints; // x and y points for shape being drawn

    // position of the latest click
    private int x, y;

    // A List that stores the shapes that appear on the JPanel
    private List<Shape> shapes;  // using a raw type - dangerous !!

    /* Default constructor.  Sets default values for line colour, thickness 
     * and shape type.
     */
    public DrawingPanel() {
        this(Color.BLACK, 5, ShapeType.LINE);
    }

    /* Constructor used to create a DrawingPanel with a
     * specified line colour, thickness and shape type
     */
    public DrawingPanel(Color c, int t, ShapeType st) {
        this.addMouseListener(new MouseWatcher());
        this.setBorder(BorderFactory.createLoweredBevelBorder());
        x = -1;
        y = -1;
        currentColor = c;
        currentThickness = t;
        currentShapeType = st;
        currentRotation = 0;
        currentBrightness = 1;

        // instantiate the ArrayList to store shapes
        shapes = new ArrayList<>();
    }

    /*
     * paint the drawing including all shapes drawn so far
     *
     * paintComponent() is invoked when repaint() is called and
     * when the GUI needs redrawing e.g. because it has been covered
     * by another window
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Graphics2D needed to set line thickness
        Graphics2D g2d = (Graphics2D) g;
        
        Stroke s = g2d.getStroke(); // save stroke to restore later

        // rotate the drawing by the current rotation amount
        double rotateTheta;
        rotateTheta = currentRotation * Math.PI / 180;
        g2d.rotate(rotateTheta, this.getWidth() / 2, this.getHeight() / 2);

        // Loop though the ArrayList drawing
        // all the shapes stored in it
        for (Shape aShape : shapes) {
             //draw the correct sort of shape
            if (aShape.getShapeType() == LINE) {
                LineDrawer ld = new LineDrawer((Shape) aShape);
                ld.drawShape(g2d, currentBrightness);
            } else {
                if (aShape.getShapeType() == OVAL) {
                    OvalDrawer ld = new OvalDrawer((Shape) aShape);
                    ld.drawShape(g2d, currentBrightness);
                } else {
                    if (aShape.getShapeType() == TRIANGLE) {
                        TriangleDrawer ld = new TriangleDrawer((Shape) aShape);
                        ld.drawShape(g2d, currentBrightness);
                    } else {
                        if (aShape.getShapeType() == QUADRILATERAL){
                            QuadrilateralDrawer ld = new QuadrilateralDrawer((Shape) aShape);
                            ld.drawShape(g2d, currentBrightness);
                        }
                    }
                }
            }
        }

        g2d.setStroke(s);  // restore saved stroke
        
        if (currentPoints != null) { // draw dot where line started
            g2d.setColor(currentColor);
            if (currentPoints.size() >= 1) {
                g2d.fillOval(currentPoints.get(0).x, currentPoints.get(0).y, 3, 3);
            }
            if (currentPoints.size() >= 2) {
                g2d.fillOval(currentPoints.get(1).x, currentPoints.get(1).y, 3, 3);
            }
            if (currentPoints.size() >= 3) {
                g2d.fillOval(currentPoints.get(2).x, currentPoints.get(2).y, 3, 3);
            }
            if (currentPoints.size() >= 4) {
                g2d.fillOval(currentPoints.get(3).x, currentPoints.get(3).y, 3, 3);
            }
        }
    }

    /**
     * @return the currentShapeType
     */
    public ShapeType getCurrentShapeType() {
        return currentShapeType;
    }

    /**
     * @param currentShapeType the currentShapeType to set
     */
    public void setCurrentShapeType(ShapeType currentShapeType) {
        this.currentShapeType = currentShapeType;
    }

    /**
     * @return the currentBrightness
     */
    public float getCurrentBrightness() {
        return currentBrightness;
    }

    /*
     * currentBrightness is passed in as a number in the range
     * 0 to 1.  In this class it needs to be in the range 0.75 to
     * 1.25 which is what the division by 2 and addition of
     * 0.75 achieves.
     */
    public void setCurrentBrightness(float currentBrightness) {
        this.currentBrightness = (currentBrightness / 2) + 0.75F;
        repaint();
    }

    /* MouseWatcher is an inner class used to handle the
     * mouse events generated by the user clicking on the drawing panel
     */
    private class MouseWatcher extends MouseAdapter {

        public void mousePressed(MouseEvent e) {
            // reset the rotation to 0 otherwise things get messy.
            currentRotation = 0;

            if (currentPoints == null) { // must be starting a new shape
                currentPoints = new ArrayList<>();
                Point firstPoint = new Point();
                firstPoint.x = e.getX();
                firstPoint.y = e.getY();
                currentPoints.add(firstPoint);
            } else { // shape must have already been started
                     // decide what to do based on the current shape
                Point nextPoint = new Point();
                nextPoint.x = e.getX();
                nextPoint.y = e.getY();
                currentPoints.add(nextPoint);
                ShapeFactory shapeFactory = new ShapeFactory();
                
                switch (currentShapeType) { 
                    case LINE: // Draw the line 
                        Shape Line = shapeFactory.getShape(currentPoints, currentColor, currentThickness, ShapeType.LINE);
                        shapes.add(Line);
                        currentPoints = null;
                        break;
                    case OVAL: // Draw the oval
                        Shape Oval = shapeFactory.getShape(currentPoints, currentColor, currentThickness, ShapeType.OVAL);
                        shapes.add(Oval);
                        currentPoints = null;
                        break;
                    case TRIANGLE: // May or may not have finished the triangle
                        if (currentPoints.size() == 3) { // 3 points so must be complete triangle
                            Shape Triangle = shapeFactory.getShape(currentPoints, currentColor, currentThickness, ShapeType.TRIANGLE);
                            shapes.add(Triangle);
                            currentPoints = null;
                            break;
                        }
                    case QUADRILATERAL:
                        if (currentPoints.size() == 4) { // 4 points so must be complete quadrilateral
                            Shape Quadrilateral = shapeFactory.getShape(currentPoints, currentColor, currentThickness, ShapeType.QUADRILATERAL);
                            shapes.add(Quadrilateral);
                            currentPoints = null;
                            break;
                        }
                }
            }
            repaint(); // causes paintComponent() to be called
        }
    }

    public void setCurrentThickness(int currentThickness) {
        this.currentThickness = currentThickness;
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }

    public void clearDisplay() {
        // Empty the ArrayList and clear the display.
        shapes.clear();
        repaint();
    }

    /* The whole drawing area can be rotated left or right.
     * The amount passed in is the amount in degrees to rotate.
     * A negative number roates to the left and a positive number to
     * the right
     */
    public void rotate(int amount) {
        currentRotation += amount;
        repaint();
    }

    public void setShapes(List shapes) {
        this.shapes = shapes;
    }
}
