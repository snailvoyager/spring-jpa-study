package start;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import chap04.RoleType;

@Entity
@Table(name="MEMBER", uniqueConstraints= {@UniqueConstraint(	//유니크 제약조건 추가
		name="NAME_AGE_UNIQUE",
		columnNames = {"NAME", "AGE"}	)})
public class Member {
	@Id			//PrimaryKey에 매핑 식필자 필드
	@Column(name="ID")
	private String id;
	@Column(name="NAME", nullable=false, length=10)		//NOT NULL, 길이 조건 추가
	private String username;
	
	private Integer age;	//매핑정보가 없어도 필드명을 사용해서 컬럼명에 매핑
	
	@Enumerated(EnumType.STRING)	//enum 타입 매핑
	private RoleType roleType;
	
	@Temporal(TemporalType.TIMESTAMP)	//날짜 타입 매핑
	private Date createdDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;
	
	@Lob	//BLOB, CLOB 타입 매핑
	private String description;
	
	
	public RoleType getRoleType() {
		return roleType;
	}
	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
}
