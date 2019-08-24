/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpledrawer;

import java.awt.Color;
import java.awt.Point;
import java.util.List;
import static simpledrawer.ShapeType.*;

/**
 *
 * @author rajbir-dhillon
 */
public class ShapeFactory {
    //use getShape method to get object of type shape 
    public Shape getShape(List<Point> v, Color c, int t, ShapeType st){
        List<Point> currentPoints = v;
        Color currentColor = c;
        int currentThickness = t;
       
        if(st == null){
            return null;
        }
        switch (st) { 
            case LINE:
                return new Shape(currentPoints, currentColor, currentThickness, ShapeType.LINE);
            case OVAL:
                return new Shape(currentPoints, currentColor, currentThickness, ShapeType.OVAL);
            case TRIANGLE:
                return new Shape(currentPoints, currentColor, currentThickness, ShapeType.TRIANGLE);
            case QUADRILATERAL:
                return new Shape(currentPoints, currentColor, currentThickness, ShapeType.QUADRILATERAL);
      }
      return null;
   }
}
