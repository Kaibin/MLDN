package scut.labtalk.struts.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import org.springframework.beans.factory.annotation.Autowired;

import scut.labtalk.domain.Gender;
import scut.labtalk.domain.User;
import scut.labtalk.manager.ServiceLocator;
import scut.labtalk.service.UserService;
import scut.labtalk.util.MD5Code;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport implements ServletRequestAware,SessionAware,ServletContextAware{


	/**
	 * @author kaibin
	 */
	
	private static final long serialVersionUID = 615107414235591107L;
	private Log logger = LogFactory.getLog(UserAction.class);
	
	@Autowired
	private UserService userService = ServiceLocator.getServiceLocator().getUserService();
	
	private Gender gender = Gender.MALE;

	private String usermail;

	private String userques;

	private String userid;

	private String realname;

	private String userans;

	private String userpwd;

	private String confirmpwd;

	private String checkcode;

	/** grade property */
	private String grade;

	/** integral property */
	private String integral;

	/** id property */
	private String id;

	private int type;

	// 1：表示注册功能
	// 2：表示登陆
	// 3：表示忘记密码，确认用户是否存在
	// 4：表示修改密码

	private HttpServletRequest request;
	private Map<String,Object> session;
	private ServletContext application;

	public String register() {
		
		logger.info("start to register!");

		// 先判断验证码是否正确
		String ccode = (String) session.get("ccode");
		String checkcode = getCheckcode();
		if (!(checkcode.equals(ccode))) {
			addActionError("checkcode.error");
			return "registerFailure";
		}
		// 如果正确，则需要向数据库中插入
		try {
			User user = null;
			user = this.userService.getByUserid(getUserid());
			if (user == null) {
				MD5Code md5 = new MD5Code();
				user = new User();
				user.setUserid(getUserid());
				user.setUserpwd(md5.getMD5ofStr(getUserpwd()));
				user.setUserques(getUserques());
				user.setUserans(getUserans());
				user.setGender(getGender());
				user.setGrade(1);
				// 查询此用户是否存在
				this.userService.register(user);
				// 成功之后要将用户名和用户等级保存在session之中
				session.put("userid", user.getUserid());
				session.put("grade", user.getGrade());
				logger.info("login success!");
				return "registerSuccess";
			} else {
				addActionError("user.userid.exist");
				return "registerFailure";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "registerFailure";
		}
	}
	
	public String login() {
		logger.info("start to login!");
		String ccode = (String) session.get("ccode");
		String checkcode = getCheckcode();
		if (!(checkcode.equals(ccode))) {
			addActionError("checkcode.error");
			return "loginFailure";
		}
		User user = new User();
		MD5Code md5 = new MD5Code();
		user.setUserid(getUserid());
		user.setUserpwd(md5.getMD5ofStr(getUserpwd()));
		boolean flag = false;
		try {
			flag = userService.login(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag) {
			// 登陆成功
			// 向session之中设置内容
			session.put("userid", user.getUserid());
			session.put("grade", user.getGrade());
			logger.info("login success!");
			return "loginSuccess";
		} else {
			request.setAttribute("flag", "error");
			return "loginFailure";
		}
	}

	/*public String update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		UserForm userForm = (UserForm) form;
		// 先判断验证码是否正确
		String ccode = (String) request.getSession().getAttribute("ccode");
		String checkcode = userForm.getCheckcode();
		if (!(checkcode.equals(ccode))) {
			ActionMessages errors = new ActionMessages();
			errors.add("checkcode", new ActionMessage("checkcode.error"));
			super.saveErrors(request, errors);
			return mapping.getInputForward();
		}
		// 如果正确，则需要向数据库中插入
		User user = null;
		try {
			MD5Code md5 = new MD5Code();
			user = new User();
			user.setUserid(userForm.getUserid());
			user.setUserpwd(md5.getMD5ofStr(userForm.getUserpwd()));
			user.setUserques(userForm.getUserques());
			user.setUserans(userForm.getUserans());
			// System.out.println("** " + userForm.getUserques());
			user.setRealname(userForm.getRealname());
			user.setSex(userForm.getSex());
			user.setGrade(Integer.parseInt(userForm.getGrade()));
			user.setIntegral(Integer.parseInt(userForm.getIntegral()));
			user.setUsermail(userForm.getUsermail());
			// 查询此用户是否存在
			this.iuserdao.update(user);
			// 成功之后要将用户名和用户等级保存在session之中
			request.getSession().setAttribute("userid", user.getUserid());
			request.getSession().setAttribute("grade", user.getGrade());
			return mapping.findForward("userinfo");
		} catch (Exception e) {
			request.setAttribute("flag", "error");
			return mapping.findForward("userinfo");
		}
	}

	

	public String forgetpwd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		UserForm userForm = (UserForm) form;
		String ccode = (String) request.getSession().getAttribute("ccode");
		String checkcode = userForm.getCheckcode();
		if (!(checkcode.equals(ccode))) {
			ActionMessages errors = new ActionMessages();
			errors.add("checkcode", new ActionMessage("checkcode.error"));
			super.saveErrors(request, errors);
			return mapping.getInputForward();
		}
		boolean flag = true;
		try {
			flag = this.iuserdao.isExists(userForm.getUserid(), userForm
					.getUserques(), userForm.getUserans());
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回到修改密码页
		// 返回到提示问题页
		if (flag) {
			request.setAttribute("flag", "exists");
			return mapping.findForward("exists");
		} else {
			return mapping.findForward("notexists");
		}
	}

	public String updatepwd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		UserForm userForm = (UserForm) form;
		String ccode = (String) request.getSession().getAttribute("ccode");
		String checkcode = userForm.getCheckcode();
		if (!(checkcode.equals(ccode))) {
			ActionMessages errors = new ActionMessages();
			errors.add("checkcode", new ActionMessage("checkcode.error"));
			super.saveErrors(request, errors);
			return mapping.getInputForward();
		}
		MD5Code md5 = new MD5Code();
		try {
			this.iuserdao.updateUserpwd(userForm.getUserid(), md5
					.getMD5ofStr(userForm.getUserpwd()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapping.findForward("updatepwddo");
	}

	public String selectid(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// 用户已经登陆成功了
		String userid = (String) request.getSession().getAttribute("userid");
		try {
			User user = this.iuserdao.queryByUserid(userid);
			request.setAttribute("user", user);
			//System.out.println("** "+user.getGrade());
			request.setAttribute("grade", org.lxh.myzngt.util.IntegralGrade
					.getInstance().getGradeInfo(user.getGrade()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapping.findForward("userinfo");
	}*/

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getUsermail() {
		return usermail;
	}

	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}

	public String getUserques() {
		return userques;
	}

	public void setUserques(String userques) {
		this.userques = userques;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getUserans() {
		return userans;
	}

	public void setUserans(String userans) {
		this.userans = userans;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getConfirmpwd() {
		return confirmpwd;
	}

	public void setConfirmpwd(String confirmpwd) {
		this.confirmpwd = confirmpwd;
	}

	public String getCheckcode() {
		return checkcode;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getIntegral() {
		return integral;
	}

	public void setIntegral(String integral) {
		this.integral = integral;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;		
	}
	
	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}
	
	public HttpServletRequest getRequest() {
		return request;
	}
	
	public ServletContext getApplication() {
		return application;
	}
	@Override

	public void setServletContext(ServletContext application) {
		this.application = application;
	}

}
