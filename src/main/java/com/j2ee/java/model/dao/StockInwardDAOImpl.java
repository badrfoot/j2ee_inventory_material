package com.j2ee.java.model.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.j2ee.java.model.dto.StockInward;

public class StockInwardDAOImpl implements StockInwardDAO {

	static Logger logger = Logger.getLogger(StockInwardDAOImpl.class.getName());
	@Override
	public StockInward getByID(int id) {
		
		return (StockInward) HibernateUtil.getSessionFactory().getCurrentSession()
				.get(StockInward.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StockInward> getAllStockInward() {
		
		return HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("from StockInward").list();
	}

	@Override
	public boolean insertStockInward(StockInward stockInward) {
		
		boolean result = false;
		try {
			HibernateUtil.getSessionFactory().getCurrentSession()
					.save(stockInward);
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't save StockInward");
		}
		return result;
	}

	@Override
	public boolean updateStockInward(StockInward stockInward) {
		
		boolean result = false;
		try {
			HibernateUtil.getSessionFactory().getCurrentSession()
					.update(stockInward);
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't update StockInward");
		}
		return result;
	}

	@Override
	public boolean deleteStockInward(StockInward stockInward) {
		
		boolean result = false;
		try {
			HibernateUtil.getSessionFactory().getCurrentSession()
					.delete(stockInward);
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Can't delete StockInward");
		}
		return result;
	}

}
