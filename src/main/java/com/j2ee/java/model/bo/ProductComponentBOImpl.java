package com.j2ee.java.model.bo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.j2ee.java.model.dao.HibernateUtil;
import com.j2ee.java.model.dao.ProductComponentDAO;
import com.j2ee.java.model.dao.ProductComponentDAOImpl;
import com.j2ee.java.model.dto.ProductComponent;

public class ProductComponentBOImpl implements ProductComponentBO {

	private static final Logger logger = LoggerFactory.getLogger(ProductComponentBOImpl.class);
	
	private static ProductComponentDAO ProductComponentDAO = new ProductComponentDAOImpl();
	
	@Override
	public ProductComponent getByID(int id) {
		// TODO Auto-generated method stub
		ProductComponent ProductComponent = null;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			ProductComponent = ProductComponentDAO.getByID(id);

			tx.commit();
		} catch (Exception ex) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
		return ProductComponent;
	}

	@Override
	public List<ProductComponent> getAllProductComponent() {
		// TODO Auto-generated method stub
		List<ProductComponent> listProductComponent = new ArrayList<ProductComponent>();
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			listProductComponent = ProductComponentDAO.getAllProductComponent();

			tx.commit();
		} catch (Exception ex) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error", ex);
		}
		return listProductComponent;
	}

	@Override
	public boolean insertProductComponent(ProductComponent productComponent) {
		// TODO Auto-generated method stub
		boolean result = false;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			result = ProductComponentDAO.insertProductComponent(productComponent);
			
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
	public boolean updateProductComponent(ProductComponent productComponent) {
		// TODO Auto-generated method stub
		boolean result = false;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			result = ProductComponentDAO.updateProductComponent(productComponent);
			
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
	public boolean deleteProductComponent(ProductComponent productComponent) {
		// TODO Auto-generated method stub
		boolean result = false;
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();

			result = ProductComponentDAO.deleteProductComponent(productComponent);
			
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
