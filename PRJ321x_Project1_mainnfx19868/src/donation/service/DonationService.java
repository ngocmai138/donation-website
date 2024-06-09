package donation.service;

import java.util.List;

import donation.entity.Donation;
import donation.entity.Role;
import donation.entity.User;
import donation.entity.UserDonation;

public interface DonationService {
	public List<User> getUsers();
	public List<Donation> getDonations();
	public List<UserDonation> getUserDonations(int donationId);
	public void addOrUpdateUser(User user);
	public void addOrUpdateDonation(Donation donation);
	public void addOrUpdateUserDonation(UserDonation userDonation);
	public List<Role> getRoles();
	public Role getRole(int id);
	public void deleteUser(int id);
	public void deleteDonation(int id);
	public User getUser(int userId);
	public Donation getDonation(int donationId);
	public UserDonation getUserDonation(int userDonationId);
	public void updateDonationMoney(int userDonationId, boolean isAdding);
}
