class Point{
    double px;
    double py;
    public Point(double px, double py){
        this.px=px;
        this.py=py;
    }

    public double distance(Point K){
        double dis=Math.sqrt(((this.px-K.px)*(this.px-K.px))-((this.py-K.py)*(this.py-K.py)));
        return Math.abs(dis);
    }

}

abstract class Shape{
    String color;


    public Shape(String color) {
        this.color=color;
    }
    String getcolor(){
        return color;
    }

    abstract double perimeter();
    abstract double area();

    public boolean compareShape(Shape obj){
    return this.area() == obj.area() & this.perimeter() == obj.perimeter();

    }
}

class Triangle extends Shape{
    double side1;
    double side2;
    double side3;

    Triangle(String color,double side1,double side2,
                                        double side3){
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double perimeter(){
        double tperi=side1+side2+side3;
        return tperi;
    }
    @Override
    public double area(){
        double s = (side1 + side2 + side3) / 2;
        double x=(s - side1) * (s - side2) * (s - side3);
        return Math.sqrt(Math.sqrt (Math.abs(s*x)));
    }

}


class Rectangle extends Shape{
    double breadth;
    double length;
    Rectangle(String color,double length,double breadth){
        super(color);
        this.length=length;
        this.breadth=breadth;
    }

    @Override
    public double perimeter(){
        double rperi=2.0*(length+breadth);
        return rperi;
    }

    @Override

    public double area(){
        double rarea=length*breadth;
        return rarea;
    }

}
class Circle extends Shape{
    double r;
    Circle(String color,double r)
    {
        super(color);
        this.r=r;
    }
    @Override
    double perimeter(){
        double cperi=2.0*Math.PI*r;
        return cperi;
    }

    @Override
    double area(){
        double carea=Math.PI*r*r;
        return carea;
    }

}

public class Shapecalculation{
    public static void main(String[] args){
        Point p1=new Point(8.2, 2.4);
        Point p2=new Point(4.2, 1.4);
        Point p3=new Point(6.2, 3.4);

        double side1=p1.distance(p2);
        double side2=p1.distance(p3);
        double side3=p2.distance(p3);

        Shape tri1=new Triangle("Red", side1, side2, side3);
        Shape tri2=new Triangle("Blue", side2, side3, side1);
        Shape tri3=new Triangle("Orange", side3, side1, side2);
        // tri1.compareShape(tri2);
        System.out.println(" The area of 2nd Triangle is " + tri2.area());
        System.out.println(" The perimeter of 2nd Triangle is " + tri2.perimeter());
        System.out.println(" The comparison is " + tri2.compareShape(tri3));
        System.out.println("The color of Triangle is "+tri1.getcolor());
        System.out.println();


        Shape cir1=new Circle("Magenta", side1);
        Shape cir2=new Circle("S", side3);

        System.out.println(" The area of 1st Circle is " + cir1.area());
        System.out.println(" The perimeter of 1st Circle is " + cir1.perimeter());
        System.out.println(" The comparison is " + cir1.compareShape(cir2));
        System.out.println("The color of Circle is "+cir1.getcolor());
        System.out.println();


        Shape rec1=new Rectangle("G", side1, side2);
        Shape rec2=new Rectangle("pink", side3, side2);

        System.out.println(" The area of 1st Rectangle is " + rec1.area());
        System.out.println(" The perimeter of 1st Rectangle is " + rec1.perimeter());
        System.out.println(" The comparison is " + rec1.compareShape(rec2));
        System.out.println("The color of Rectangle is "+rec2.getcolor());




    }
}






