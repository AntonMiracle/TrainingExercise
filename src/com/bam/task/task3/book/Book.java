/**
 * Project: Tasks Book.java
 */
package com.bam.task.task3.book;

import java.util.Random;

import com.bam.task.task3.generalclasses.Price;

/**
 * @author Bondarenko Anton Michailovich
 * @version 1.0
 *
 */
public class Book {
	final private int		PRIME	= 599;
	private Integer			id;
	private BookName		title;
	private Author			author[];
	private PublishingHouse	publishing;
	private BookBirthDay	birthDay;
	private Page			page;
	private Price			price;
	private BindingType		type;
	Random					rnd		= new Random();

	public Book(int id) {
		this.id = new Integer(id);
		title = new BookName();
		author = randomAuthor();
		publishing = new PublishingHouse();
		birthDay = new BookBirthDay();
		page = new Page();
		price = new Price();
		type = new BindingType();
	}

	private Book(Integer id, BookName title, Author author[], PublishingHouse publishing, BookBirthDay birthDay,
			Page page, Price price, BindingType type) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.publishing = publishing;
		this.birthDay = birthDay;
		this.page = page;
		this.price = price;
		this.type = type;
	}

	private Author[] randomAuthor() {
		Author newA[] = new Author[rnd.nextInt(3) + 1];
		for (int i = 0; i < newA.length; newA[i++] = new Author());
		return newA;
	}

	/* @see java.lang.Object#clone() */
	@Override
	protected Book clone() throws CloneNotSupportedException {
		return new Book(id, title, author, publishing, birthDay, page, price, type);
	}

	/* @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		if (obj instanceof Book) {
			Book newB = (Book) obj;
			if (newB.getAuthor().length == author.length && newB.getId().equals(id) && newB.getTitle().equals(title)
					&& newB.getPublishing().equals(publishing) && newB.getBirthDay().equals(birthDay)
					&& newB.getPage().equals(page) && newB.getPrice().equals(price) && newB.getType().equals(type)) {
				int count = 0;
				for (int i = 0; i < author.length; i++) {
					count += newB.getAuthor()[i].equals(author[i]) ? 1 : 0;
				}
				if (count == author.length) {
					isEquals = true;
				}
			}
		}
		return isEquals;
	}

	/* @see java.lang.Object#finalize() */
	@Override
	protected void finalize() throws Throwable {
		id = null;
		title = null;
		author = null;
		publishing = null;
		birthDay = null;
		page = null;
		price = null;
		type = null;
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
		return "Book id : " + id + ", name \"" + title + "\", author(s) : " + author + ", publishing house :"
				+ publishing + ", year of publishing : " + birthDay + ", " + page + " pages, price : " + price
				+ ", binding type : " + type;
	}

	/** Getter */
	public Integer getId() {
		return id;
	}

	/** Getter */
	public BookName getTitle() {
		return title;
	}

	/** Getter */
	public Author[] getAuthor() {
		return author;
	}

	/** Getter */
	public PublishingHouse getPublishing() {
		return publishing;
	}

	/** Getter */
	public BookBirthDay getBirthDay() {
		return birthDay;
	}

	/** Getter */
	public Page getPage() {
		return page;
	}

	/** Getter */
	public Price getPrice() {
		return price;
	}

	/** Getter */
	public BindingType getType() {
		return type;
	}

}
