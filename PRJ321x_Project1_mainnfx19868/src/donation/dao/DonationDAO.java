package donation.dao;

import java.util.List;

import donation.entity.Donation;
import donation.entity.Role;
import donation.entity.User;

public interface DonationDAO {
	public List<User> getUsers(int pageSize, int pageNumber);
	public void addOrUpdateUser(User user);
	public List<Role> getRoles();
	public Role getRole(int id);
	public List<User> searchUser(String keyword, int pageSize, int pageNumber);
	public void deleteUser(int id);
	public User getUser(int userId);
	public List<Donation> getDonations(int pageSize, int pageNumber);
	public Long getTotalUsers();
	public Long getTotalSearchUsers(String keyword);
	public Long getTotalDonations();
}
