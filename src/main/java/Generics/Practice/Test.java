package Generics.Practice;

public class Test {
	public static void main(String[] args) {
		 
		CustList<Book> cl = new CustList<Book>();
		cl.add(new Book(1, "Tin Goenda", "Rokib Hasan", "12/12/2012"));
		cl.add(new Book(2, "Harry Potter", "J.K. Rowling", "21/10/2001"));
		cl.add(new Book(3, "Game of Thrones", "George R R Martin", "22/05/2005"));
//		System.out.println(cl.get(0));
//		cl.removeAt(0);
//		System.out.println(cl.get(0));
		Book book1 = new Book(5, "Tin Goenda", "Rokib Hasan", "12/12/2012");
		//cl.removeByObject(book1);
		cl.replaceByObject(new Book(2, "Harry Potter", "J.K. Rowling", "21/10/2001"), book1);
		//System.out.println(cl.get(0));
		//cl.get(1);
		System.out.println(cl);
	}
}
