package donation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import donation.dao.DonationDAO;
import donation.entity.Donation;
import donation.entity.Role;
import donation.entity.User;

@Repository
@Transactional
public class DonationServiceImpl implements DonationService{

	@Autowired
	private DonationDAO donationDAO;
	
	@Override
	public void addOrUpdateUser(User user) {
		donationDAO.addOrUpdateUser(user);
		
	}
	@Override
	@Transactional
	public List<Role> getRoles() {
		return donationDAO.getRoles();
	}
	@Override
	@Transactional
	public Role getRole(int id) {
		return donationDAO.getRole(id);
	}
	@Override
	public List<User> searchUser(String keyword, int pageSize, int pageNumber) {
		return donationDAO.searchUser(keyword, pageSize, pageNumber);
	}
	@Override
	public void deleteUser(int id) {
		donationDAO.deleteUser(id);
		
	}
	@Override
	public User getUser(int userId) {
		return donationDAO.getUser(userId);
	}
	@Override
	public List<Donation> getDonations(int pageSize, int pageNumber) {
		return donationDAO.getDonations(pageSize,pageNumber);
	}
	@Override
	public List<User> getUsers(int pageSize, int pageNumber) {
		return donationDAO.getUsers(pageSize, pageNumber);
	}
	@Override
	public Long getTotalUser() {
		return donationDAO.getTotalUsers();
	}
	@Override
	public Long getTotalSearchUsers(String keyword) {
		return donationDAO.getTotalSearchUsers(keyword);
	}
	@Override
	public Long getTotalDonations() {
		return donationDAO.getTotalDonations();
	}

}
