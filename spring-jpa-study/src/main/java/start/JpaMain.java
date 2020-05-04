package start;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");	//엔티티 매니저 팩토리 생성
		EntityManager em = emf.createEntityManager();		//엔티티 매니저 생성
		EntityTransaction tx = em.getTransaction();			//트랜잭션 획득
		
		try {
			tx.begin();
			logic(em);			//비지니스 로직
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}
	
	private static void logic(EntityManager em) {
		String id = "id1";
		Member member = new Member();
		member.setId(id);
		member.setUsername("AA");
		member.setAge(2);
		
		em.persist(member);		//등록
		
		member.setAge(20);		//수정
		
		Member findMember = em.find(Member.class, id);		//한건 조회
		System.out.println("findMember=" + findMember.getUsername() + ", age=" + findMember.getAge());
		
		List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();	//목록 조회
		System.out.println("members.size=" + members.size());
		
		em.remove(members);		//삭제
	}
}
