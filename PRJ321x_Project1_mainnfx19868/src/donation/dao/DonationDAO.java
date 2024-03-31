package donation.dao;

import java.util.List;

import donation.entity.Donation;
import donation.entity.Role;
import donation.entity.User;
import donation.entity.UserDonation;

public interface DonationDAO {
	public List<User> getUsers(int pageSize, int pageNumber);
	public List<Donation> getDonations(int pageSize, int pageNumber);
	public List<UserDonation> getUserDonationsD(int donationId, int pageSize, int pageNumber);
	public List<UserDonation> getUserDonationsU(int userId, int pageSize, int pageNumber);
	public void addOrUpdateUser(User user);
	public void addOrUpdateDonation(Donation donation);
	public void addOrUpdateUserDonation(UserDonation userDonation);
	public List<Role> getRoles();
	public Role getRole(int id);
	public List<User> searchUser(String keyword, int pageSize, int pageNumber);
	public List<Donation> searchDonation(String keyword, int pageSize, int pageNumber);
	public List<UserDonation> searchUserDonationD(int donationId, String keyword, int pageSize, int pageNumber);
	public List<UserDonation> searchUserDonationU(int userId, String keyword, int pageSize, int pageNumber);
	public void deleteUser(int id);
	public void deleteDonation(int id);
	public User getUser(int userId);
	public Donation getDonation(int donationId);
	public UserDonation getUserDonation(int userDonationId);
	public Long getTotalUsers();
	public Long getTotalDonations();
	public Long getTotalUserDonations(int donationId);
	public Long getTotalSearchUsers(String keyword);
	public Long getTotalSearchDonations(String keyword);
	public Long getTotalSearchUserDonationsD(int donationId, String keyword);
	public Long getTotalSearchUserDonationsU(int userId, String keyword);
}
