/**
 * Project: Tasks ShowBook.java
 */
package com.bam.task.task3.book;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
final public class ShowBook {
	final private int PRIME = 79;

	final static public String showOneBook(Book book) {
		String show = "";
		show += "\n--------------------" + "\n|     Book id      | " + book.getId().toString()
				+ "\n|      Title       | " + book.getTitle().toString() + "\n|     Author(s)    | "
				+ showAuthor(book.getAuthor()) + "\n| Publishing house | " + book.getPublishing()
				+ "\n| Publishing year  | " + book.getBirthDay().toString() + "\n| Numbers of pages | "
				+ book.getPage().toString() + "\n|      Price($)    | " + book.getPrice().toString()
				+ "\n|   Binding type   | " + book.getType() + "\n--------------------";
		return show;
	}

	final static public String showBooks(Book book[]) {
		String show = "";
		for (int i = 0; i < book.length; i++) {
			show += showOneBook(book[i]);
		}
		return show;
	}
	
	final static private String showAuthor(Author newA[]){
		String show = "";
		for (int i = 0; i < newA.length; i++){
			show += newA[i];
			show += i == newA.length - 1? " ": ", ";
		}		
		return show;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new ShowBook();
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
		return PRIME * 7;
	}

	/* @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Show book";
	}

}
