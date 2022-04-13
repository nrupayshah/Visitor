package com.nrupay.shape;

import com.nrupay.model.Circle;
import com.nrupay.model.IShape;
import com.nrupay.model.Rectangle;
import com.nrupay.model.Triangle;
import com.nrupay.visitor.IShapeVisitor;
import com.nrupay.visitor.ShapeArea;

import java.util.Arrays;


public class ShapeAreaMain
{
    public static void main( String[] args ) {
    	IShape[] shapes = new IShape[]{
                new Circle(1.00D),
                new Rectangle(10.0,10.0),
                new Triangle(20.0, 10.0)
        };

        System.out.println("Value of total Area is " + totalArea(shapes));
    }

    private static double totalArea(IShape[] shapes) {
        IShapeVisitor<Double> shapeVisitor = new ShapeArea();
        return Arrays.stream(shapes).mapToDouble(shape -> (double) shape.accept(shapeVisitor)).sum();
    }
}
