package edu.umsl.java.servlets.bookstore;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		// RequestDispatcher to forward client to bookstore home
		// page if no session exists or no books are selected
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/index.html");

		// if session does not exist, forward to index.html
		if (session == null)
			dispatcher.forward(request, response);

		// get books from session object
		List<BookBean> titles = (List<BookBean>) session.getAttribute("titles");

		// locate BookBean object for selected book
		Iterator<BookBean> iterator = titles.iterator();
		BookBean book = null;

		String isbn = request.getParameter("isbn");

		while (iterator.hasNext()) {
			book = (BookBean) iterator.next();

			if (isbn.equals(book.getISBN())) {

				BookBean newbook = reformatBookPrice(book);

				// save the book in a session attribute
				session.setAttribute("bookToAdd", newbook);
				dispatcher = request.getRequestDispatcher("singleBook.jsp");
				dispatcher.forward(request, response);
			}
		}

		// if book is not in list, forward to index.html
		if (book == null)
			dispatcher.forward(request, response);

	}

	private BookBean reformatBookPrice(BookBean bookOld) {
		BookBean bookNew = bookOld;

		String newprice = new DecimalFormat("0.00").format(bookOld.getPrice());
		bookNew.setFmprice(newprice);

		return bookNew;
	}

}
