package donation.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="donation")
public class Donation {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="code")
	private String code;
	@Column(name="is_active")
	private boolean isActive;
	@Column(name="created")
	private Date created;
	@Column(name="description")
	private String description;
	@Column(name="end_date")
	private Date endDate;
	@Column(name="money")
	private double money;
	@Column(name="name")
	private String name;
	@Column(name="organization_name")
	private String organizationName;
	@Column(name="phone_number")
	private String phoneNumber;
	@Column(name="start_date")
	private Date startDate;
	@Column(name="status")
	private int status;
	
	public Donation() {
		this.status = 0;
		this.isActive = true;
		this.created = new Date(System.currentTimeMillis());
	}
	
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	

	@Override
	public String toString() {
		return "Donation [id=" + id + ", code=" + code + ", isActive=" + isActive + ", created=" + created
				+ ", description=" + description + ", endDate=" + endDate + ", money=" + money + ", name=" + name
				+ ", organizationName=" + organizationName + ", phoneNumber=" + phoneNumber + ", startDate=" + startDate
				+ ", status=" + status + "]";
	}

	public Donation(String code, Date created, String description, Date endDate, double money, String name,
			String organizationName, String phoneNumber, Date startDate, int status) {
		this.code = code;
		this.created = created;
		this.description = description;
		this.endDate = endDate;
		this.money = money;
		this.name = name;
		this.organizationName = organizationName;
		this.phoneNumber = phoneNumber;
		this.startDate = startDate;
		this.status = status;
	}

	

}
