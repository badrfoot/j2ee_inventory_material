package com.j2ee.java.model.bo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.j2ee.java.model.dao.HibernateUtil;
import com.j2ee.java.model.dao.ProviderDAO;
import com.j2ee.java.model.dao.ProviderDAOImpl;
import com.j2ee.java.model.dto.Provider;

public class ProviderBOImpl implements ProviderBO {

	private static final Logger logger = LoggerFactory.getLogger(ProviderBOImpl.class);
	
	private static ProviderDAO providerDAO = new ProviderDAOImpl();

	@Override
	public Provider getByID(int id) {
		// TODO Auto-generated method stub
		Provider provider = null;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			provider = providerDAO.getByID(id);

			tx.commit();
		} catch (Exception ex) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
		return provider;
	}

	@Override
	public List<Provider> getAllProvider() {
		// TODO Auto-generated method stub
		List<Provider> listProvider = new ArrayList<Provider>();
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			listProvider = providerDAO.getAllProvider();

			tx.commit();
		} catch (Exception ex) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
		return listProvider;
	}

	@Override
	public boolean insertProvider(Provider Provider) {
		// TODO Auto-generated method stub
		boolean result = false;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			result = providerDAO.insertProvider(Provider);
			
			tx.commit();
		} catch (Exception ex) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
		return result;
	}

	@Override
	public boolean updateProvider(Provider Provider) {
		// TODO Auto-generated method stub
		boolean result = false;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			result = providerDAO.updateProvider(Provider);
			
			tx.commit();
		} catch (Exception ex) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
		return result;
	}

	@Override
	public boolean deleteProvider(Provider Provider) {
		// TODO Auto-generated method stub
		boolean result = false;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			result = providerDAO.deleteProvider(Provider);
			
			tx.commit();
		} catch (Exception ex) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
		return result;
	}

}
