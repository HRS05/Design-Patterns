import java.util.ArrayList;
import java.util.List;


abstract class Shape {
    public int x;
    public int y;
    public String color;

    public Shape(){

    }
    public Shape(Shape shape){
        if(shape != null){
            this.x = shape.x;
            this.y = shape.y;
            this.color = shape.color;
        }
    }

    public abstract Shape clone();

    public boolean equals(Object shape) {
        if(! (shape instanceof Shape)) return false;
        Shape s = (Shape) shape;
        return (this.x == s.x && this.y == s.y && this.color == s.color);
    }
               
}                 

class Circle extends Shape{
    public int radius;
    public Circle(){

    }
    public Circle(Circle circle) {
        super(circle);
        if(circle != null) {
            this.radius = circle.radius;
        }
    }

    public Shape clone(){
        return new Circle(this);
    }

    public boolean equals(Object circle) {
        if(!(circle instanceof Circle) || !super.equals(circle)) return false;
        Circle c = (Circle) circle;
        return (this.radius == c.radius);
    }
}

class Rectangle extends Shape{
    public int height;
    public int width;
    public Rectangle(){

    }
    public Rectangle(Rectangle rectangle) {
        super(rectangle);
        if(rectangle != null) {
            this.height = rectangle.height;
            this.width = rectangle.width;
        }
    }

    public Shape clone(){
        return new Rectangle(this);
    }

    public boolean equals(Object rectangle) {
        if(!(rectangle instanceof Rectangle) || !super.equals(rectangle)) return false;
        Rectangle r = (Rectangle) rectangle;
        return (this.height == r.height && this.width == r.width);
    }
}


 class main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        List<Shape> shapesCopy = new ArrayList<>();

        Circle circle = new Circle();
        circle.x = 10;
        circle.y = 20;
        circle.radius = 15;
        circle.color = "red";
        shapes.add(circle);

        Circle anotherCircle = (Circle) circle.clone();
        shapes.add(anotherCircle);

        Rectangle rectangle = new Rectangle();
        rectangle.width = 10;
        rectangle.height = 20;
        rectangle.color = "blue";
        shapes.add(rectangle);

        cloneAndCompare(shapes, shapesCopy);
    }

    public static void cloneAndCompare(List<Shape> shapes, List<Shape> shapesCopy) {
        for (Shape shape : shapes) {
            shapesCopy.add(shape.clone());
        }

        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) != shapesCopy.get(i)) {
                System.out.println(i + ": Shapes are different objects (yay!)");
                if (shapes.get(i).equals(shapesCopy.get(i))) {
                    System.out.println(i + ": And they are identical (yay!)");
                } else {
                    System.out.println(i + ": But they are not identical (booo!)");
                }
            } else {
                System.out.println(i + ": Shape objects are the same (booo!)");
            }
        }
    }
}



















