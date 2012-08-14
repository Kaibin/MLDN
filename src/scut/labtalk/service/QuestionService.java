package scut.labtalk.service;

import java.util.List;

import scut.labtalk.domain.Question;

public interface QuestionService {
	// ����Item����ȫ������������
	public long getCountByItem(String itemid) throws Exception;

	// ����itemid����ȫ������������
	public long getCountBySub(String subid) throws Exception;

	// �����Ƽ�����ȫ������������
	public long getCountByCommen(int commen) throws Exception;

	// ����״̬����ȫ������������
	public long getCountByStatus(int status) throws Exception;

	// ����ģ����ѯ����ȫ������������
	public long getCountByLike(String cond) throws Exception;
	
	// ���һ���û����������
	public long getCountByUserid(String userid) throws Exception;

	// ��������
	public void save(Question question) throws Exception;

	// �����Ƽ�����
	// 1���Ƽ�
	// 0�����Ƽ�
	public List<Question> queryByCommemflag(int commenflag, int currentPage, int lineSize)
			throws Exception;

	// �����װ��������
	// 1��δ���
	// 2���ѽ��
	// 3���������
	public List<Question> queryByStatus(int status, int currentPage, int lineSize)
			throws Exception;

	// ����IDȡ������
	public Question queryById(String qid) throws Exception;

	// �޸��������
	public void updateClickcount(String qid) throws Exception;

	// ��һ����Ŀ����
	public List<Question> queryByItem(String itemid, int currentPage, int lineSize)
			throws Exception;

	// ��������Ŀ����
	public List<Question> queryBySub(String subid, int currentPage, int lineSize)
			throws Exception;

	// ģ����ѯ
	public List<Question> queryByLike(String cond, int currentPage, int lineSize)
			throws Exception;

	// �г�һ���û������ȫ������
	public List<Question> queryByUserId(String userid, int currentPage, int lineSize)
			throws Exception;

	// �г��û��ش��������
	public List<Question> queryByUserAnswer(String userid, int currentPage, int lineSize);

	// �г��û��ش�������������
	public long getByUserAnswer(String userid) throws Exception;

	// �г�һ���û������ɵ�����
	public List<Question> queryByAccept(String userid, int status, int currentPage,
			int lineSize) throws Exception;

	// �г�һ���û����������������
	public long getByAccept(String userid, int status) throws Exception;

	// ���Ƿ��Ѳ��ɹ�
	public void updateAccept(String qid, int accept) throws Exception;

	// ���ô�״̬�������⡢δ������ѽ��
	public void updateStatus(String qid, int status) throws Exception;

	// ɾ������
	public void delete(String qid) throws Exception;

	// �г�ȫ������

	public List<Question> queryAll(int currentPage, int lineSize) throws Exception;

	// �õ�ȫ�������ݴ�С
	public long getAllCount() throws Exception;
	
	// �����Ƽ�����
	public void updateCommen(String qid,int commen) throws Exception ;
}
