package net.other;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import net.ngg.example.entity.exercise.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:applicationContext.xml", 
		"classpath*:applicationContext-web.xml",
		"classpath*:jdbc/applicationContext-jdbc.xml",
		"classpath*:persistence/applicationContext-hibernate.xml"})
@ActiveProfiles("test")  // Integration Testing with Environment Profiles
@WebAppConfiguration
public class SpringTransactionalExercise {

	@Autowired
    private SessionFactory sessionFactory;
	
	// remember: with @Transactional, spring opens up a transaction for us
	@Test
	@Transactional
	@Rollback(value=false) // in tests, spring rolls back the transaction instead of committing
	public void exercise_getCurrentSession_withTransaction() {
		// the sessionfactory will bind a session to the existing connection
		Session session = sessionFactory.getCurrentSession();
		session.save(new Employee("牛", "宏睿", "nhr407@163.com", "134****0062"));
		// we do not need to flush or commit manually!
		// remerber: Spring will close/commit the transaction for us
		// automatically when leaving this method. also, any outstanding 
		// changes will be flushed to the database when leaving this 
		// method....nice, huh?
	}
	
	@Test(expected = HibernateException.class)
//	@Ignore
	public void exercise_getCurrentSession_withoutTransaction() {
		sessionFactory.getCurrentSession();
	}
	
}
