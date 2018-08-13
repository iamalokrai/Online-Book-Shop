package com.cg.onlineshopping.services;

import java.util.Collection;

import com.cg.onlineshopping.pojo.Books;

//Interface having methods
public interface BooksServices {

	void addNewBook(Books book);

	Collection<Books> viewAllBooks();

	Collection<Books> viewCart();

	void deleteBooks(int itemID);
}
