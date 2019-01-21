package Generics.Practice;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustListTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAdd() {
		CustList<Book> cl = new CustList<Book>();
		Book book1 = new Book(1, "Tin Goenda", "Rokib Hasan", "12/12/2012");
		Book book2 = new Book(2, "Harry Potter", "J.K. Rowling", "21/10/2001");
		Book book3 = new Book(3, "Game of Thrones", "George R R Martin", "22/05/2005");
		Book book4 = new Book(4, "The Vinci Code", "Dan Brown", "25/10/1995");
		cl.add(book1);
		assertTrue(cl.size() == 1 && cl.get(0).equals(book1));
		cl.add(book2);
		assertTrue(cl.size() == 2 && cl.get(1).equals(book2));
		cl.add(book3);
		assertTrue(cl.size() == 3 && cl.get(2).equals(book3));
		cl.add(book4);
		assertTrue(cl.size() == 4 && cl.get(3).equals(book4));

	}

	@Test
	public void testAddAt() {
		CustList<Book> cl = generateList();
		Book book1 = new Book(5, "Keplar 22B", "Md.Jafar Iqbal", "1/02/2014");
		int index = 2;
		cl.addAt(book1, index);
		assertTrue(cl.size() == 5 && cl.get(index).equals(book1));

	}

	@Test
	public void testGet() {
		CustList<Book> cl = generateList();
		Book book1 = new Book(3, "Game of Thrones", "George R R Martin", "22/05/2005");
		int index = 2;
		// cl.addAt(book1, index);
		assertEquals(book1,cl.get(index));
	}

	@Test
	public void testRemoveAt() {
		CustList<Book> cl = generateList();
		Book book1 = new Book(3, "Game of Thrones", "George R R Martin", "22/05/2005");
		int index = 2;
		cl.removeAt(index);
		assertTrue(cl.size() == 3 && !cl.get(index).equals(book1));
		assertNotEquals(book1,cl.get(index));
		assertEquals( new Book(4, "The Vinci Code", "Dan Brown", "25/10/1995"),cl.get(index));
	}

	@Test
	public void testRemoveByObject() {
		CustList<Book> cl = generateList();
		Book book1 = new Book(3, "Game of Thrones", "George R R Martin", "22/05/2005");
		// int index = 2;
		cl.removeByObject(book1);
		assertTrue(cl.size() == 3 && cl.search(book1) == -1);
		// assertNotEquals(cl.get(index), book1);
		// assertEquals(cl.get(index), new Book(4, "The Vinci Code", "Dan Brown",
		// "25/10/1995"));
	}

	@Test
	public void testSearch() {
		CustList<Book> cl = generateList();
		Book book1 = new Book(3, "Game of Thrones", "George R R Martin", "22/05/2005");
		// int index = 2;
		Book book2 = new Book(5, "Game ", "Martin", "2/01/2004");
		assertTrue(cl.search(book1) == 2);
		assertTrue(cl.search(book2) == -1);
	}

	@Test
	public void testReplaceByObject() {
		CustList<Book> cl = generateList();
		Book book1 = new Book(3, "Game of Thrones", "George R R Martin", "22/05/2005");
		// int index = 2;
		Book book2 = new Book(5, "Game ", "Martin", "2/01/2004");
		cl.replaceByObject(book1, book2);
		assertEquals(book2,cl.get(2));
		assertTrue(cl.search(book1) == -1);
	}

	@Test
	public void testRemoveFullList() {
		CustList<Book> cl = generateList();
		cl.removeFullList();
		assertTrue(cl.size() == 0);
	}
	@Test
	public void testAddAll() {
		CustList<Book> cl = generateList();
		CustList<Book> anotherCl =  new CustList<Book>();
		Book book1 = new Book(1, "Goenda", "Rokib Hasan", "12/12/2012");
		Book book2 = new Book(2, "Harry Potter", "J.K. Rowling", "21/10/2001");
		Book book3 = new Book(3, "Thrones", "Martin", "20/05/2005");
		Book book4 = new Book(4, "The Vinci Code", "Dan Brown", "25/10/1995");
		anotherCl.add(book1);
		anotherCl.add(book2);
		anotherCl.add(book3);
		anotherCl.add(book4);
		cl.addAll(anotherCl);
		assertTrue(cl.size()==8);
		assertEquals(book3, cl.get(6));
	}
	@Test
	public void testRemoveAll() {
		CustList<Book> cl = generateList();
		CustList<Book> anotherCl =  new CustList<Book>();
		Book book1 = new Book(1, "Tin Goenda", "Rokib Hasan", "12/12/2012");
		Book book4 = new Book(4, "The Vinci Code", "Dan Brown", "25/10/1995");
		anotherCl.add(book1);
		anotherCl.add(book4);
		cl.removeAll(anotherCl);
		assertTrue(cl.size()==2);
		assertEquals(new Book(2, "Harry Potter", "J.K. Rowling", "21/10/2001"), cl.get(0));
		assertEquals(new Book(3, "Game of Thrones", "George R R Martin", "22/05/2005"), cl.get(1));
		assertNotEquals(new Book(1, "Tin Goenda", "Rokib Hasan", "12/12/2012"), cl.get(0));
		//assertEquals(book3, cl.get(6));
	}

	public CustList<Book> generateList() {
		CustList<Book> cl = new CustList<Book>();
		Book book1 = new Book(1, "Tin Goenda", "Rokib Hasan", "12/12/2012");
		Book book2 = new Book(2, "Harry Potter", "J.K. Rowling", "21/10/2001");
		Book book3 = new Book(3, "Game of Thrones", "George R R Martin", "22/05/2005");
		Book book4 = new Book(4, "The Vinci Code", "Dan Brown", "25/10/1995");
		cl.add(book1);
		cl.add(book2);
		cl.add(book3);
		cl.add(book4);
		return cl;
	}

}
