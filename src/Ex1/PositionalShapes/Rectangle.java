package Ex1.PositionalShapes;

import Ex1.Graphics.Color;
import Ex1.Shapes.Point;

public class Rectangle extends PositionalShape{


    public Rectangle(Point center, Color color, Ex1.Shapes.Rectangle shape) {
        super(center, color, shape);
    }

    @Override
    public String toString() {
        return "PositionalRectangle{" +
                "center=" + super.getCenter().toString() +
                ", color=" + super.getColor().toString() +
                ", shape=" + super.getShape().toString() +
                '}';
    }

    @Override
    public void draw() {
        System.out.println(this);
    }
}
