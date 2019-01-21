package Generics.Practice;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Book {
	@NonNull
	int id;
	@NonNull
	String bookName;
	@NonNull
	String bookAuthor;
	@NonNull
	String publishedDate;
	
	@Override
	public String toString() {
		return "[id=" + id + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", publishedDate="
				+ publishedDate + "]\n";
	}

	@Override
	public boolean equals(Object arg0) {
		Book book = (Book) arg0;
		if(this.id == book.id && this.bookAuthor==book.bookAuthor && this.bookName==book.bookName && this.publishedDate==book.publishedDate) {
			return true;
		}
		return false;
	}
	
//	void display() {
//		System.out.println("ID : "+getId()+"; Book Name : "+getBookName()+";\nAuthor Name : "+getBookAuthor()+"; Published Date : "+getPublishedDate());
//	}
	
}
