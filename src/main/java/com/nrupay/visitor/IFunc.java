package com.nrupay.visitor;

// Interface IFunc for Return Type R and Parameter type P
public interface IFunc <R, P> {
	R apply(P param);
}
