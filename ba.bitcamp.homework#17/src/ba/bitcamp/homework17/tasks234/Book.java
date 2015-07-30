package ba.bitcamp.homework17.tasks234;

/**
 * This class represents a book. It has private attributes( name, price, author
 * and boolean isItAvelibe). It also has all getters, setters, to string and
 * equals method;
 * 
 * @author adnan.lapendic
 *
 */
public class Book {
	private String name;
	private int price;
	private int inStock;
	private Author author;

	/**
	 * Constructor for object Book with attributes name, price, inStock and
	 * author.
	 * 
	 * @param name
	 *            - Book name
	 * @param price
	 *            - Book price
	 * @param inStock
	 *            - Is it available
	 * @param author
	 *            - Author of the book
	 */
	public Book(String name, int price, int inStock, Author author) {
		this.name = name;
		this.price = price;
		this.inStock = inStock;
		this.author = author;
		if (price <= 0) {
			throw new IllegalArgumentException("Price can't be 0 or negative");
		} else if (inStock < 0) {
			throw new IllegalArgumentException("inStock can't be negative");
		}

	}

	/**
	 * Get book name
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set or change book name
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get book price
	 * 
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Set or change book price
	 * 
	 * @param price
	 *            - The price to set (can't be 0 or negative)
	 */
	public void setPrice(int price) {
		if (price <= 0) {
			throw new IllegalArgumentException("Price can't be 0 or lower");
		} else {
			this.price = price;
		}
	}

	/**
	 * How many books are in stock
	 * 
	 * @return the inStock
	 */
	public int getInStock() {
		return inStock;
	}

	/**
	 * Set or change number of books in stock
	 * 
	 * @param inStock
	 *            sets number of books in stock (can't be negative)
	 */
	public void setInStock(int inStock) {
		if (inStock < 0) {
			throw new IllegalArgumentException("inStock can't be negative ");
		} else {
			this.inStock = inStock;
		}
	}

	/**
	 * Get author
	 * 
	 * @return the author
	 */
	public Author getAuthor() {
		return author;
	}

	/**
	 * Set author
	 * 
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(Author author) {
		this.author = author;
	}

	public String toString() {
		String s = "";
		s += "Book name: " + name + "\n";
		s += "Price: " + price + "\n";
		s += "How many books are in stock: " + inStock + "\n";
		s += "Author { " + author + "}\n";
		return s;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (inStock != other.inStock)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		return true;
	}

}
