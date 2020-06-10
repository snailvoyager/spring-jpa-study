package practice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import practice.entity.Item;
import practice.entity.MemberNew;
import practice.entity.Order;
import practice.entity.OrderItem;

public class PracticeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");	//엔티티 매니저 팩토리 생성
		EntityManager em = emf.createEntityManager();		//엔티티 매니저 생성
		EntityTransaction tx = em.getTransaction();			//트랜잭션 획득
		
		try {
			tx.begin();
			logic(em);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}
	
	public static void logic(EntityManager em) {
		MemberNew member1 = new MemberNew();
		member1.setId(1L);
		member1.setName("member1");
		em.persist(member1);
		
		Item item1 = new Item();
		item1.setId(1L);
		item1.setName("item1");
		em.persist(item1);
		
		Order order = new Order();
		order.setId(1L);
		order.setMember(member1);		//주문한 회원
		em.persist(order);
		
		OrderItem orderItem = new OrderItem();
		orderItem.setId(1L);
		orderItem.setOrder(order);		//주문
		orderItem.setItem(item1);		//상품
		em.persist(orderItem);
		
		Order findOrder = em.find(Order.class, 1L);
		MemberNew findMember = findOrder.getMember();
		System.out.println(findMember.getName());
		
	}

}
