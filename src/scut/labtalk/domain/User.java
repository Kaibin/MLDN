package scut.labtalk.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

@XmlRootElement
@Entity
@Table(name="user",catalog="labtalk")
public class User implements Serializable{
	/**
	 * 	 *Author:kaibn
	 */
	private static final long serialVersionUID = -6793762160352050817L;

	private Gender gender;

	private String usermail;

	private String userques;

	private String userid;

	private String realname;

	private String userans;

	private String userpwd;

	private int grade;

	private int integral;

	private String id;
	
	public User( ) {
	}
	
	public User(Gender gender, String usermail, String userques, String userid,
			String realname, String userans, String userpwd, int grade,
			int integral) {
		super();
		this.gender = gender;
		this.usermail = usermail;
		this.userques = userques;
		this.userid = userid;
		this.realname = realname;
		this.userans = userans;
		this.userpwd = userpwd;
		this.grade = grade;
		this.integral = integral;
	}

	@Column(name="grade")
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Column(name="realname")
	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(length=6,nullable=false)
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	@Column(name="userans")
	public String getUserans() {
		return userans;
	}

	public void setUserans(String userans) {
		this.userans = userans;
	}
	@Column(name="userid")
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Column(name="usermail")
	public String getUsermail() {
		return usermail;
	}

	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}

	@Column(name="userpwd")
	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	@Column(name="userquess")
	public String getUserques() {
		return userques;
	}

	public void setUserques(String userques) {
		this.userques = userques;
	}

	@Id
	@GeneratedValue(generator="system-uuid") 
	@GenericGenerator(name="system-uuid",strategy="uuid")
	@Column(name="id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name="integral")
	public int getIntegral() {
		return integral;
	}

	public void setIntegral(int integral) {
		this.integral = integral;
	}
}
