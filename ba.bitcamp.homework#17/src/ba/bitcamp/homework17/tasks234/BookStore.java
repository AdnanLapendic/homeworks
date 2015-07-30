package ba.bitcamp.homework17.tasks234;

import java.util.Arrays;

/**
 * Class BookStore represents one book store. Attributes are name, books and
 * numOfBooks. Class has all getters and setters, standard toString and equals
 * methods, and other methods created by author needed to successfully use this
 * class
 * 
 * @author adnan.lapendic
 *
 */
public class BookStore {
	private String name;
	private Book[] books;
	public static int numOfBooks;

	/**
	 * Constructor for object BookStore with attributes name and books
	 * 
	 * @param name
	 *            Name of BookStore
	 * @param books
	 *            Array of books
	 */
	public BookStore(String name, Book[] books) {
		this.name = name;
		this.books = books;

	}

	/**
	 * Get book store name
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set or change book store name
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get array of books
	 * 
	 * @return the books
	 */
	public Book[] getBooks() {
		return books;
	}

	/**
	 * Set array of books
	 * 
	 * @param books
	 *            the books to set
	 */
	public void setBooks(Book[] books) {
		this.books = books;
	}

	public int getNumOfBooks() {
		return numOfBooks;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookStore other = (BookStore) obj;
		if (!Arrays.equals(books, other.books))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * This method represent selling books from book store.
	 * 
	 * @param num
	 *            - Number of sold books
	 */
	public void sellBook(int num) {
		if (num <= numOfBooks) {
			numOfBooks -= num;
		} else {
			System.out.println("There is not enough books in stock");
		}
	}

	/**
	 * This method purchase more books to the book store
	 * 
	 * @param books
	 *            Number of purchased books
	 */
	public void purchaseMoreBooks(int books) {
		numOfBooks += books;
	}

	/**
	 * This method list all books
	 */
	public void listAllBooks() {
		for (int i = 0; i < books.length; i++) {
			System.out.println(books[i]);
		}
	}

	/**
	 * This method list all books from selected Author
	 * 
	 * @param a
	 */
	public void listAllBooksFromOneAuthor(Author a) {
		for (int i = 0; i < books.length; i++) {
			if (books[i].getAuthor().equals(a)) {
				System.out.println(books[i]);
			}
		}
	}

	@Override
	public String toString() {
		return "BookStore [name=" + name + ", books=" + Arrays.toString(books)
				+ "]";
	}

}
