package donation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import donation.dao.AdminDAO;
import donation.entity.User;

@Repository
@Transactional
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDAO adminDAO;
	@Override
	public List<User> getUsers() {
		return adminDAO.getUsers();
	}

}
