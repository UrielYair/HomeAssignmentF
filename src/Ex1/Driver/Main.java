package Ex1.Driver;

import Ex1.Graphics.Color;
import Ex1.PositionalShapes.Circle;
import Ex1.PositionalShapes.PositionalShape;
import Ex1.PositionalShapes.Rectangle;
import Ex1.PositionalShapes.Square;
import Ex1.Shapes.Point;

public class Main {
    public static void main(String[] args) {
        PositionalShape circle = new Circle(
                new Point(2,1),
                Color.BLACK,
                new Ex1.Shapes.Circle(5));

        PositionalShape rectangle = new Rectangle(
                new Point(10,25),
                Color.GREEN,
                new Ex1.Shapes.Rectangle(5, 4));

        PositionalShape square = new Square(
                new Point(10,25),
                Color.BLUE,
                new Ex1.Shapes.Square(5));

        circle.draw();
        rectangle.draw();
        square.draw();



    }
}
