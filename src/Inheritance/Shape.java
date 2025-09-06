package Inheritance;

public class Shape {
    double pi=Math.PI;
    double area(double width, double height){
        return width*height;
    }
}
class Rectangle extends Shape{
    @Override
    double area(double width, double height) {
        return super.area(width, height);
    }
}
class Circle extends Shape{
    double radius;
    Circle(double radius){
        this.radius = radius;
        System.out.println("Area - "+area(radius));
    }
    double area(double radius) {
        return pi*radius * radius;
    }
}