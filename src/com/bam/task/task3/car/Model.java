/**
 * Project: Tasks Model.java
 */
package com.bam.task.task3.car;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Model {
	private String			model;
	final private String	MODELS[]	= new String[]{"Model 0","Model 10","Star model"};
	Random					rnd			= new Random();

	public Model() {
		model = new String(MODELS[rnd.nextInt(MODELS.length)]);
	}

	public Model(String model) {
		this.model = model;
	}

	/* @see java.lang.Object#clone() */
	@Override
	public Model clone() throws CloneNotSupportedException {
		return new Model(model);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Model) {
			return ((Model) obj).getModel().equals(model) ? true : false;
		}
		return false;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		rnd = null;
		model = null;
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 907;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Model is " + model;
	}

	/** Getter */
	public String getModel() {
		return model;
	}

	/** Getter */
	public String[] getMODELS() {
		return MODELS;
	}

}
