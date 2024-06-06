package donation.entity;

import java.sql.Date;
import java.time.LocalDate;

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
	private double money;
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
	@Column(name="text")
	private String text;
	
	public UserDonation() {
		this.status = 0;
		this.created = Date.valueOf(LocalDate.now());
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
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
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
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public UserDonation(Date created, double money, String name, int status, Donation donation, User user, String text) {
		this.created = created;
		this.money = money;
		this.name = name;
		this.status = status;
		this.donation = donation;
		this.user = user;
		this.text = text;
	}

	@Override
	public String toString() {
		return "UserDonation [id=" + id + ", created=" + created + ", money=" + money + ", name=" + name + ", status="
				+ status + ", donation=" + donation + ", user=" + user + ", text=" + text + "]";
	}


	

}
