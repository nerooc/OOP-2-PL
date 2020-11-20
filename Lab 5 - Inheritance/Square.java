public class Square extends Point {

    double side;

    public Square(double side, double x, double y) {
        super(x, y);
        this.side = side;
    }

    @Override
    public String getName() {
        return "Square";
    }

    @Override
    public String toString() {
        return "Corner = " + super.toString() + "; side = " + this.side;
    }

    @Override
    public double area() {
        return (this.side * this.side);
    }

    @Override
    public double volume() {
        return 0.0;
    }
}