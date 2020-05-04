package chap03;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import start.Member;

public class ExamMerge {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member member = createMember("memberA", "회원1");		//영속성 등록
		member.setUsername("회원명변경");		//준영속 상태에서 변경, DB에 반영 안됨
		mergeMember(member);
	}
	
	static Member createMember(String id, String username) {
		EntityManager em1 = emf.createEntityManager();
		EntityTransaction tx1 = em1.getTransaction();
		tx1.begin();
		
		Member member = new Member();
		member.setId(id);
		member.setUsername(username);
		member.setAge(20);
		
		em1.persist(member);
		tx1.commit();
		
		em1.close(); 	//영속성 컨텍스트 종료, 전체 준영속 상태 변경
		
		return member;
	}
	
	static void mergeMember(Member member) {
		EntityManager em2 = emf.createEntityManager();		//새로운 영속성 컨텍스트
		EntityTransaction tx2 = em2.getTransaction();
		tx2.begin();
		
		Member mergeMember = em2.merge(member);		//준영속 member를 조회, 1차 캐시에 저장. mergeMember에 member 값을 병합.
		tx2.commit();
		
		System.out.println("member=" + member.getUsername());		//준영속 상태
		
		System.out.println("mergeMember=" + mergeMember.getUsername());		//영속 상태
		
		System.out.println("em2 contains member = " + em2.contains(member));
		
		System.out.println("em2 contains mergeMember = " + em2.contains(mergeMember));
		
		em2.close();
	}

}
