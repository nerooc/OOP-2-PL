public class Cube extends Square {

    public Cube(double side, double x, double y) {
        //side is also depth
        super(side, x, y);
    }

    @Override
    public String getName() {
        return "Cube";
    }

    @Override
    public String toString() {
        return super.toString() + "; depth = " + this.side;
    }

    @Override
    public double area() {
        return super.area() * 6;
    }

    @Override
    public double volume() {
        return Math.pow(this.side, 3);
    }
}