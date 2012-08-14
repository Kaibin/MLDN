package scut.labtalk.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="question",catalog="labtalk")
public class Question implements Serializable{
	/**
	 * @author kaibn
	 */
	private static final long serialVersionUID = -1913262792819378605L;
	public static final int UNSOLVED = 1;
	public static final int SOLVED = 2;
	public static final int NOANSWER = 3;
	public static final int ACCEPT = 1;
	public static final int NOACCEPT = 2;
	public static final int COMMENT = 1;
	public static final int NOCOMMENT = 2;
	
	private String qid ;
	private String title ;
	private String content ;
	private String itemid ;
	private String subid ;
	private String userid ;
	private String grade ;
	private int offerscore ;
	//1:未解决 
	//2:已解决 
	//3:无满意答案
	private int status ;
	private Date questiontime ;
	private int clickcount = 0 ;
	//1:已经采纳
	//2:未采纳
	private int acceptflag ;
	//1:推荐
	//2:不推荐
	private int commenflag ;
	private List<Answer> answers = new ArrayList<Answer>();
	
	public Question() {
		super();
	}
	
	public Question(String title, String content, String itemid,
			String subid, String userid, String grade, int offerscore, int status,
			Date questiontime, int clickcount, int acceptflag, int commenflag) {
		super();
		this.title = title;
		this.content = content;
		this.itemid = itemid;
		this.subid = subid;
		this.userid = userid;
		this.grade = grade;
		this.offerscore = offerscore;
		this.status = status;
		this.questiontime = questiontime;
		this.clickcount = clickcount;
		this.acceptflag = acceptflag;
		this.commenflag = commenflag;
	}

	@Column(name="acceptflag")
	public int getAcceptflag() {
		return acceptflag;
	}
	public void setAcceptflag(int acceptflag) {
		this.acceptflag = acceptflag;
	}
	
	@Column(name="clickcount")
	public int getClickcount() {
		return clickcount;
	}
	public void setClickcount(int clickcount) {
		this.clickcount = clickcount;
	}
	
	@Column(name="commenflag")
	public int getCommenflag() {
		return commenflag;
	}
	public void setCommenflag(int commenflag) {
		this.commenflag = commenflag;
	}
	
	@Column(name="content")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Column(name="itemid")
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	
	@Column(name="offerscore")
	public int getOfferscore() {
		return offerscore;
	}
	public void setOfferscore(int offerscore) {
		this.offerscore = offerscore;
	}
	
	@Id
	@GeneratedValue(generator="system-uuid") 
	@GenericGenerator(name="system-uuid",strategy="uuid")
	@Column(name="qid",length=32)
	public String getQid() {
		return qid;
	}
	public void setQid(String qid) {
		this.qid = qid;
	}
	
	@Temporal(TemporalType.TIMESTAMP) 
	@Column(name = "questiontime", length = 11) 
	public Date getQuestiontime() {
		return questiontime;
	}
	public void setQuestiontime(Date questiontime) {
		this.questiontime = questiontime;
	}
	
	@Column(name="status")
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Column(name="subid")
	public String getSubid() {
		return subid;
	}
	public void setSubid(String subid) {
		this.subid = subid;
	}
	
	@Column(name="title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name="userid")
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
	@OneToMany(targetEntity=Answer.class,mappedBy = "question", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)// 设置lazy=false,将fetch类型设置成直接获取
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	@Column(name="grade")
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public void addAnswer(Answer answer){
		answer.setQuestion(this);
		this.answers.add(answer);
	}
	
}
