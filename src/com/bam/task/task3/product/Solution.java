/**
 * Project: Tasks Solution.java
 */
package com.bam.task.task3.product;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Solution {
	private String solA, solB, solC, source;

	public Solution() {
		Random rnd = new Random();
		Product pro[] = new Product[rnd.nextInt(20) + 5];
		for (int i = 0; i < pro.length; pro[i++] = new Product(i));
		source = "\nSource list of product:\n" + Show.showProduct(pro);
		Product name = new Product(0);
		solA = "\nSolution A: list of product which name is " + name.getName()
				+ Show.showProduct(solA(pro, name.getName()));
		solB = "\nSolution B: list of product which name is " + name.getName() + ", and price less then "
				+ name.getPrice().toString() + Show.showProduct(solB(pro, name.getName(), name.getPrice()));
		solC = "\nSolution C: list of product which storage life upper then " + name.getStorageLife().toString()
				+ Show.showProduct(solC(pro, name.getStorageLife()));
	}

	public Solution(String source, String solA, String solB, String solC) {
		this.source = new String(source);
		this.solA = new String(solA);
		this.solB = new String(solB);
		this.solC = new String(solC);
	}

	private Product[] solA(Product list[], String productName) {
		int count = 0;
		for (int i = 0; i < list.length; i++) {
			count += list[i].getName().equals(productName) ? 1 : 0;
		}
		Product pro[] = new Product[count];
		count = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i].getName().equals(productName)) {
				try {
					pro[count++] = list[i].clone();
				} catch (CloneNotSupportedException ex) {
					System.out.println(ex);
				}
			}
		}
		return pro;
	}

	private Product[] solB(Product list[], String productName, Integer upperPrice) {
		Product newP[] = solA(list, productName);
		int count = 0;
		for (int i = 0; i < newP.length; i++) {
			count += newP[i].getPrice() < upperPrice ? 1 : 0;
		}
		Product pro[] = new Product[count];
		count = 0;
		for (int i = 0; i < newP.length; i++) {
			if (newP[i].getPrice() < upperPrice) {
				try {
					pro[count++] = newP[i].clone();
				} catch (CloneNotSupportedException ex) {
					System.out.println(ex);
				}
			}
		}
		return pro;
	}

	private Product[] solC(Product list[], Integer lessStorageLife) {
		int count = 0;
		for (int i = 0; i < list.length; i++) {
			count += list[i].getStorageLife() > lessStorageLife ? 1 : 0;
		}
		Product pro[] = new Product[count];
		count = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i].getStorageLife() > lessStorageLife) {
				try {
					pro[count++] = list[i].clone();
				} catch (CloneNotSupportedException ex) {
					System.out.println(ex);
				}
			}
		}
		return pro;
	}

	/* @see java.lang.Object#clone() */
	@Override
	public Solution clone() throws CloneNotSupportedException {
		return new Solution(source, solA, solB, solC);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Solution) {
			Solution newS = (Solution) obj;
			if (newS.getSolA().equals(solA) && newS.getSolB().equals(solB) && newS.getSolC().equals(solC)) {
				return true;
			}
		}
		return false;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		source = null;
		solA = null;
		solB = null;
		solC = null;
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 5;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return source + solA + solB + solC;
	}

	/** Getter */
	public String getSolA() {
		return solA;
	}

	/** Getter */
	public String getSolB() {
		return solB;
	}

	/** Getter */
	public String getSolC() {
		return solC;
	}

	/** Getter */
	public String getSource() {
		return source;
	}

}
