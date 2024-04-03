package donation.entity;

import java.sql.Date;

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
@Table(name="user_donation")
public class UserDonation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="created")
	private Date created;
	@Column(name="money")
	private int money;
	@Column(name="name")
	private String name;
	@Column(name="status")
	private int status;
	@JoinColumn(name="donation_id")
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE,
							CascadeType.REFRESH, CascadeType.PERSIST})
	private Donation donation;
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
							CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinColumn(name="user_id")
	private User user;
	
	public UserDonation() {
		this.status = 0;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Donation getDonation() {
		return donation;
	}
	public void setDonation(Donation donation) {
		this.donation = donation;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "UserDonation [id=" + id + ", created=" + created + ", money=" + money + ", name=" + name + ", status="
				+ status + ", donation=" + donation.getId() + ", user=" + user.getId() + "]";
	}
	public UserDonation(Date created, int money, String name, int status, Donation donation, User user) {
		this.created = created;
		this.money = money;
		this.name = name;
		this.status = status;
		this.donation = donation;
		this.user = user;
	}
	

}
