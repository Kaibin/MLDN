package scut.labtalk.service;

import java.util.List;

import scut.labtalk.domain.Answer;

public interface AnswerService {

	// 回答问题
	public void insert(Answer answer) throws Exception ;
	// 取得用户个人的回答记录
	public List<Answer> queryByUserid(String userid,int currentPage,int lineSize) throws Exception ;
	// 取得用户个人回答记录的数量
	public long getByUseridCount(String userid) throws Exception ;
	// 更新状态
	public void updateStatus(int aid, int status) throws Exception ;
}
