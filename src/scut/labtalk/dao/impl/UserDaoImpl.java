package scut.labtalk.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import scut.labtalk.dao.UserDao;
import scut.labtalk.domain.User;

@Repository("userdao")
@Component
public class UserDaoImpl extends JpaDaoSupport implements UserDao {

	private Log logger = LogFactory.getLog(UserDaoImpl.class);
	
	@Transactional
	public void persist(User user) throws Exception {
			getJpaTemplate().persist(user);
		
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public User queryByUserid(String userid) throws Exception {   
		User user = null;
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("SELECT u FROM User u WHERE u.userid = :userid");
		query.setParameter("userid", userid);
		List<User> all =  (List<User>)query.getResultList();  
		if(all.size()>0){
			 user =  all.get(0);
		 }
        return user;
        }  
	
	@Transactional
	@SuppressWarnings("unchecked")
	public boolean isExists(String userid, String userques, String userans) throws Exception{
		boolean flag = false;
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("SELECT u FROM User u WHERE u.userid = :userid and u.userques=:userques and u.userans=:userans");
		query.setParameter("userid", userid).setParameter("userques",userques).setParameter("userans",userans);
		List<User> all =  (List<User>)query.getResultList();  
		if (all.size() > 0) {
			flag = true;
		}
		return flag;
           
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public boolean login(User user) throws Exception {
		boolean flag = false;			
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("SELECT u FROM User u WHERE u.userid = :userid and u.userpwd=:userpwd");
		query.setParameter("userid", user.getUserid()).setParameter("userpwd",user.getUserpwd());
		List<User> all =  (List<User>)query.getResultList();  
		if (all.size() > 0) {
			flag = true;
			User t = (User) all.get(0);
			user.setGrade(t.getGrade());
		}
		return flag;
	}

	@Transactional
	public void updateUserpwd(String userid, String userpwd) throws Exception {	
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("UPDATE User u SET u.userpwd=:userpwd WHERE u.userid=:userid");
		query.setParameter("userpwd", userpwd).setParameter("userid",userid);
		query.executeUpdate();
	}
	
	@Transactional
	public void addIntegral(String userid, int itergral) throws Exception {
	    
//	    EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();
//	    em.getTransaction().begin();
//		Query query = em.createQuery("SELECT u FROM User u WHERE u.userid = :userid");
//		query.setParameter("userid", userid);
//		User user = (User) query.getResultList().get(0);
//		user.setIntegral(user.getIntegral() + itergral);
//		user.setGrade(scut.labtalk.util.IntegralGrade.getInstance().getGrade(user.getIntegral()));
//	    query = em.createQuery("UPDATE User u SET u.integral=:integral,u.grade=:grade WHERE u.userid=:userid");
//		query.setParameter("integral",  user.getIntegral()).setParameter("grade", user.getGrade()).setParameter("userid",userid);
//		query.executeUpdate();
//		em.getTransaction().commit();
		
	    EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("SELECT u FROM User u WHERE u.userid = :userid");
		query.setParameter("userid", userid);
		User user = (User) query.getResultList().get(0);
		user.setIntegral(user.getIntegral() + itergral);
		user.setGrade(scut.labtalk.util.IntegralGrade.getInstance().getGrade(user.getIntegral()));
		em.merge(user);
	}

	@Transactional
	public void update(User user) throws Exception {
		getJpaTemplate().merge(user);
	}

	@Transactional
	public void delete(User user) throws Exception {
		user = getJpaTemplate().getReference(User.class, user.getId());
		getJpaTemplate().remove(user);
		
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<User> queryAll(int currentPage, int lineSize) throws Exception {
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("SELECT u FROM User u");
		query.setFirstResult((currentPage - 1) * lineSize);
        query.setMaxResults(lineSize);
		List<User> all =  (List<User>)query.getResultList();  
		return all;
	}

	@Transactional
	public int getAllCount() throws Exception {
		int count = 0;		
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("SELECT COUNT(u.id) FROM User AS u");
		count = (Integer) query.getResultList().get(0);
		return count;
	}

	@Transactional
	public void updateIntegral(String userid, int integral) throws Exception {
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager(); 
		Query query = em.createQuery("UPDATE User u SET u.integral=:integral WHERE u.userid=:userid");
		query.setParameter("integral",integral).setParameter("userid", userid);
		query.executeUpdate();
	}

}
