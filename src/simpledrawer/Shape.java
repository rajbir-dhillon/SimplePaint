/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpledrawer;

import java.awt.Color;
import java.awt.Point;
import java.util.List;

/**
 *
 * @author rajbir-dhillon
 */
public class Shape {
    private List<Point> vertices = null; // stores mouse click points
    private Color colour; //stores colour for shape
    private int thickness;
    private ShapeType shapeType; //stores shape type
    
    public Shape (List<Point> v, Color c, int t, ShapeType st) {
        vertices = v;
        colour = c;
        thickness = t;
        shapeType = st;
    }
    public List<Point> getVertices() {
        return vertices;
    }

    public void setVertices(List<Point> vertices) {
        this.vertices = vertices;
    }

    public Color getColour() {
        return colour;
    }

    public void setColour(Color colour) {
        this.colour = colour;
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
}
