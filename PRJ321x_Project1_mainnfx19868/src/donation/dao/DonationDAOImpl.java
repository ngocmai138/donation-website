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
import donation.entity.StatusDonation;
import donation.entity.User;
import donation.entity.UserDonation;

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
		User user = session.get(User.class, id);
		user.setActive(false);
		session.update(user);
	}

	@Override
	public User getUser(int userId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(User.class, userId);
	}
	
	@Override
	public Donation getDonation(int donationId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Donation.class, donationId);
	}

	@Override
	public List<Donation> getDonations() {
		Session session = sessionFactory.getCurrentSession();
		Query<Donation> query = session.createQuery("from Donation where isActive = true",Donation.class);
		List<Donation> donations = query.getResultList();
		return donations;
	}
	@Override
	public List<User> getUsers() {
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = session.createQuery("from User where isActive=true",User.class);
		List<User> users = query.getResultList();
		return users;
	}
	
	@Override
	public void addOrUpdateDonation(Donation donation) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(donation);
	}


	@Override
	public void deleteDonation(int id) {
		Session session = sessionFactory.getCurrentSession();
		Donation donation = session.get(Donation.class,id);
		donation.setActive(false);
		session.update(donation);
	}
	@Override
	@Transactional
	public void addOrUpdateUserDonation(UserDonation userDonation) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(userDonation);
	}

	@Override
	public UserDonation getUserDonation(int userDonationId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(UserDonation.class, userDonationId);
	}
	@Override
	public List<UserDonation> getUserDonations(int donationId) {
		Session session = sessionFactory.getCurrentSession();
		Query<UserDonation> query = session.createQuery("from UserDonation where donation.id=:donationId order by status asc",UserDonation.class);
		query.setParameter("donationId", donationId);
		return query.getResultList();
	}

	@Override
	public void updateDonationMoney(int userDonationId, boolean isAdding) {
		Session session = sessionFactory.getCurrentSession();
		UserDonation userDonation = getUserDonation(userDonationId);
		Donation donation = getDonation(userDonation.getDonation().getId());
		double amount = userDonation.getMoney();
		if(isAdding) {
			donation.setMoney(donation.getMoney()+amount);
		}
		session.save(donation);
	}


}
