package com.cg.onlineshopping.pojo;

//Class to store the details of the books
public class Books {
	int itemId;
	String name;
	String author;
	double price;
	String description;

	// Constructor of this class
	public Books(int itemId, String name, String author, double price, String description) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.author = author;
		this.price = price;
		this.description = description;
	}

	// Getters and setters
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
