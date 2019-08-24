package simpledrawer;

/**
 * Interface implemented by classes that want to be notified of ShapeEvents
 * 
 */
public interface ShapeEventListener {
    public void processShapeEvent(Object originator, ShapeEvent se);
    
}
