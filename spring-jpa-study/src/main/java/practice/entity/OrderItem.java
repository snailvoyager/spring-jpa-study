package practice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ORDER_ITEM")
public class OrderItem {

	@Id
	@Column(name="ORDER_ITEM_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ITEM_ID")		//상품과 다대일 단방향
	private Item item;
	
	@ManyToOne
	@JoinColumn(name="ORDER_ID")	//주문과 다대일 양방향. Owner
	private Order order;
	
	private int orderPrice;
	private int count;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public int getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
