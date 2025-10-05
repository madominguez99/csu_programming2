package module4;

public abstract class Shape {
    // Abstract methods to be implemented by all subclasses
    public abstract double area();
    public abstract double perimeter();

    @Override
    public abstract String toString();
}
