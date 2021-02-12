package Ex1.Shapes;

public class Rectangle extends Shape{
    private int height;
    private int width;

    public Rectangle(int height, int width) {
        if (height <= 0 || width <= 0)
            throw new IllegalArgumentException("Rectangle edges must have positive values!");
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        if (height <= 0)
            throw new IllegalArgumentException("Rectangle height must have positive value!");
        this.height = height;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        if (width <= 0)
            throw new IllegalArgumentException("Rectangle width must have positive value!");
        this.width = width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
