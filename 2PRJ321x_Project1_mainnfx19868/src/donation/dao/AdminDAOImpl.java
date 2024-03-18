package donation.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import donation.entity.User;

@Transactional
@Repository
public class AdminDAOImpl implements AdminDAO{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<User> getUsers() {
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = session.createQuery("from User",User.class);
		List<User> users = query.getResultList();
		return users;
	}

}
