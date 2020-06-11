package practice.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="MEMBER_NEW")
@SequenceGenerator(name="MEMBER_SEQ_GENERATOR",
				sequenceName="MEMBER_SEQ",
				initialValue=1,
				allocationSize=1)
public class MemberNew {
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, 
					generator="MEMBER_SEQ_GENERATOR")
	@Column(name="MEMBER_ID")
	private Long id;
	
	private String name;
	
	private String city;
	private String street;
	private String zipcode;
	
	@OneToMany(mappedBy="member")
	private List<Order> orders = new ArrayList<Order>();	//주문과 일대다 양방향 관계

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
}
