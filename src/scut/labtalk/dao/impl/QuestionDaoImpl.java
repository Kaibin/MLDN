package scut.labtalk.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import scut.labtalk.dao.QuestionDao;
import scut.labtalk.domain.Question;

@Repository("questiondao")
@Component
public class QuestionDaoImpl extends JpaDaoSupport implements QuestionDao {

	@Transactional
	public void insert(Question question) throws Exception {
		getJpaTemplate().persist(question);
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Question> queryByCommemflag(int commenflag, int currentPage, int lineSize) throws Exception {
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("SELECT q FROM Question q where q.commenflag=:commenflag ORDER BY q.questiontime desc");
		query.setParameter("commenflag", commenflag);
		query.setFirstResult((currentPage - 1) * lineSize);
        query.setMaxResults(lineSize);
		List<Question> all =  (List<Question>)query.getResultList();  
		return all;
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Question> queryByStatus(int status, int currentPage, int lineSize)
			throws Exception {	
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("SELECT q FROM Question q where q.status=:status ORDER BY q.questiontime desc");
		query.setParameter("status", status);
		query.setFirstResult((currentPage - 1) * lineSize);
        query.setMaxResults(lineSize);
		List<Question> all =  (List<Question>)query.getResultList();  
		return all;
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public Question queryById(String qid) throws Exception {
		Question q = null;
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("SELECT q FROM Question q where q.qid=:qid");
		query.setParameter("qid", qid);
		List<Question> all =  (List<Question>)query.getResultList();  
		if(all.size()>0){
			 q =  all.get(0);
		 }
		return q;
	}

	@Override
	public void updateClickcount(String qid) throws Exception {
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("UPDATE Question q SET q.clickcount=q.clickcount+1 WHERE q.qid=:qid");
		query.setParameter("qid", qid);
		em.getTransaction().begin();
		query.executeUpdate();
		em.getTransaction().commit();
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Question> queryByItem(String itemid, int currentPage, int lineSize)
			throws Exception {		
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("SELECT q FROM Question q where q.itemid=:itemid");
		query.setParameter("itemid", itemid);
		query.setFirstResult((currentPage - 1) * lineSize);
		query.setMaxResults(lineSize);
		List<Question> all =  (List<Question>)query.getResultList();  
		return all;
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Question> queryByLike(String cond, int currentPage, int lineSize)
			throws Exception {		
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("SELECT q FROM Question q where q.title like ? or q.content like ?");
		query.setParameter(1, "%" + cond + "%");
		query.setParameter(2,"%" + cond + "%");
		query.setFirstResult((currentPage - 1) * lineSize);
		query.setMaxResults(lineSize);
		List<Question> all =  (List<Question>)query.getResultList();  
		return all;
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Question> queryBySub(String subid, int currentPage, int lineSize)
			throws Exception {
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("SELECT q FROM Question q where q.subid=:subid");
		query.setParameter("subid", subid);
		query.setFirstResult((currentPage - 1) * lineSize);
		query.setMaxResults(lineSize);
		List<Question> all =  (List<Question>)query.getResultList();  
		return all;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Question> queryAll(int currentPage, int lineSize) throws Exception {
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("SELECT q FROM Question q");
		query.setFirstResult((currentPage - 1) * lineSize);
		query.setMaxResults(lineSize);
		List<Question> all =  (List<Question>)query.getResultList();  
		return all;
	}


	@Override
	@Transactional
	public long getCountByCommen(int commen) throws Exception {
		long count ;	
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("SELECT COUNT(q.qid) FROM Question q where q.commenflag=:commenflag");
		query.setParameter("commenflag", commen);
		Long temp  = (Long) query.getResultList().get(0);
		count = temp.longValue();
		return count;
	}

	@Override
	@Transactional
	public long getCountByItem(String itemid) throws Exception {
		long count ;	
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("SELECT COUNT(q.qid) FROM Question q where q.itemid=:itemid");
		query.setParameter("itemid", itemid);
		Long temp  = (Long) query.getResultList().get(0);
		count = temp.longValue();
		return count;
	}
	
	@Override
	@Transactional
	public long getCountBySub(String subid) throws Exception {
		long count ;	
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("SELECT COUNT(q.qid) FROM Question q where q.subid=:subid");
		query.setParameter("subid", subid);
		Long temp  = (Long) query.getResultList().get(0);
		count = temp.longValue();
		return count;
	}


	@Override
	@Transactional
	public long getCountByLike(String cond) throws Exception {
		long count ;	
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("SELECT COUNT(q.qid) FROM Question q where q.title like ? or q.content like ?");
		query.setParameter(1, "%" + cond + "%");
		query.setParameter(2,"%" + cond + "%");
		Long temp  = (Long) query.getResultList().get(0);
		count = temp.longValue();
		return count;
	}

	@Override
	public long getCountByStatus(int status) throws Exception {
		Long count;
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("SELECT COUNT(q.qid) FROM Question q where q.status=:status");
		query.setParameter("status", status);
		Long temp  = (Long) query.getResultList().get(0);
		count = temp.longValue();
		return count;
	}


	@Override
	@Transactional
	public long getCountByUserid(String userid) throws Exception {
		long count;	
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("SELECT COUNT(q.qid) FROM Question q where q.userid=:userid");
		query.setParameter("userid", userid);
		Long temp = (Long) query.getResultList().get(0);
		count = temp.longValue();
		return count;
	}
	
	@Override
	@Transactional
	public long getAllCount() throws Exception {
		long count;	
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("SELECT COUNT(q.qid) FROM Question");
		count = (Integer) query.getResultList().get(0);
		Long temp = (Long) query.getResultList().get(0);
		count = temp.longValue();
		return count;
	}



	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Question> queryByUserId(String userid, int currentPage, int lineSize)
			throws Exception {
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("SELECT q FROM Question q where q.userid=:userid");
		query.setParameter("userid", userid);
		query.setFirstResult((currentPage - 1) * lineSize);
		query.setMaxResults(lineSize);
		List<Question> all =  (List<Question>)query.getResultList();  
		return all;
	}

	@Override
	@Transactional
	public long getByUserAnswer(String userid) throws Exception {
		long count;
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("SELECT COUNT(q.qid) FROM Question q WHERE q.qid IN (SELECT a.qid FROM Answer a WHERE a.userid=:userid)");
		query.setParameter("userid", userid);
		count = (Integer) query.getResultList().get(0);
		Long temp = (Long) query.getResultList().get(0);
		count = temp.longValue();
		return count;
		
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Question> queryByUserAnswer(String userid, int currentPage, int lineSize) {
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("SELECT q From Question q WHERE q.qid IN (SELECT a.qid FROM Answer a WHERE a.userid=:userid");
		query.setParameter("userid", userid);
		query.setFirstResult((currentPage - 1) * lineSize);
		query.setMaxResults(lineSize);
		List<Question> all =  (List<Question>)query.getResultList();  
		return all;
	}

	@Override
	@Transactional
	public long getByAccept(String userid, int status) throws Exception {
		long count;
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("SELECT COUNT(q.qid) FROM Question q WHERE q.qid IN (SELECT a.qid FROM Answer a WHERE a.userid=:userid AND status=:status");
		query.setParameter("userid", userid);
		query.setParameter("status", status);
		Long temp = (Long) query.getResultList().get(0);
		count = temp.longValue();
		return count;
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Question> queryByAccept(String userid, int status, int currentPage,int lineSize) throws Exception {
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("SELECT q From Question q WHERE q.qid IN (SELECT a.qid FROM Answer a WHERE a.userid=:userid AND status=:status");
		query.setParameter("userid", userid);
		query.setParameter("status", status);
		query.setFirstResult((currentPage - 1) * lineSize);
		query.setMaxResults(lineSize);
		List<Question> all =  (List<Question>)query.getResultList();  
		return all;
	}

	@Override
	@Transactional
	public void updateAccept(String qid, int accept) throws Exception {
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("UPDATE Question q SET q.accept=:accept WHERE q.qid=:qid");
		query.setParameter("qid", qid);
		query.setParameter("accept", accept);
		query.executeUpdate();
	}

	@Override
	@Transactional
	public void updateStatus(String qid, int status) throws Exception {
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("UPDATE Question q SET q.status=:status WHERE q.qid=:qid");
		query.setParameter("qid", qid);
		query.setParameter("status", status);
		query.executeUpdate();
	}

	@Override
	@Transactional
	public void updateCommen(String qid, int commen) throws Exception {
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("UPDATE Question q SET q.commen=:commen WHERE q.qid=:qid");
		query.setParameter("qid", qid);
		query.setParameter("commen", commen);
		query.executeUpdate();
	}

	@Override
	@Transactional
	public void delete(String qid) throws Exception {
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("DELETE FROM Question q WHERE q.qid=:qid");
		query.setParameter("qid", qid);
		query.executeUpdate();
	}


}
