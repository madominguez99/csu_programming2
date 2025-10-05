package module4;

public class ShapeArray {
    public static void main(String[] args) {
        // Instantiate one triangle, one circle, one square
        Shape triangle = new Triangle(3, 4, 5);
        Shape circle = new Circle(5);
        Shape square = new Rectangle(4, 4); // square = rectangle with equal sides

        // Store in an array
        Shape[] shapeArray = {triangle, circle, square};

        // Loop and print
        for (Shape s : shapeArray) {
            System.out.println(s.toString());
        }
    }
}
