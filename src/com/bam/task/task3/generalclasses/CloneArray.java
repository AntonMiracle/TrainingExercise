/**
 * Project: Tasks CloneArray.java
 */
package com.bam.task.task3.generalclasses;

import com.bam.task.task3.car.Car;
import com.bam.task.task3.circle.Circle;
import com.bam.task.task3.phone.Phone;
import com.bam.task.task3.product.Product;
import com.bam.task.task3.quadrangle.Quadrangle;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
final public class CloneArray {
	final private int PRIME = 811;

	final static public Circle[] circle(Circle c[]) {
		Circle newC[] = new Circle[c.length];
		for (int i = 0; i < c.length; i++) {
			try {
				newC[i] = c[i].clone();
			} catch (CloneNotSupportedException ex) {
				System.out.println(ex);
			}
		}
		return newC;
	}

	final static public Phone[] phone(Phone phone[]) {
		Phone newP[] = new Phone[phone.length];
		for (int i = 0; i < phone.length; i++) {
			try {
				newP[i] = phone[i].clone();
			} catch (CloneNotSupportedException ex) {
				System.out.println(ex);
			}
		}
		return newP;
	}

	final static public Quadrangle[] quadrangle(Quadrangle q[]) {
		Quadrangle newQ[] = new Quadrangle[q.length];
		for (int i = 0; i < q.length; i++) {
			try {
				newQ[i] = q[i].clone();
			} catch (CloneNotSupportedException ex) {
				System.out.println(ex);
			}
		}
		return newQ;
	}

	final static public Car[] car(Car car[]) {
		Car newC[] = new Car[car.length];
		for (int i = 0; i < car.length; i++) {
			try {
				newC[i] = car[i].clone();
			} catch (CloneNotSupportedException ex) {
				System.out.println(ex);
			}
		}
		return newC;
	}

	final static public Product[] product(Product pro[]) {
		Product newP[] = new Product[pro.length];
		for (int i = 0; i < pro.length; i++) {
			try {
				newP[i] = pro[i].clone();
			} catch (CloneNotSupportedException ex) {
				System.out.println(ex);
			}
		}
		return newP;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected CloneArray clone() throws CloneNotSupportedException {
		return new CloneArray();
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		return false;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return PRIME;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Clone array";
	}

}
