package com.denizturkmen.Client;


import java.util.List;


import org.hibernate.Session;

import com.denizturkmen.Entity.Book;
import com.denizturkmen.Entity.Person;
import com.denizturkmen.Util.HibernateUtil;

public class TestDate {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			long personId =  1L;
			Person person = session.get(Person.class, personId);
			System.out.println("Person details::::");
			System.out.println(person.getId()+"\t"+person.getName());
			System.out.println("List of book::::");
			List<Book> books = person.getBooks();
			for (Book book : books) {
				System.out.println(book.getId()+"\t"+book.getTitle()+"\t"+book.getIsbn());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}