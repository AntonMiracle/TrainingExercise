/**
 * Project: Tasks Author.java
 */
package com.bam.task.task3.book;

import java.util.Random;

import com.bam.task.task3.generalclasses.Human;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Author {
	final private int	PRIME	= 7;
	private Human		human;
	Random				rnd		= new Random();

	public Author() {
		human = new Human();
	}

	private Author(Human human) {
		this.human = human;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected Author clone() throws CloneNotSupportedException {
		return new Author(human);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof Author) {
			Author newA = (Author) obj;
			if (newA.getHuman().equals(human)) {
				isEquals = true;
			}
		}
		return isEquals;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		human = null;
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return 5 * PRIME;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return human.toString();
	}

	/** Getter */
	public Human getHuman() {
		return human;
	}
}
