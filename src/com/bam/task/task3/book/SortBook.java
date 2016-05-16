/**
 * Project: Tasks SortBook.java
 */
package com.bam.task.task3.book;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
final public class SortBook {
	final private int PRIME = 691;

	final public static Book[] sortByYear(Book book[], BookBirthDay year) {
		Book newB[] = new Book[countBook(book, year)];
		int index = 0;
		for (int i = 0; i < book.length; i++) {
			if (book[i].getBirthDay().equals(year)) {
				try {
					newB[index++] = book[i].clone();
				} catch (CloneNotSupportedException ex) {
					System.out.println(ex);
				}
			}
		}
		return newB;
	}

	final public static Book[] sortByAuthor(Book book[], Author author) {
		Book newB[] = new Book[countBook(book, author)];
		int index = 0;
		for (int i = 0; i < book.length; i++) {
			for (int j = 0; j < book[i].getAuthor().length; j++) {
				if (book[i].getAuthor()[j].equals(author)) {
					try {
						newB[index++] = book[i].clone();
					} catch (CloneNotSupportedException ex) {
						System.out.println(ex);
					}
					break;
				}
			}
		}
		return newB;
	}

	final public static Book[] sortByPublishingHouse(Book book[], PublishingHouse publishing) {
		Book newB[] = new Book[countBook(book, publishing)];
		int index = 0;
		for (int i = 0; i < book.length; i++) {
			if (book[i].getPublishing().equals(publishing)) {
				try {
					newB[index++] = book[i].clone();
				} catch (CloneNotSupportedException ex) {
					System.out.println(ex);
				}
			}
		}
		return newB;
	}

	final private static <T> int countBook(Book book[], T arg) {
		int count = 0;
		for (int i = 0; i < book.length; i++) {
			if (arg instanceof Author) {
				for (int j = 0; j < book[i].getAuthor().length; j++) {
					if (book[i].getAuthor()[j].equals(arg)) {
						count++;
						break;
					}
				}
			}
			if (arg instanceof PublishingHouse && book[i].getPublishing().equals(arg)) {
				count++;
			}
			if (arg instanceof BookBirthDay && book[i].getBirthDay().equals(arg)) {
				count++;
			}
		}
		return count;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected SortBook clone() throws CloneNotSupportedException {
		return new SortBook();
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
		return "Sorting books";
	}

}
