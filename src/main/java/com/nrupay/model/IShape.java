package com.nrupay.model;
import com.nrupay.visitor.IShapeVisitor;

public interface IShape<R> {

	R accept(IShapeVisitor<R> v);

}
