package scut.labtalk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import scut.labtalk.dao.QuestionDao;
import scut.labtalk.domain.Question;
import scut.labtalk.service.QuestionService;
@Component
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	QuestionDao questiondao;

	@Override
	public long getCountByItem(String itemid) throws Exception {
		return questiondao.getCountByItem(itemid);
	}

	@Override
	public long getCountBySub(String subid) throws Exception {
		return questiondao.getCountBySub(subid);
	}

	@Override
	public long getCountByCommen(int commen) throws Exception {
		return questiondao.getCountByCommen(commen);
	}

	@Override
	public long getCountByStatus(int status) throws Exception {
		return questiondao.getCountByStatus(status);
	}

	@Override
	public long getCountByLike(String cond) throws Exception {
		return questiondao.getCountByLike(cond);
	}

	@Override
	public long getCountByUserid(String userid) throws Exception {
		return questiondao.getCountByUserid(userid);
	}

	@Override
	public void save(Question question) throws Exception {
		questiondao.insert(question);		
	}

	@Override
	public List<Question> queryByCommemflag(int commenflag, int currentPage,
			int lineSize) throws Exception {
		return questiondao.queryByCommemflag(commenflag, currentPage, lineSize);
	}

	@Override
	public List<Question> queryByStatus(int status, int currentPage,
			int lineSize) throws Exception {
		return questiondao.queryByStatus(status, currentPage, lineSize);
	}

	@Override
	public Question queryById(String qid) throws Exception {
		return questiondao.queryById(qid);
	}

	@Override
	public void updateClickcount(String qid) throws Exception {
		questiondao.updateClickcount(qid);		
	}

	@Override
	public List<Question> queryByItem(String itemid, int currentPage,
			int lineSize) throws Exception {
		return questiondao.queryByItem(itemid, currentPage, lineSize);
	}

	@Override
	public List<Question> queryBySub(String subid, int currentPage, int lineSize)
			throws Exception {
		return questiondao.queryBySub(subid, currentPage, lineSize);
	}

	@Override
	public List<Question> queryByLike(String cond, int currentPage, int lineSize)
			throws Exception {
		return questiondao.queryByLike(cond, currentPage, lineSize);
	}

	@Override
	public List<Question> queryByUserId(String userid, int currentPage,
			int lineSize) throws Exception {
		return questiondao.queryByUserId(userid, currentPage, lineSize);
	}

	@Override
	public List<Question> queryByUserAnswer(String userid, int currentPage,
			int lineSize) {
		return questiondao.queryByUserAnswer(userid, currentPage, lineSize);
	}

	@Override
	public long getByUserAnswer(String userid) throws Exception {
		return questiondao.getByUserAnswer(userid);
	}

	@Override
	public List<Question> queryByAccept(String userid, int status,
			int currentPage, int lineSize) throws Exception {
		return questiondao.queryByAccept(userid, status, currentPage, lineSize);
	}

	@Override
	public long getByAccept(String userid, int status) throws Exception {
		return questiondao.getByAccept(userid, status);
	}

	@Override
	public void updateAccept(String qid, int accept) throws Exception {
		questiondao.updateAccept(qid, accept);		
	}

	@Override
	public void updateStatus(String qid, int status) throws Exception {
		questiondao.updateStatus(qid, status);		
	}

	@Override
	public void delete(String qid) throws Exception {
		questiondao.delete(qid);		
	}

	@Override
	public List<Question> queryAll(int currentPage, int lineSize)
			throws Exception {
		return questiondao.queryAll(currentPage, lineSize);
	}

	@Override
	public long getAllCount() throws Exception {
		return questiondao.getAllCount();
	} 

	@Override
	public void updateCommen(String qid, int commen) throws Exception {
		questiondao.updateCommen(qid, commen);		
	}

	public QuestionDao getQuestiondao() {
		return questiondao;
	}

	public void setQuestiondao(QuestionDao questiondao) {
		this.questiondao = questiondao;
	}
}
