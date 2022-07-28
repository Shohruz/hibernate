package org.hibernate.course;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
        		.addAnnotatedClass(Item.class)
//        		.addAnnotatedClass(User.class)
//        		.addAnnotatedClass(UserDetails.class)
//        		.addAnnotatedClass(Student.class)
//        		.addAnnotatedClass(University.class)
        		.addAnnotatedClass(Book.class)
        		.addAnnotatedClass(Reader.class)
        		.buildSessionFactory();
        
        Session session = null;
        // === Create ====
//        
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        Item item = new Item("Book", 90);
//        System.out.println(item);
//        session.save(item);
//        System.out.println(item);
//        session.getTransaction().commit();
        
        
        // === Read ===
//        Session session = null;
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        Item itemFromDB = session.get(Item.class, 1L);
//        System.out.println(itemFromDB);
//        session.getTransaction().commit();
        
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        Item itemFromDB = session.createQuery("SELECT i FROM Item i WHERE i.id = :id", Item.class)
//        		.setParameter("id", 6)
//        		.getSingleResult();
//        List<Item> itemFromDB = session.createQuery("SELECT i FROM Item i", Item.class).getResultList();
//        System.out.println(itemFromDB);
//        session.getTransaction().commit();
        
        
        // === Update ===
//        Session session = null;
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        Item itemFromDB = session.get(Item.class, 1L);
//        System.out.println(itemFromDB);
//        itemFromDB.setPrice(120);
//        itemFromDB.setTitle("Ball");
//        session.getTransaction().commit();

        // === Delete ===
//        Session session = null;
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        Item itemFromDB = session.get(Item.class, 1L);
//        session.remove(itemFromDB);
//        session.getTransaction().commit();
        
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        User user = session.get(User.class, 1L);
//        System.out.println(user);
//        System.out.println(user.getDetails());
//        System.out.println(user.getDetails().getUser());
//        session.getTransaction().commit();
//        try {
//	        session = sessionFactory.getCurrentSession();
//	        session.beginTransaction();
//	        Student student = session.get(Student.class, 1L);
//	        System.out.println(student);
//	        System.out.println(student.getUniversity());
//	        session.getTransaction().commit();
//        } catch (Exception ex) {
//        	System.out.println(ex);
//        } finally {
//        	sessionFactory.close();
//        	if (session != null)
//        		session.close();
//        }
        
        try {
        	session = sessionFactory.getCurrentSession();
        	session.beginTransaction();
        	Book book = session.get(Book.class, 2L);
        	System.out.println(book);
        	List<Reader> readers = book.getReaders();
        	for(Reader r : readers) {
        		System.out.println(r);
        	}
        	Reader reader = session.get(Reader.class, 1L);
        	System.out.println(reader);
        	List<Book> books = reader.getBooks();
        	for(Book b : books) {
        		System.out.println(b);
        	}
        	session.getTransaction().commit();
        } catch (Exception ex) {
        	System.out.println(ex);
        } finally {
        	sessionFactory.close();
        	if (session != null)
        		session.close();
        }
        
        sessionFactory.close();

    }

}