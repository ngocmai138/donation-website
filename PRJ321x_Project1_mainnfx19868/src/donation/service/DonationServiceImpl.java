package donation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import donation.dao.DonationDAO;
import donation.entity.Donation;
import donation.entity.Role;
import donation.entity.User;
import donation.entity.UserDonation;

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
	@Override
	public void addOrUpdateDonation(Donation donation) {
		donationDAO.addOrUpdateDonation(donation);
	}
	@Override
	public List<Donation> searchDonation(String keyword, int pageSize, int pageNumber) {
		return donationDAO.searchDonation(keyword, pageSize, pageNumber);
	}
	@Override
	public Long getTotalSearchDonation(String keyword) {
		return donationDAO.getTotalSearchDonations(keyword);
	}
	@Override
	public void deleteDonation(int id) {
		donationDAO.deleteDonation(id);
		
	}
	@Override
	public Donation getDonation(int donationId) {
		return donationDAO.getDonation(donationId);
	}
	@Override
	public List<UserDonation> getUserDonationsD(int donationId, int pageSize, int pageNumber) {
		return donationDAO.getUserDonationsD(donationId, pageSize, pageNumber);
	}
	@Override
	public List<UserDonation> searchUserDonation(int donationId, String keyword, int pageSize, int pageNumber) {
		return donationDAO.searchUserDonation(donationId, keyword, pageSize, pageNumber);
	}
	@Override
	public Long getTotalUserDonations(int donationId) {
		return donationDAO.getTotalUserDonations(donationId);
	}
	@Override
	public Long getTotalSearchUserDonation(int donationId, String keyword) {
		return donationDAO.getTotalSearchUserDonations(donationId, keyword);
	}
	@Override
	public void addOrUpdateUserDonation(UserDonation userDonation) {
		donationDAO.addOrUpdateUserDonation(userDonation);
	}
	@Override
	public UserDonation getUserDonation(int userDonationId) {
		return donationDAO.getUserDonation(userDonationId);
	}
	@Override
	public List<UserDonation> getUserDonationsU(int userId, int pageSize, int pageNumber) {
		return donationDAO.getUserDonationsU(userId, pageSize, pageNumber);
	}

}
