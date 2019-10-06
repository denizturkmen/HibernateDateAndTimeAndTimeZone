package com.denizturkmen.Client;

import java.util.Date;
import java.util.TimeZone;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.denizturkmen.Entity.Book;
import com.denizturkmen.Entity.Person;
import com.denizturkmen.Util.HibernateUtil;

public class SaveClientEntity {
	public static void main(String[] args) {

//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		//Timezone jdbc bagımsız saat diliminden saklamak için
		try (Session session = HibernateUtil.getSessionFactory().withOptions().jdbcTimeZone(TimeZone.getTimeZone("UTC")).openSession()){
			Person author1= new Person();
			author1.setName("Deniz Türkmen");
			
			Date publishedDate = new Date();
			
			Book book1 = new Book();
			book1.setIsbn("84688");
			book1.setTitle("Hibernate");
			book1.setPublishedDate(publishedDate);
			book1.setAuthor(author1);
			
			Book book2 = new Book();
			book2.setIsbn("4233432");
			book2.setTitle("Java");
			book2.setPublishedDate(publishedDate);
			book2.setAuthor(author1);
			
			author1.getBooks().add(book1);
			author1.getBooks().add(book2);
			
			session.beginTransaction();
			session.saveOrUpdate(author1);
			session.getTransaction().commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}
}
