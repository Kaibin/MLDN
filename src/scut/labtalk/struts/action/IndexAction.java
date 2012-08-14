package scut.labtalk.struts.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.SessionAware;

import scut.labtalk.domain.Item;
import scut.labtalk.domain.Question;
import scut.labtalk.domain.User;
import scut.labtalk.manager.ServiceLocator;
import scut.labtalk.service.ItemService;
import scut.labtalk.service.QuestionService;
import scut.labtalk.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport implements SessionAware{

	/**
	 * @author kaibin
	 */
	private static final long serialVersionUID = 2345219753184690185L;
	private Log logger = LogFactory.getLog(IndexAction.class);
	private Map<String,Object> session;
	
	private ItemService itemService = ServiceLocator.getServiceLocator().getItemService();
	private QuestionService questionService = ServiceLocator.getServiceLocator().getQuestionService();
	private UserService userService = ServiceLocator.getServiceLocator().getUserService();
	
	private List<Item> allitem = null ;
	private List<Question> commen = null ;
	private List<Question> unsolve = null ;
	private List<Question> solve = null ;
	private List<User> allusers = null;
	private long unsolveCount = 0;
	private long solveCount = 0;
	
	public static final int CURRENT_PAGE = 1;
	public static final int PAGE_Line= 8;

	public String list() {
		
		logger.info("start to list");
		try {
			allitem = itemService.getAllItem();
			commen = questionService.queryByCommemflag(Question.COMMENT, CURRENT_PAGE, PAGE_Line) ;
			unsolve = questionService.queryByStatus(Question.UNSOLVED, CURRENT_PAGE, PAGE_Line) ;
			solve = questionService.queryByStatus(Question.SOLVED, CURRENT_PAGE, PAGE_Line) ;
			allusers = userService.getAllUser(1, 8);
			unsolveCount = questionService.getCountByStatus(Question.UNSOLVED);
			solveCount = questionService.getCountByStatus(Question.SOLVED); 

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("start to index.jsp");
		return "indexSuccess";
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;		
	}
	
	public Map<String, Object> getSession() {
		return session;
	}

	public List<Item> getAllitem() {
		return allitem;
	}

	public void setAllitem(List<Item> allitem) {
		this.allitem = allitem;
	}

	public List<Question> getCommen() {
		return commen;
	}

	public void setCommen(List<Question> commen) {
		this.commen = commen;
	}

	public List<Question> getUnsolve() {
		return unsolve;
	}

	public void setUnsolve(List<Question> unsolve) {
		this.unsolve = unsolve;
	}

	public List<Question> getSolve() {
		return solve;
	}

	
	public List<User> getAllusers() {
		return allusers;
	}

	public void setAllusers(List<User> allusers) {
		this.allusers = allusers;
	}

	public void setSolve(List<Question> solve) {
		this.solve = solve;
	}

	public long getUnsolveCount() {
		return unsolveCount;
	}

	public void setUnsolveCount(long unsolveCount) { 
		this.unsolveCount = unsolveCount;
	}

	public long getSolveCount() {
		return solveCount;
	}

	public void setSolveCount(long solveCount) {
		this.solveCount = solveCount;
	}
	
	


}
