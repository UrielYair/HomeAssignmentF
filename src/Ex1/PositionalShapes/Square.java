package Ex1.PositionalShapes;

import Ex1.Graphics.Color;
import Ex1.Shapes.Point;

public class Square extends PositionalShape{


    public Square(Point center, Color color, Ex1.Shapes.Square shape) {
        super(center, color, shape);
    }

    @Override
    public String toString() {
        return "PositionalSquare{" +
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
