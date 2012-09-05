package scut.labtalk.struts.action;

import java.util.Date;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import scut.labtalk.domain.Question;
import scut.labtalk.manager.ServiceLocator;
import scut.labtalk.service.QuestionService;
import com.opensymphony.xwork2.ActionSupport;

public class QuestionAction extends ActionSupport implements SessionAware{

	/**
	 * @author kaibin
	 */
	private static final long serialVersionUID = 4399493766801314021L;
	private Log logger = LogFactory.getLog(QuestionAction.class);

	@Autowired
	private QuestionService questionService;
	
	private String qid;

	private String title;

	private String content;

	private String grade;

	private String userid;

	private String offerscore;

	private String checkcode;

	private int type;
	
	private String itemid ;
	
	private String subid ;
	
	private Map<String,Object> session;
	
	public String insert() {
		
		logger.info("start to ask question!");

		// 先判断验证码是否正确
		String ccode = (String) session.get("ccode");
		String checkcode = getCheckcode();
		if (!(checkcode.equals(ccode))) {
			addActionError("checkcode.error");
			logger.error("checkcode.error");
			return "";
		}
		try {
			Question que = new Question();
			que.setTitle(getTitle());
			que.setContent(getContent());
			que.setItemid(getItemid());
			que.setSubid(getSubid());
			que.setGrade(scut.labtalk.util.IntegralGrade.getInstance().getGradeInfo(Integer.parseInt(getGrade())));
			que.setUserid(getUserid());
			que.setOfferscore(Integer.parseInt(getOfferscore()));
			que.setQuestiontime(new Date());
			que.setStatus(Question.UNSOLVED);
			que.setAcceptflag(Question.NOACCEPT);
			que.setCommenflag(Question.NOCOMMENT);
			this.questionService.save(que);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "SaveQuestionSuccess";
	}
/*
	public ActionForward selectid(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
//		QuestionForm questionForm = (QuestionForm) form;
//		Question q = null;
//		try {
//			// 更新浏览次数
//			this.iquestiondao.updateClickcount(Integer.parseInt(questionForm
//					.getQid()));
//			q = this.iquestiondao.queryById(Integer.parseInt(questionForm
//					.getQid()));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		if (q != null) {
//			request.setAttribute("question", q);
//		}
//
		return mapping.findForward("showquestion");
	}
*/
	public String getQid() {
		return qid;
	}

	public void setQid(String qid) {
		this.qid = qid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	

	public String getOfferscore() {
		return offerscore;
	}

	public void setOfferscore(String offerscore) {
		this.offerscore = offerscore;
	}

	public String getCheckcode() {
		return checkcode;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}


	public QuestionService getQuestionService() {
		return questionService;
	}

	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}


	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public String getSubid() {
		return subid;
	}
	public void setSubid(String subid) {
		this.subid = subid;
	}
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
