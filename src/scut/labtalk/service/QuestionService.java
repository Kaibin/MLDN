package scut.labtalk.service;

import java.util.List;

import scut.labtalk.domain.Question;

public interface QuestionService {
	// 根据Item查找全部的问题数量
	public long getCountByItem(String itemid) throws Exception;

	// 根据itemid查找全部的问题数量
	public long getCountBySub(String subid) throws Exception;

	// 根据推荐查找全部的问题数量
	public long getCountByCommen(int commen) throws Exception;

	// 根据状态查找全部的问题数量
	public long getCountByStatus(int status) throws Exception;

	// 根据模糊查询查找全部的问题数量
	public long getCountByLike(String cond) throws Exception;
	
	// 求出一个用户问题的数量
	public long getCountByUserid(String userid) throws Exception;

	// 增加问题
	public void save(Question question) throws Exception;

	// 查找推荐问题
	// 1：推荐
	// 0：不推荐
	public List<Question> queryByCommemflag(int commenflag, int currentPage, int lineSize)
			throws Exception;

	// 按解决装查找问题
	// 1：未解决
	// 2：已解决
	// 3：无满意答案
	public List<Question> queryByStatus(int status, int currentPage, int lineSize)
			throws Exception;

	// 根据ID取出内容
	public Question queryById(String qid) throws Exception;

	// 修改浏览次数
	public void updateClickcount(String qid) throws Exception;

	// 按一级栏目检索
	public List<Question> queryByItem(String itemid, int currentPage, int lineSize)
			throws Exception;

	// 按二级栏目检索
	public List<Question> queryBySub(String subid, int currentPage, int lineSize)
			throws Exception;

	// 模糊查询
	public List<Question> queryByLike(String cond, int currentPage, int lineSize)
			throws Exception;

	// 列出一个用户提出的全部问题
	public List<Question> queryByUserId(String userid, int currentPage, int lineSize)
			throws Exception;

	// 列出用户回答过的问题
	public List<Question> queryByUserAnswer(String userid, int currentPage, int lineSize);

	// 列出用户回答过的问题的数量
	public long getByUserAnswer(String userid) throws Exception;

	// 列出一个用户被采纳的问题
	public List<Question> queryByAccept(String userid, int status, int currentPage,
			int lineSize) throws Exception;

	// 列出一个用户被采纳问题的数量
	public long getByAccept(String userid, int status) throws Exception;

	// 答案是否已采纳够
	public void updateAccept(String qid, int accept) throws Exception;

	// 设置答案状态：不满意、未解决、已解决
	public void updateStatus(String qid, int status) throws Exception;

	// 删除问题
	public void delete(String qid) throws Exception;

	// 列出全部数据

	public List<Question> queryAll(int currentPage, int lineSize) throws Exception;

	// 得到全部的数据大小
	public long getAllCount() throws Exception;
	
	// 设置推荐问题
	public void updateCommen(String qid,int commen) throws Exception ;
}
