/**
 * Project: Tasks Product.java
 */
package com.bam.task.task3.product;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Product {
	private Integer	id, upc, price, storageLife, count;
	private String	name, factory;
	private String	NAMES[]		= new String[]{"Pasta","Meat","Potato","Apple"};
	private String	FACTORYS[]	= new String[]{"ATB","Digma","Rost","Klas"};

	Random rnd = new Random();

	public Product(int id) {
		this.id = new Integer(id);
		upc = randomUpc();
		name = NAMES[rnd.nextInt(NAMES.length)];
		factory = FACTORYS[rnd.nextInt(FACTORYS.length)];
		price = randomPrice();
		storageLife = randomStorageLife();
		count = randomCount();
	}

	public Product(Integer id, Integer upc, Integer price, Integer storageLife, Integer count, String name,
			String factory) {
		this.id = new Integer(id);
		this.upc = new Integer(upc);
		this.price = new Integer(price);
		this.storageLife = new Integer(storageLife);
		this.count = new Integer(count);
		this.name = new String(name);
		this.factory = new String(factory);
	}

	private Integer randomUpc() {
		String number = "";
		for (int i = 0; i < 6; i++) {
			number += new Integer(rnd.nextInt(10)).toString();
		}
		return Integer.valueOf(number);
	}

	public Integer randomPrice() {
		return new Integer(rnd.nextInt(10000) + 2000);
	}

	public Integer randomStorageLife() {
		return new Integer(rnd.nextInt(80) + 10);
	}

	public Integer randomCount() {
		return new Integer(rnd.nextInt(1000) + 10);
	}

	/* @see java.lang.Object#clone() */
	@Override
	public Product clone() throws CloneNotSupportedException {
		return new Product(id, upc, price, storageLife, count, name, factory);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Product) {
			Product newP = (Product) obj;
			if (newP.getId().equals(id) && newP.getCount().equals(count) && newP.getFactory().equals(factory)
					&& newP.getName().equals(name) && newP.getPrice().equals(price)
					&& newP.getStorageLife().equals(storageLife) && newP.getUpc().equals(upc)) {
				return true;
			}
		}
		return false;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		id = null;
		name = null;
		factory = null;
		upc = null;
		storageLife = null;
		count = null;
		rnd = null;
		price = null;
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 863;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Product [id=" + id + ", upc=" + upc + ", price=" + price + ", storageLife=" + storageLife + ", count="
				+ count + ", name=" + name + ", factory=" + factory + "]";
	}

	/** Getter */
	public Integer getId() {
		return id;
	}

	/** Getter */
	public Integer getUpc() {
		return upc;
	}

	/** Getter */
	public Integer getPrice() {
		return price;
	}

	/** Getter */
	public Integer getStorageLife() {
		return storageLife;
	}

	/** Getter */
	public Integer getCount() {
		return count;
	}

	/** Getter */
	public String getName() {
		return name;
	}

	/** Getter */
	public String getFactory() {
		return factory;
	}

	/** Getter */
	public String[] getNAMES() {
		return NAMES;
	}

	/** Getter */
	public String[] getFACTORYS() {
		return FACTORYS;
	}

}
