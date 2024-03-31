package donation.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="is_active")
	private boolean isActive;
	@Column(name="password")
	private String password;
	@Column(name="user_name")
	private String userName;
	@Column(name="full_name")
	private String fullName;
	@Column(name="status")
	private int status;
	@Column(name="email")
	private String email;
	@Column(name="phone_number")
	private String phoneNumber;
	@JoinColumn(name="role_id")
	@ManyToOne(cascade= { CascadeType.DETACH, CascadeType.MERGE,
						CascadeType.REFRESH,CascadeType.PERSIST})
	private Role role;
	
	public User() {
		this.status=1;
		this.isActive = true;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", isActive=" + isActive + ", password=" + password + ", userName=" + userName
				+ ", fullName=" + fullName + ", status=" + status + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", role=" + role + "]";
	}

	public User(boolean isActive, String password, String userName, String fullName, int status, String email,
			String phoneNumber, Role role) {
		this.isActive = isActive;
		this.password = password;
		this.userName = userName;
		this.fullName = fullName;
		this.status = status;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.role = role;
	}

	

	
}
