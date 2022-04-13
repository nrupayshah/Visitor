package com.nrupay.visitor;
import com.nrupay.model.Circle;
import com.nrupay.model.IShape;
import com.nrupay.model.Rectangle;
import com.nrupay.model.Triangle;

//An IShapeVisitor is a function over IShapes
public interface IShapeVisitor<R> extends IFunc<R, IShape<R>> {
	
	R visit(Circle circle);
	R visit(Triangle triangle);
	R visit(Rectangle rectangle);
	R visit(IShape<?> general);
}
