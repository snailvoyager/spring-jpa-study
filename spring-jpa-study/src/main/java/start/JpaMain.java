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
			testDetached(em);			//비지니스 로직
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}
	
	private static void testDetached(EntityManager em) {
		Member member = new Member();
		member.setId("memberA");
		member.setUsername("memberA");
		
		em.persist(member); 	//영속성 컨텍스트 저장
		em.detach(member); 		//특정 엔티티를 영속성 컨텍스트에서 분리
		
		Member memberB = em.find(Member.class, "member1");		//영속성 컨텍스트 저장
		
		em.clear();		//영속성 컨텍스트 초기화
		
		memberB.setUsername("memberB");		//엔티티가 준영속 상태로 반영되지 않음
	}
	
	private static void identity(EntityManager em) {	//동일성 비교
		Member a = em.find(Member.class, "member1");
		Member b = em.find(Member.class, "member1");	//영속성 컨텍스트는 1차 캐시에 있는 동일 엔티티 인스턴스를 반환
		
		System.out.println(a == b);			//동일 인스턴스
	}
	
	private static void logic(EntityManager em) {
		String id = "member1";
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
		
		//em.remove(members);		//삭제
	}
}
