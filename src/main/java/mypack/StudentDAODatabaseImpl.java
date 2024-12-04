package mypack;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class StudentDAODatabaseImpl implements StudentDAO {

	SessionFactory sf;
	Session session;
	Transaction transaction;
	
	public StudentDAODatabaseImpl() {
		sf = HibernateUtil.getSessionFactory();
		
	}
	@Override
	public void addStudent(Student st) {
		session = sf.openSession();
		transaction = session.beginTransaction();
		session.save(st);
		transaction.commit();
		
		session.close();
		
		System.out.println("Student Records get save in to database successfully");
		
	}

	@Override
	public List<Student> getListStudent() {
		
		session = sf.openSession();
		transaction = session.beginTransaction();
		Query<?> query = session.createQuery("From Student");
		List<Student> mylist = (List<Student>) query.list();
		System.out.println(mylist);
		
		//Student st = (Student) list.get(0);
		
		session.close();
		
		return mylist;
		
	}

}
