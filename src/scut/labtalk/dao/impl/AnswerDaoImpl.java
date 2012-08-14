package scut.labtalk.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import scut.labtalk.dao.AnswerDao;
import scut.labtalk.domain.Answer;
@Repository("answerdao")
@Component
public class AnswerDaoImpl extends JpaDaoSupport implements AnswerDao {

	@Transactional
	public void insert(Answer answer) throws Exception {
		super.getJpaTemplate().persist(answer);
	}

	public long getByUseridCount(String userid) throws Exception {
		int count = 0;	
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("SELECT COUNT(a.aid) FROM Answer a where a.userid=:userid");
		query.setParameter("userid", userid);
		count = (Integer) query.getResultList().get(0);
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<Answer> queryByUserid(String userid, int currentPage, int lineSize)
			throws Exception {
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("SELECT a FROM Answer a where a.userid=:userid");
		query.setParameter("userid", userid);
		query.setFirstResult((currentPage - 1) * lineSize);
		query.setMaxResults(lineSize);
		List<Answer> all =  (List<Answer>)query.getResultList();  
		return all;
	}

	public void updateStatus(int aid, int status) throws Exception {
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  
		Query query = em.createQuery("UPDATE Answer a SET a.status=:status WHERE a.aid=:aid");
		query.setParameter("aid", aid);
		query.setParameter("status", status);
		em.getTransaction().begin();
		query.executeUpdate();
		em.getTransaction().commit();
	}
}
