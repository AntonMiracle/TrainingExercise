/**
 * Project: TrainingExercise Wolf.java
 */
package com.bam.pattern.factorymethod;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Wolf extends Animal {

	/* @see com.bam.pattern.factorymethod.Vital#currentHealth() */
	@Override
	public int currentHealth() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* @see com.bam.pattern.factorymethod.Vital#eat() */
	@Override
	public void eat() {
		System.out.println("Wolf eat");

	}

	/* @see com.bam.pattern.factorymethod.Vital#updatePic() */
	@Override
	public void updatePic() {
		// TODO Auto-generated method stub

	}

	/* @see com.bam.pattern.factorymethod.Vital#currentAge() */
	@Override
	public void currentAge() {
		// TODO Auto-generated method stub

	}

	/* @see com.bam.pattern.factorymethod.Vital#isAlive() */
	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}

}
