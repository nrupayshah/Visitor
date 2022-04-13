package com.nrupay.shape;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import org.junit.Before;

import com.nrupay.exception.UnknownShapeException;
import com.nrupay.model.Circle;
import com.nrupay.model.IShape;
import com.nrupay.model.Rectangle;
import com.nrupay.model.Triangle;
import com.nrupay.visitor.IShapeVisitor;
import com.nrupay.visitor.ShapeArea;

/**
 * Unit test for ShapeArea.
 */
public class TestShapeArea 
{
	
	@Rule
    public ExpectedException exception = ExpectedException.none();
    
    private IShapeVisitor<Double> visitor;
    
    private class AbstractShape implements IShape<Double> {
    	public Double accept(IShapeVisitor<Double> v) {return v.visit(this);}
	}
	
	@Before
    public void init() {
		visitor = new ShapeArea();
    }

    @Test
	public void testAreaOfCircle() {
		Double area = visitor.apply(new Circle(1.00D));
		Double checkVal = Math.PI;
		Assert.assertEquals(checkVal, area);
	}
	
    @Test
    public void testAreaOfRectangle() {
		Double area = visitor.apply(new Rectangle(4.00D, 6.00D));
		Double checkVal = 24.00D;
		Assert.assertEquals(checkVal, area);
	}
	
    @Test
	public void testAreaOfTriangle() {
		Double area = visitor.apply(new Triangle(10.00D, 7.00D));
		Double checkVal = 35.00D;
		Assert.assertEquals(checkVal, area);
	}
    
    @Test
	public void testExceptionWhenCircleRadiusIsNegative() {
    	Double radius = -1.00;
    	exception.expect(IllegalArgumentException.class);
    	exception.expectMessage("Radius " + radius + " cannot be less than or equal to zero");
		visitor.apply(new Circle(radius));
	}
    
    @Test
	public void testExceptionWhenRectangleWidthIsNegative() {
    	Double width = -10.00;
    	Double height = 20.00;
    	exception.expect(IllegalArgumentException.class);
    	exception.expectMessage("Rectangle width : " + width + " cannot be less than or equal to zero");
		visitor.apply(new Rectangle(width, height));
	}
    
    @Test
	public void testExceptionWhenRectangleHeightIsNegative() {
    	Double width = 10.00;
    	Double height = -20.00;
    	exception.expect(IllegalArgumentException.class);
    	exception.expectMessage("Rectangle height : " + height + " cannot be less than or equal to zero");
		visitor.apply(new Rectangle(width, height));
	}
    
    @Test
	public void testExceptionWhenTriangleBaseIsNegative() {
    	Double base = -10.00;
    	Double height = 20.00;
    	exception.expect(IllegalArgumentException.class);
    	exception.expectMessage("Triangle base : " + base + " cannot be less than or equal to zero");
		visitor.apply(new Triangle(base, height));
	}
    
    @Test
	public void testExceptionWhenTriangleHeightIsNegative() {
    	Double base = 10.00;
    	Double height = -20.00;
    	exception.expect(IllegalArgumentException.class);
    	exception.expectMessage("Triangle height : " + height + " cannot be less than or equal to zero");
		visitor.apply(new Triangle(base, height));
	}
    
    @Test
   	public void testExceptionWhenShapeClassIsUnknown() {
    	AbstractShape aShape = new AbstractShape();
       	exception.expect(UnknownShapeException.class);
       	exception.expectMessage("Shape with name: " + aShape.getClass().getCanonicalName() + " is undefined!!");
   		visitor.apply(aShape);
   	}

}
