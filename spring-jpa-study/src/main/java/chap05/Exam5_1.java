package chap05;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

		public void setTeam(Team team) {
			this.team = team;
		}
	}
	
	@Entity
	static public class Team{
		@Id
		@Column(name="TEAM_ID")
		private String id;
		private String name;
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
		
		member1.setTeam(team1); //회원, 팀 연관관계
		member2.setTeam(team1);
		
		Team findTeam = member1.getTeam();	//객체 그래프 탐색
		
	}

}
