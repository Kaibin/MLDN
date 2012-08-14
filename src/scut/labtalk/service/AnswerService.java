package scut.labtalk.service;

import java.util.List;

import scut.labtalk.domain.Answer;

public interface AnswerService {

	// �ش�����
	public void insert(Answer answer) throws Exception ;
	// ȡ���û����˵Ļش��¼
	public List<Answer> queryByUserid(String userid,int currentPage,int lineSize) throws Exception ;
	// ȡ���û����˻ش��¼������
	public long getByUseridCount(String userid) throws Exception ;
	// ����״̬
	public void updateStatus(int aid, int status) throws Exception ;
}
