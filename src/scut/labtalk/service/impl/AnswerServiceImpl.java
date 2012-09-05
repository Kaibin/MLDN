package scut.labtalk.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import scut.labtalk.dao.AnswerDao;
import scut.labtalk.domain.Answer;
import scut.labtalk.service.AnswerService;
@Component
public class AnswerServiceImpl implements AnswerService{

	@Autowired
	AnswerDao answerdao;

	@Override
	public void insert(Answer answer) throws Exception {
		answerdao.insert(answer);
	}

	@Override
	public List<Answer> queryByUserid(String userid, int currentPage, int lineSize)
			throws Exception {
		return answerdao.queryByUserid(userid, currentPage, lineSize);
	}

	@Override
	public long getByUseridCount(String userid) throws Exception {
		return answerdao.getByUseridCount(userid);
	}

	@Override
	public void updateStatus(int aid, int status) throws Exception {
		answerdao.updateStatus(aid, status);
	}
	
	public AnswerDao getAnswerdao() {
		return answerdao;
	}

	public void setAnswerdao(AnswerDao answerdao) {
		this.answerdao = answerdao;
	}

}
