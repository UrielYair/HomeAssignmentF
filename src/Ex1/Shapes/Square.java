package Ex1.Shapes;

public class Square extends Rectangle{

    public Square(int edge) {
        super(edge, edge);
        if (edge <= 0)
            throw new IllegalArgumentException("Square edge must have positive value!");
    }

    public int getEdge() {
        return super.getHeight();
    }
    public void setEdge(int edge) {
        if (edge <= 0)
            throw new IllegalArgumentException("Square edge must have positive value!");
        super.setHeight(edge);
        super.setWidth(edge);
    }

    @Override
    public String toString() {
        return "Square{" +
                ", edge=" + getEdge() +
                '}';
    }
}
