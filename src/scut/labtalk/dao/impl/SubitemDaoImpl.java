package scut.labtalk.dao.impl;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import scut.labtalk.dao.SubitemDao;
import scut.labtalk.domain.Subitem;
//@Repository("subitemdao")
//@Component
public class SubitemDaoImpl extends HibernateDaoSupport implements SubitemDao {

	@Transactional
	public void delete(int subid) throws Exception {
		String hql = "DELETE FROM Subitem WHERE subid=?";
		Query q = super.getSession().createQuery(hql);
		q.setInteger(0, subid);
		q.executeUpdate();

	}

	@Transactional
	public void insert(Subitem subitem) throws Exception {
		super.getSession().save(subitem);
	}

	@Transactional
	public void update(Subitem subitem) throws Exception {
		String hql = "UPDATE Subitem SET subname=?,subcode=? WHERE subid=?";
		Query q = super.getSession().createQuery(hql);
		q.setString(0, subitem.getSubname());
		q.setInteger(1, subitem.getSubcode());
		q.setString(2, subitem.getSubid());
		q.executeUpdate();
	}

}
