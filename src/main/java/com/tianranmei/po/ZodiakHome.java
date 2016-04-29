package com.tianranmei.po;
// Generated 2016-4-21 16:21:24 by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Zodiak.
 * @see com.tianranmei.po.Zodiak
 * @author Hibernate Tools
 */
public class ZodiakHome {

	private static final Log log = LogFactory.getLog(ZodiakHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Zodiak transientInstance) {
		log.debug("persisting Zodiak instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Zodiak instance) {
		log.debug("attaching dirty Zodiak instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Zodiak instance) {
		log.debug("attaching clean Zodiak instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Zodiak persistentInstance) {
		log.debug("deleting Zodiak instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Zodiak merge(Zodiak detachedInstance) {
		log.debug("merging Zodiak instance");
		try {
			Zodiak result = (Zodiak) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Zodiak findById(java.lang.Integer id) {
		log.debug("getting Zodiak instance with id: " + id);
		try {
			Zodiak instance = (Zodiak) sessionFactory.getCurrentSession().get("com.tianranmei.po.Zodiak", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Zodiak instance) {
		log.debug("finding Zodiak instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.tianranmei.po.Zodiak")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
