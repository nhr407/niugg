package net.ngg.example.dao;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.ngg.example.entity.Account;

@Repository
public class AccountDaoImpl implements AccountDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Account findByEmail(String email) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Account a where a.email=?").setParameter(0, email);
		return (Account) query.uniqueResult();
	}

}
