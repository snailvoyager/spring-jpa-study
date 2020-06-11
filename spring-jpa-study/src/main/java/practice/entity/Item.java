package practice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="ITEM_SEQ_GENERATOR",
sequenceName="ITEM_SEQ",
initialValue=1,
allocationSize=1)
public class Item {
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE, 
			generator="ITEM_SEQ_GENERATOR")
	@Column(name="ITEM_ID")
	private Long id;
	
	private String name;
	private int price;
	private int stockQuantity;
	
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
}
