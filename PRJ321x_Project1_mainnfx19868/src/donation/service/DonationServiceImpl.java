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
	public List<Donation> getDonations(){
		return donationDAO.getDonations();
	}
	@Override
	public List<Donation> getDonations(int pageSize, int pageNumber) {
		return donationDAO.getDonations(pageSize,pageNumber);
	}
	@Override
	public List<User> getUsers() {
		return donationDAO.getUsers();
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
	public void deleteDonation(int id) {
		donationDAO.deleteDonation(id);
		
	}
	@Override
	public Donation getDonation(int donationId) {
		return donationDAO.getDonation(donationId);
	}
	@Override
	public List<UserDonation> getUserDonations(int donationId){
		return donationDAO.getUserDonations(donationId);
	}
	@Override
	public List<UserDonation> getUserDonationsD(int donationId, int pageSize, int pageNumber) {
		return donationDAO.getUserDonationsD(donationId, pageSize, pageNumber);
	}
	@Override
	public List<UserDonation> searchUserDonationD(int donationId, String keyword, int pageSize, int pageNumber) {
		return donationDAO.searchUserDonationD(donationId, keyword, pageSize, pageNumber);
	}
	@Override
	public Long getTotalUserDonations(int donationId) {
		return donationDAO.getTotalUserDonations(donationId);
	}
	@Override
	public Long getTotalSearchUserDonationD(int donationId, String keyword) {
		return donationDAO.getTotalSearchUserDonationsD(donationId, keyword);
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
	public List<UserDonation> getUserDonationsU(int userId, int pageSize, int pageNumber) {
		return donationDAO.getUserDonationsU(userId, pageSize, pageNumber);
	}
	@Override
	public List<UserDonation> searchUserDonationU(int userId, String keyword, int pageSize, int pageNumber) {
		return donationDAO.searchUserDonationU(userId, keyword, pageSize, pageNumber);
	}
	@Override
	public Long getTotalSearchUserDonationU(int userId, String keyword) {
		return donationDAO.getTotalSearchUserDonationsU(userId, keyword);
	}
	@Override
	public void updateDonationMoney(int userDonationId, boolean isAdding) {
		donationDAO.updateDonationMoney(userDonationId, isAdding);
	}

}
