package Ex1.PositionalShapes;

import Ex1.Graphics.Color;
import Ex1.Shapes.Point;
import Ex1.Shapes.Shape;

public abstract class PositionalShape {

    private Point center; // center of the shape to position on canvas/context.
    private Color color;
    private Shape shape;

    public PositionalShape(Point center, Color color, Shape shape) {
        this.center = center;
        this.color = color;
        this.shape = shape;
    }

    public Point getCenter () {
        return this.center;
    }
    public void setCenter(Point newCenter)  {
        this.moveCenterTo(newCenter);
    }
    public void moveCenterTo (Point newCenter) {
        center.setX(newCenter.getX());
        center.setY(newCenter.getY());
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    /***
     * abstract method to be implemented on subclasses.
     * @return string representation of PositionalShape
     */
    public abstract String toString();

    /***
     * abstract method to be implemented on subclasses.
     */
    public abstract void draw();

}
