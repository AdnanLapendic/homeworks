package ba.bitcamp.homework17.tasks234;

import ba.bitcamp.homework17.task1.CampStringBuilder;
import ba.bitcamp.homework17.task5.Date;
import ba.bitcamp.homework17.task6.Cat;
import ba.bitcamp.homework17.task6.Dog;

/**
	 * Class used to test other classes and methods done for homework
	 * 
	 * @param args
	 */
public class Main {
	
	public static void main(String[] args) {

		Author a = new Author("Adnan", "adnan@bitcamp.ba", Author.MALE);
		Author b = new Author("Lapendic", "lapendic@bitcamp.ba", Author.MALE);
		// System.out.println(a);
		Book[] books = new Book[4];
		books[0] = new Book("Programming for dummies", 5, 20, a);
		books[1] = new Book("Java for beginners", 10, 20, b);
		books[2] = new Book("Rock'n'Roll", 100, 20, a);
		books[3] = new Book("Pursuit for happiness", 100, 20, b);

		BookStore bs = new BookStore("Knjizara", books);
		System.out.println(bs);
		bs.listAllBooks();
		bs.listAllBooksFromOneAuthor(a);

		// bs.purchaseMoreBooks(20);
		// System.out.println(bs.getNumOfBooks());
		// bs.sellBook(21);

		Date d2 = new Date(28, 1, 2015);
		d2.setMonth(2);
		System.out.println(d2);
		Date d = new Date(28, 2);
		System.out.println(d);

		d.dayPassed();
		System.out.println(d);

		d.monthPassed();
		System.out.println(d);
		System.out.println();

		Dog dog = new Dog("Fido", 17, "Mutt", "Dog");
		System.out.println(dog);
		Cat cat = new Cat("Lisa", 10, "Cat");
		System.out.println(cat);

		char[] characters = new char[5];
		characters[0] = 'A';
		characters[1] = 'D';
		characters[2] = 'N';
		characters[3] = 'A';
		characters[4] = 'N';
		
		CampStringBuilder csb = new CampStringBuilder(characters);
		csb.append(dog);
		
		
		
	}
}