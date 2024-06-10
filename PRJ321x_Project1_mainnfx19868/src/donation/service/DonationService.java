package donation.service;

import java.util.List;

import donation.entity.Donation;
import donation.entity.Role;
import donation.entity.User;
import donation.entity.UserDonation;

public interface DonationService {
	public List<User> getUsers();
	public List<Donation> getDonations();
	public List<Donation> getDonations(int pageSize, int pageNumber);
	public List<UserDonation> getUserDonations(int donationId);
	public List<UserDonation> getUserDonationsD(int donationId, int pageSize, int pageNumber);
	public List<UserDonation> getUserDonationsU(int userId, int pageSize, int pageNumber);
	public void addOrUpdateUser(User user);
	public void addOrUpdateDonation(Donation donation);
	public void addOrUpdateUserDonation(UserDonation userDonation);
	public List<Role> getRoles();
	public Role getRole(int id);
	public List<UserDonation> searchUserDonationD(int donationId, String keyword, int pageSize, int pageNumber);
	public List<UserDonation> searchUserDonationU(int userId, String keyword, int pageSize, int pageNumber);
	public void deleteUser(int id);
	public void deleteDonation(int id);
	public User getUser(int userId);
	public Donation getDonation(int donationId);
	public UserDonation getUserDonation(int userDonationId);
	public Long getTotalDonations();
	public Long getTotalUserDonations(int donationId);
	public Long getTotalSearchUserDonationD(int donationId, String keyword);
	public Long getTotalSearchUserDonationU(int userId, String keyword);
	public void updateDonationMoney(int userDonationId, boolean isAdding);
}
