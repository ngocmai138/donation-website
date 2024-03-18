package donation.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import donation.entity.Donation;
import donation.entity.Role;
import donation.entity.User;

@Repository
@Transactional
public class DonationDAOImpl implements DonationDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addOrUpdateUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
	}

	@Override
	public List<Role> getRoles() {
		Session session = sessionFactory.getCurrentSession();
		Query<Role> query = session.createQuery("from Role",Role.class);
		List<Role> roles = query.getResultList();
		return roles;
	}

	@Override
	public Role getRole(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Role.class, id);
		
	}


	@Override
	public void deleteUser(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from User where id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@Override
	public User getUser(int userId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(User.class, userId);
	}

	@Override
	public List<Donation> getDonations(int pageSize, int pageNumber) {
		Session session = sessionFactory.getCurrentSession();
		Query<Donation> query = session.createQuery("from Donation",Donation.class);
		query.setFirstResult((pageNumber-1)*pageSize);
		query.setMaxResults(pageSize);
		List<Donation> donations = query.getResultList();
		return donations;
	}

	@Override
	public List<User> searchUser(String keyword, int pageSize, int pageNumber) {
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = session.createQuery("from User where email like:keyword or phoneNumber like:keyword",User.class);
		query.setParameter("keyword", "%"+keyword+"%");
		query.setFirstResult((pageNumber-1)*pageSize);
		query.setMaxResults(pageSize);
		List<User> users = query.getResultList();
		return users;
	}
	
	@Override
	public List<User> getUsers(int pageSize, int pageNumber) {
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = session.createQuery("from User ",User.class);
		query.setFirstResult((pageNumber-1)*pageSize);
		query.setMaxResults(pageSize);
		List<User> users = query.getResultList();
		return users;
	}

	@Override
	public Long getTotalUsers() {
		Session session = sessionFactory.getCurrentSession();
		Query<Long> query = session.createQuery("select count(1) from User",Long.class);
		return query.uniqueResult();
	}
	
	@Override
	public Long getTotalSearchUsers(String keyword) {
		Session session = sessionFactory.getCurrentSession();
		Query<Long> query = session.createQuery("select count(1) from User where email like:keyword or phoneNumber like:keyword",Long.class);
		query.setParameter("keyword", "%"+keyword+"%");
		return query.uniqueResult();
	}

	@Override
	public Long getTotalDonations() {
		Session session = sessionFactory.getCurrentSession();
		Query<Long> query = session.createQuery("select count(1) from Donation", Long.class);
		return query.uniqueResult();
	}

}
