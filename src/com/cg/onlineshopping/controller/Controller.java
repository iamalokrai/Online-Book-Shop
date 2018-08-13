package com.cg.onlineshopping.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.onlineshopping.pojo.Books;
import com.cg.onlineshopping.services.BooksServices;
import com.cg.onlineshopping.services.BooksServicesImpl;

/**
 * Servlet implementation class Controller
 */
@WebServlet("*.app")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BooksServices services = new BooksServicesImpl();

	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		HttpSession session = request.getSession();
		System.out.println(action);
		double total = 0.0;
		switch (action) {
		// when addToCart is clicked
		case "/addToCart.app":
			int itemId = Integer.parseInt(request.getParameter("itemId"));
			Books book1 = null;
			Collection<Books> books = services.viewAllBooks();
			// for checking the bookId
			for (Books book : books) {
				if (book.getItemId() == itemId) {
					book1 = book;
				}

			}
			services.addNewBook(book1);
			Collection<Books> book = services.viewCart();
			session.setAttribute("flag", book);
			// to get total price of the cart
			for (Books b : book) {
				total = total + b.getPrice();
			}
			session.setAttribute("total", total);
			response.sendRedirect("home.app");
			break;
		// when cart details is clicked
		case "/cartdetails.app":
			books = services.viewCart();
			request.setAttribute("book", books);
			for (Books b : books) {
				total = total + b.getPrice();
			}
			session.setAttribute("total", total);
			session.setAttribute("flag", books);
			RequestDispatcher dispatcher = request.getRequestDispatcher("cartdetails.jsp");
			dispatcher.forward(request, response);
			break;
		// shows the list of the avaliable books
		case "/home.app":
			books = services.viewAllBooks();
			// System.out.println(books.size());
			request.setAttribute("books", books);
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
			break;
		// to delete the books from the cart
		case "/delete.app":
			services.deleteBooks(Integer.parseInt(request.getParameter("itemId")));
			response.sendRedirect("cartdetails.app");
			break;
		default:
			break;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
