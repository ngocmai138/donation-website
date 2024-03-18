package donation.entity;

import java.util.Date;

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
@Table(name = "user_donation")
public class UserDonation {
	/**
	 * create table user_donation(id int(11) auto_increment,
							created varchar(100),
                            money int(11),
                            `name` varchar(100),
                            `status` int(11),
                            donation_id int(11),
                            user_id int(11),
                            primary key(`id`),
                            constraint `fk_userdonation_donation` foreign key(`donation_id`) references `donation`(id),
                            constraint `fk_userdonation_user` foreign key(`user_id`) references `user`(id));
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "created")
	private Date created;
	@Column(name = "money")
	private int money;
	@Column(name = "name")
	private String name;
	@Column(name = "status")
	private int status;
	@JoinColumn(name = "donation_id")
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Donation donation;
	@JoinColumn(name = "user_id")
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private User user;
	public UserDonation() {}
	public UserDonation(Date created, int money, String name, int status, Donation donation, User user) {
		this.created = created;
		this.money = money;
		this.name = name;
		this.status = status;
		this.donation = donation;
		this.user = user;
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
				+ status + ", donation=" + donation + ", user=" + user + "]";
	}
	
}
