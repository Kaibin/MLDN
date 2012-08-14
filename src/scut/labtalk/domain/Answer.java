package scut.labtalk.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="answer",catalog="labtalk")
public class Answer implements Serializable{
	/**
	 * @author: kaibin
	 */
	private static final long serialVersionUID = 8197566084841352034L;
	public static final int ACCEPT = 1;
	public static final int NOACCEPT = 2;
	private String aid ;
	private String quesans ;
	private String userid ;
	private String grade ;
	private Date anstime ;
	//1:采用
	//2:未采用
	private int status ;
	private Question question ;
	
	public Answer() {
		super();
	}
	
	public Answer(String quesans, String userid, String grade,Date anstime, int status) {
		super();
		this.quesans = quesans;
		this.userid = userid;
		this.grade = grade;
		this.anstime = anstime;
		this.status = status;
	}

	@Id
	@GeneratedValue(generator="system-uuid") 
	@GenericGenerator(name="system-uuid",strategy="uuid")
	@Column(name="aid",length=32)
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	
	@Temporal(TemporalType.TIMESTAMP) 
	@Column(name = "questiontime", length = 11)
	public Date getAnstime() {
		return anstime;
	}
	public void setAnstime(Date anstime) {
		this.anstime = anstime;
	}
	
	@Column(name = "quesans")
	public String getQuesans() {
		return quesans;
	}
	public void setQuesans(String quesans) {
		this.quesans = quesans;
	}
	
	@Column(name = "status")
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Column(name = "userid")
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.REFRESH},optional=false)
	@JoinColumn(name="qid")
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	
	@Column(name = "grade")
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
}
