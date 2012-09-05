package scut.labtalk.struts.action;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import scut.labtalk.domain.Item;
import scut.labtalk.domain.Pagination;
import scut.labtalk.domain.Question;
import scut.labtalk.manager.ServiceLocator;
import scut.labtalk.service.ItemService;
import scut.labtalk.service.QuestionService;
import com.opensymphony.xwork2.ActionSupport;

public class ShowQuestionAction extends ActionSupport implements
		ServletRequestAware {

	/**
	 * @author kaibin
	 */
	@Autowired
	private QuestionService questionService;
	@Autowired
	private ItemService itemService;
	
	private static final long serialVersionUID = 7613036618250521432L;
	private Log logger = LogFactory.getLog(ShowQuestionAction.class);
	private HttpServletRequest request;
	private Question question;
	private List<Question> allques = null;
	private List<Item> allitem = null;
	private Pagination pagination;
	public static final int PAGE_SIZE = 2;
	private List<Integer> pageList = new ArrayList<Integer>();
	private String jspUrl;
	private String flagname;
	private String flagvalue;
	private String keyWord;
	private String searchFlag = "F";

	public String selectQuestionByQid() {

		try {
			this.questionService.updateClickcount(request.getParameter("qid"));
			question = this.questionService.queryById(request
					.getParameter("qid"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "showquestion";
	}

	public String selectQuestionByCommen() {
		try { 
			if (pagination == null) { 
				pagination = new Pagination(PAGE_SIZE);
			}
			pagination.setCurrentPage(pagination.getCurrentPage()); 
			pagination.setTotalRecord(questionService.getCountByCommen(Integer.parseInt(request.getParameter("commen"))));
			pagination.setSize(PAGE_SIZE);
	System.out.println("*********pagination.getTotalRecord()"+pagination.getTotalRecord());
	System.out.println("*********pagination.getSize()"+pagination.getSize());
			pagination.setTotalPage((pagination.getTotalRecord()+pagination.getSize()-1)/pagination.getSize() );
			for(int i=0;i<pagination.getTotalPage();i++){
				pageList.add(i+1); 
			}
			allques =this.questionService.queryByCommemflag(Integer.parseInt(request.getParameter("commen")),pagination.getCurrentPage(), pagination.getSize());
			allitem = this.itemService.getAllItem();
			jspUrl = "MoreCommenQuestionAction.action";
			flagname = "commen";
			flagvalue = request.getParameter("commen");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return "showlist";
		return SUCCESS;
	}

	public String selectQuestionByStatus() {
		try {
			if (pagination == null) { 
				pagination = new Pagination(PAGE_SIZE);
			}
			pagination.setCurrentPage(pagination.getCurrentPage()); 
			
			pagination.setTotalRecord(questionService.getCountByStatus(Integer.parseInt(request.getParameter("status"))));
			pagination.setSize(PAGE_SIZE);
			
			pagination.setTotalPage((pagination.getTotalRecord()+pagination.getSize()-1)/pagination.getSize() );
			for(int i=0;i<pagination.getTotalPage();i++){
				pageList.add(i+1); 
			}
			allques = this.questionService.queryByStatus(Integer.parseInt(request.getParameter("status")),pagination.getCurrentPage(), pagination.getSize());
			allitem = this.itemService.getAllItem();
			jspUrl = "MoreStatusQuestionAction.action";
			flagname = "status";
			flagvalue = request.getParameter("status");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return "showlist";
		return SUCCESS;
	}

	public String selectQuestionByItem() {
		try {
			if (pagination == null) {
				pagination = new Pagination(PAGE_SIZE);
			}
			pagination.setCurrentPage(pagination.getCurrentPage());
			pagination.setTotalRecord(questionService.getCountByItem(request.getParameter("itemid")));
			pagination.setSize(PAGE_SIZE);

			pagination.setTotalPage((pagination.getTotalRecord()+ pagination.getSize() - 1)/ pagination.getSize());
			for (int i = 0; i < pagination.getTotalPage(); i++) {
				pageList.add(i + 1);
			}
			allques = this.questionService.queryByItem(
					request.getParameter("itemid"),
					pagination.getCurrentPage(), pagination.getSize());
			allitem = this.itemService.getAllItem();
			jspUrl = "MoreItemQuestionAction.action";
			flagname = "itemid";
			flagvalue = request.getParameter("itemid");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "showlist";
	}

	public String selectQuestionBySubitem() {
		try {
			if (pagination == null) {
				pagination = new Pagination(PAGE_SIZE);
			}
			pagination.setCurrentPage(pagination.getCurrentPage());
			pagination.setTotalRecord(questionService.getCountBySub(request.getParameter("subid")));
			pagination.setSize(PAGE_SIZE);

			pagination.setTotalPage((pagination.getTotalRecord()+ pagination.getSize() - 1)/ pagination.getSize());
			for (int i = 0; i < pagination.getTotalPage(); i++) {
				pageList.add(i + 1);
			}
			allques = this.questionService.queryBySub(request.getParameter("subid"), pagination.getCurrentPage(),pagination.getSize());
			allitem = this.itemService.getAllItem();
			jspUrl = "MoreSubitemQuestionAction.action";
			flagname = "subid";
			flagvalue = request.getParameter("subid");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "showlist";
	}

	public String selectQuestionBySearch() {
		try {
			if (pagination == null) {
				pagination = new Pagination(PAGE_SIZE);
			}
			pagination.setCurrentPage(pagination.getCurrentPage());
			String like = new String(request.getParameter("keyWord").getBytes("ISO8859-1"));
			pagination.setSize(PAGE_SIZE);
			pagination.setTotalRecord(questionService.getCountByLike(like));

			pagination.setTotalPage((pagination.getTotalRecord()+ pagination.getSize() - 1)/ pagination.getSize());
			for (int i = 0; i < pagination.getTotalPage(); i++) {
				pageList.add(i + 1);
			}
			allques = this.questionService.queryByLike(like,pagination.getCurrentPage(), pagination.getSize());
			allitem = this.itemService.getAllItem();
			jspUrl = "SearchQuestionAction.action";
			flagname = "keyWord";
			flagvalue = request.getParameter("keyWord");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return "showlist";
		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<Question> getAllques() {
		return allques;
	}

	public void setAllques(List<Question> allques) {
		this.allques = allques;
	}

	public List<Item> getAllitem() {
		return allitem;
	}

	public void setAllitem(List<Item> allitem) {
		this.allitem = allitem;
	}

	public String getJspUrl() {
		return jspUrl;
	}

	public void setJspUrl(String jspUrl) {
		this.jspUrl = jspUrl;
	}

	public String getFlagname() {
		return flagname;
	}

	public void setFlagname(String flagname) {
		this.flagname = flagname;
	}

	public String getFlagvalue() {
		return flagvalue;
	}

	public void setFlagvalue(String flagvalue) {
		this.flagvalue = flagvalue;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getSearchFlag() {
		return searchFlag;
	}

	public void setSearchFlag(String searchFlag) {
		this.searchFlag = searchFlag;
	}

	public List<Integer> getPageList() {
		return pageList;
	}

	public void setPageList(List<Integer> pageList) {
		this.pageList = pageList;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

}
