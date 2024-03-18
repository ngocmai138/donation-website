package donation.entity;

import java.util.Date;

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
	@Column(name="created")
	private Date created;
	@Column(name="end_date")
	private Date endDate;
	@Column(name="money")
	private int money;
	@Column(name="name")
	private String name;
	@Column(name="organization_name")
	private String organizationName;
	@Column(name="start_date")
	private Date startDate;
	@Column(name="status")
	private int status;
	
	public Donation() {}
	
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
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
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
		return "Donation [id=" + id + ", code=" + code + ", created=" + created + ", endDate=" + endDate + ", money="
				+ money + ", name=" + name + ", organizationName=" + organizationName + ", startDate=" + startDate
				+ ", status=" + status + "]";
	}
	public Donation(String code, Date created, Date endDate, int money, String name, String organizationName,
			Date startDate, int status) {
		this.code = code;
		this.created = created;
		this.endDate = endDate;
		this.money = money;
		this.name = name;
		this.organizationName = organizationName;
		this.startDate = startDate;
		this.status = status;
	}
	

}
