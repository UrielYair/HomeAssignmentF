package Ex1.Shapes;

public class Circle extends Shape{

    private int radius;

    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        if (radius <= 0)
            throw new IllegalArgumentException("Circle radius must have positive value!");
        this.radius = radius;
    }

    public Circle(int radius) {
        if (radius <= 0)
            throw new IllegalArgumentException("Circle radius must have positive value!");
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
