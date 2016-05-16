/**
 * Project: Tasks Show.java
 */
package com.bam.task.task3.product;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Show {

	public static String showProduct(Product pro) {
		String show = "\n----------------" + "\n| Product id   | " + pro.getId().toString() + "\n| Name         | "
				+ pro.getName() + "\n| UPC          | " + pro.getUpc().toString() + "\n| Factory      | "
				+ pro.getFactory() + "\n| Price        | " + pro.getPrice().toString() + "\n| Storage life | "
				+ pro.getStorageLife().toString() + "\n| Count        | " + pro.getCount().toString()
				+ "\n----------------";
		return show;
	}

	public static String showProduct(Product pro[]) {
		String show = "";
		for (int i = 0; i < pro.length; i++) {
			show += showProduct(pro[i]);
		}
		return show;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected Show clone() throws CloneNotSupportedException {
		return new Show();
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
		return 7;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Show product";
	}

}
