package start;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MEMBER")
public class Member {
	@Id			//PrimaryKey에 매핑 식필자 필드
	@Column(name="ID")
	private String id;
	@Column(name="NAME")
	private String username;
	
	private Integer age;	//매핑정보가 없어도 필드명을 사용해서 컬럼명에 매핑
	
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
