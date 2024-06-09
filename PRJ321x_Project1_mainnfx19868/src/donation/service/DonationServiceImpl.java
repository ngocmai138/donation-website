package donation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import donation.dao.DonationDAO;
import donation.entity.Donation;
import donation.entity.Role;
import donation.entity.User;
import donation.entity.UserDonation;

@Service
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
	public void deleteUser(int id) {
		donationDAO.deleteUser(id);
		
	}
	@Override
	public User getUser(int userId) {
		return donationDAO.getUser(userId);
	}
	@Override
	public List<Donation> getDonations() {
		return donationDAO.getDonations();
	}
	@Override
	public List<User> getUsers() {
		return donationDAO.getUsers();
	}
	@Override
	public void addOrUpdateDonation(Donation donation) {
		donationDAO.addOrUpdateDonation(donation);
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
	public List<UserDonation> getUserDonations(int donationId) {
		return donationDAO.getUserDonations(donationId);
	}
	@Override
	@Transactional
	public void addOrUpdateUserDonation(UserDonation userDonation) {
		donationDAO.addOrUpdateUserDonation(userDonation);
	}
	@Override
	public UserDonation getUserDonation(int userDonationId) {
		return donationDAO.getUserDonation(userDonationId);
	}
	@Override
	public void updateDonationMoney(int userDonationId, boolean isAdding) {
		donationDAO.updateDonationMoney(userDonationId, isAdding);
	}
}
