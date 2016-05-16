/**
 * Project: Tasks SolutionBook.java
 */
package com.bam.task.task3.book;

import java.util.Random;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class SolutionBook {
	final private int	PRIME	= 619;
	private Book		book[];
	private String		solutionA;
	private String		solutionB;
	private String		solutionC;
	private String		show;
	Random				rnd		= new Random();

	public SolutionBook() {
		book = randomBooks();
		show = ShowBook.showBooks(book);
		solutionA = solutionA(book);
		solutionB = solutionB(book);
		solutionC = solutionC(book);

	}

	private SolutionBook(Book book[], String solutionA, String solutionB, String solutionC, String show) {
		this.book = book;
		this.solutionA = solutionA;
		this.solutionB = solutionB;
		this.solutionC = solutionC;
		this.show = show;
	}

	private Book[] randomBooks() {
		Book newB[] = new Book[rnd.nextInt(30) + 1];
		for (int i = 0; i < newB.length; i++) {
			newB[i] = new Book(i + 1);
		}
		return newB;
	}

	private String solutionA(Book book[]) {
		Author newA = new Author();
		String solution = "Book which has author \"" + newA.toString() + "\"";
		Book newB[] = SortBook.sortByAuthor(book, newA);
		solution += "\n" + ShowBook.showBooks(newB);
		return solution;
	}

	private String solutionB(Book book[]) {
		PublishingHouse newP = new PublishingHouse();
		String solution = "Book which publishing with \"" + newP.toString() + "\"";
		Book newB[] = SortBook.sortByPublishingHouse(book, newP);
		solution += "\n" + ShowBook.showBooks(newB);
		return solution;
	}

	private String solutionC(Book book[]) {
		BookBirthDay year = new BookBirthDay();
		String solution = "Book which publishing year is \"" + year.toString() + "\"";
		Book newB[] = SortBook.sortByYear(book, year);
		solution += "\n" + ShowBook.showBooks(newB);
		return solution;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected SolutionBook clone() throws CloneNotSupportedException {
		return new SolutionBook(book, solutionA, solutionB, solutionC, show);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof SolutionBook) {
			SolutionBook newS = (SolutionBook) obj;
			if (newS.getBook().length == book.length && newS.getShow().equals(show)
					&& newS.getSolutionA().equals(solutionA) && newS.getSolutionB().equals(solutionB)
					&& newS.getSolutionC().equals(solutionC)) {
				int count = 0;
				for (int i = 0; i < book.length; i++) {
					count += newS.getBook()[i].equals(book[i]) ? 1 : 0;
				}
				isEquals = count == book.length ? true : false;
			}
		}
		return isEquals;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		book = null;
		solutionA = null;
		solutionB = null;
		solutionC = null;
		show = null;
		rnd = null;
		super.finalize();
	}

	/* @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		return PRIME * 7;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Library has next book :\n" + show + "" + "\nSolutionA :\n" + solutionA + "" + "\nSolutionB :\n"
				+ solutionB + "\nSolutionC :\n" + solutionC;
	}

	/** Getter */
	public Book[] getBook() {
		return book;
	}

	/** Getter */
	public String getSolutionA() {
		return solutionA;
	}

	/** Getter */
	public String getSolutionB() {
		return solutionB;
	}

	/** Getter */
	public String getSolutionC() {
		return solutionC;
	}

	/** Getter */
	public String getShow() {
		return show;
	}

}
