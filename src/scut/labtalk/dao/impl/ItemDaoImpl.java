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

import scut.labtalk.dao.ItemDao;
import scut.labtalk.domain.Item;
@Repository("itemdao")
@Component
public class ItemDaoImpl extends JpaDaoSupport implements ItemDao {


	private Log logger = LogFactory.getLog(UserDaoImpl.class);
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Item> queryAll() throws Exception {	
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("SELECT i FROM Item i");
		List <Item> all = (List<Item>)query.getResultList();
		return all;

	}

	@Override
	@Transactional
	public void delete(Item item) throws Exception {
		item = getJpaTemplate().getReference(Item.class, item.getItemid());
		getJpaTemplate().remove(item);
		
	}

	public void insert(Item item) throws Exception {
		getJpaTemplate().persist(item);
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public Item queryById(String itemid) throws Exception {
		Item item = null;
		EntityManager em = this.getJpaTemplate().getEntityManagerFactory().createEntityManager();  		
		Query query = em.createQuery("SELECT i FROM Item i WHERE i.itemid = :itemid");
		query.setParameter("itemid", itemid);
		List<Item> all =  (List<Item>)query.getResultList();  
		if(all.size()>0){
			 item =  all.get(0);
		 }
        return item;
	}

	@Override
	@Transactional
	public void update(Item item) throws Exception {
		getJpaTemplate().merge(item);
	}

}
