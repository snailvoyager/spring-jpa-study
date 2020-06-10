package practice.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import practice.OrderStatus;

@Entity
@Table(name="ORDERS")
public class Order {
	@Id
	@Column(name="ORDER_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="MEMBER_ID")
	private MemberNew member;			//회원과 다대일 양방향 관계, Owner
	
	@OneToMany(mappedBy="order")	//주문 상품과 일대다 양방향
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MemberNew getMember() {
		return member;
	}

	public void setMember(MemberNew member) {
		if(this.member != null)
			this.member.getOrders().remove(this);	//기존 연관관계 삭제
		
		this.member = member;
		member.getOrders().add(this);
	}
	
	public void addOrderItem(OrderItem orderItem) {
		orderItems.add(orderItem);
		orderItem.setOrder(this);
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
}
