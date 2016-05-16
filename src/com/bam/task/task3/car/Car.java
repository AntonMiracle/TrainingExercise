/**
 * Project: Tasks Car.java
 */
package com.bam.task.task3.car;

import com.bam.task.task3.generalclasses.Price;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Car {
	private Integer			id;
	private Mark			mark;
	private Model			model;
	private Year			year;
	private Colour			colour;
	private Price			price;
	private RegistrationNum	regNum;

	public Car(int id) {
		this.id = new Integer(id);
		mark = new Mark();
		model = new Model();
		year = new Year();
		colour = new Colour();
		price = new Price();
		regNum = new RegistrationNum();
	}

	private Car(Integer id, Mark mark, Model model, Year year, Colour colour, Price price, RegistrationNum regNum) {
		this.id = new Integer(id);
		try {
			this.mark = mark.clone();
			this.model = model.clone();
			this.year = year.clone();
			this.colour = colour.clone();
			this.price = price.clone();
			this.regNum = regNum.clone();
		} catch (CloneNotSupportedException ex) {
			System.out.println(ex);
		}
	}

	/* @see java.lang.Object#clone() */
	@Override
	public Car clone() throws CloneNotSupportedException {
		return new Car(id, mark, model, year, colour, price, regNum);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Car) {
			Car newC = (Car) obj;
			if (newC.getId().equals(id) && newC.getMark().equals(mark) && newC.getModel().equals(model)
					&& newC.getYear().equals(year) && newC.getColour().equals(colour) && newC.getPrice().equals(price)
					&& newC.getRegNum().equals(regNum)) {
				return true;
			}
		}
		return false;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		id = null;
		mark = null;
		model = null;
		year = null;
		colour = null;
		price = null;
		regNum = null;
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 547;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Car [id=" + id + ", mark=" + mark + ", model=" + model + ", year=" + year + ", colour=" + colour
				+ ", price=" + price + ", regNum=" + regNum + "]";
	}

	/** Getter */
	public Integer getId() {
		return id;
	}

	/** Getter */
	public Mark getMark() {
		return mark;
	}

	/** Getter */
	public Model getModel() {
		return model;
	}

	/** Getter */
	public Year getYear() {
		return year;
	}

	/** Getter */
	public Colour getColour() {
		return colour;
	}

	/** Getter */
	public Price getPrice() {
		return price;
	}

	/** Getter */
	public RegistrationNum getRegNum() {
		return regNum;
	}

}
