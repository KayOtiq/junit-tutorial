package io.kotiq;

public class MathUtils {
	
	public int add(int a, int b) {
		return a + b;
	}
	
	public double computeCircleArea (double radius) {
		//1.  return 0; - fail
		//2.  returm 3.14 * radius * radius; - fail
		return Math.PI * radius * radius; //Pass!
	
		
	}

}
