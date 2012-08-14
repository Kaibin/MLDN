package scut.labtalk.struts.action;

import java.util.Date;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.SessionAware;

import scut.labtalk.domain.Answer;
import scut.labtalk.domain.Question;
import scut.labtalk.manager.ServiceLocator;
import scut.labtalk.service.AnswerService;
import scut.labtalk.service.QuestionService;
import scut.labtalk.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class AnswerAction  extends ActionSupport implements SessionAware{

	/**
	 * @author kaibin
	 */
	
	private String grade;

	private String userid;

	private String checkcode;
	
	private String qid;
	
	private String type;
	
	private String quesans;
	
	private static final long serialVersionUID = -6552334637074830360L;
	
	private Log logger = LogFactory.getLog(QuestionAction.class);
	
	private AnswerService answerService = ServiceLocator.getServiceLocator().getAnswerService();
	
	private QuestionService questionService = ServiceLocator.getServiceLocator().getQuestionService();
	
	private UserService userSerivice = ServiceLocator.getServiceLocator().getUserService();
	
	private Map<String,Object> session;

	public String insert() {
		
		logger.info("start to answer!");

		// 先判断验证码是否正确
		String ccode = (String) session.get("ccode");
		String checkcode = getCheckcode();
		if (!(checkcode.equals(ccode))) {
			addActionError("checkcode.error");
			logger.error("checkcode.error");
			return "";
		}
		try {
			Answer ans = new Answer();
			ans.setAnstime(new Date());
			ans.setQuesans(getQuesans());
			ans.setUserid(getUserid());
			ans.setGrade(scut.labtalk.util.IntegralGrade.getInstance().getGradeInfo(Integer.parseInt(getGrade())));
			ans.setStatus(Answer.NOACCEPT);
			Question q = questionService.queryById(getQid());
			ans.setQuestion(q) ;
			q.addAnswer(ans);
			this.answerService.insert(ans);
			this.userSerivice.addIntegral(getUserid(), 5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "insertdo";
	}
	
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getCheckcode() {
		return checkcode;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	public String getQid() {
		return qid;
	}

	public void setQid(String qid) {
		this.qid = qid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getQuesans() {
		return quesans;
	}

	public void setQuesans(String quesans) {
		this.quesans = quesans;
	}


}
