package com.pattern.iterator;

public interface MyIterator {
	// methods are by default public abstract
	
	// indicates whether there are more elements to iterate over
	boolean hasNext();

	// returns next element
	Object next();
}
