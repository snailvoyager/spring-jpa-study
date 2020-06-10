package chap05;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Exam5_1 {
	
	@Entity
	static public class Member{
		@Id
		@Column(name="MEMBER_ID")
		private String id;
		private String username;
		
		@ManyToOne			//다대일
		@JoinColumn(name="TEAM_ID")		//외래키 매핑
		private Team team;		//팀 정보 참조

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public Team getTeam() {
			return team;
		}

		public void setTeam(Team team) {		//연관관계 편의 메소드 
			if(this.team != null)
				this.team.getMembers().remove(this);		//기존 팀이 있으면 연관관계 삭제
			
			this.team = team;
			team.getMembers().add(this);
		}
	}
	
	@Entity
	static public class Team{
		@Id
		@Column(name="TEAM_ID")
		private String id;
		private String name;
		
		@OneToMany(mappedBy="team")		//반대쪽 매핑 필드명, 연관관계의 주인 설정
		private List<Member> members = new ArrayList<Member>();		//일대다는 컬렉션 사용
		
		public List<Member> getMembers() {
			return members;
		}
		public void setMembers(List<Member> members) {
			this.members = members;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member member1 = new Member();	//회원1
		Member member2 = new Member();	//회원2
		Team team1 = new Team();	//팀1
		
		member1.setTeam(team1); 	//회원, 팀 연관관계
		member2.setTeam(team1);		//연관관계의 주인
		
		//team1.getMembers().add(member1);	//팀 -> 회원 연관관계
		//team1.getMembers().add(member2);	//주인이 아니라 저장 시 사용되지 않는다
		
		List<Member> members = team1.getMembers();
		System.out.println("member size : " + members.size());
		
		Team findTeam = member1.getTeam();	//객체 그래프 탐색
		
	}

}
