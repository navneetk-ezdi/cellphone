package com.ezdi.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Component;

import com.ezdi.model.CellphoneBrand;
import com.ezdi.model.CellphoneInfo;
import com.ezdi.model.CellphoneModel;
import com.ezdi.service.CellphoneDBService;
@Component
public class CellphoneDBServiceImpl implements CellphoneDBService {

	public Session openSession() {
		// loads configuration and mappings
        Configuration configuration = new Configuration().configure();
        ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
        registry.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
         
        // builds a session factory from the service registry
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
         
        // obtains the session
        Session session = sessionFactory.openSession();
		return session;
	}

	public int insertCellphoneBrandInfo(Session session, CellphoneInfo cpInfo) {
		session.beginTransaction();
        
        // creates a Cellphone Model entity
        CellphoneBrand cb = new CellphoneBrand();
        cb.setBrandName(cpInfo.getBrandName());
        cb.setId(cpInfo.getId());
         
        // persists the cellphone information
        int cpId = (Integer) session.save(cb);
        
        session.getTransaction().commit();
		return cpId;
	}
	
	public int insertCellphoneInfo(Session session, CellphoneInfo cpInfo) {
		session.beginTransaction();
        
        // creates a Cellphone Model entity
        CellphoneModel cm = new CellphoneModel();
        cm.setModelName(cpInfo.getModelName());
        cm.setModelColor(cpInfo.getModelColor());
        cm.setModelScreenSize(cpInfo.getModelScreenSize());
        cm.setModelType(cpInfo.getModelType());
        cm.setModelOS(cpInfo.getModelOS());
        cm.setModelProcessor(cpInfo.getModelProcessor());
        cm.setModelRAM(cpInfo.getModelRAM());
        cm.setModelInternalMemory(cpInfo.getModelInternalMemory());
        cm.setModelLength(cpInfo.getModelLength());
        cm.setModelBreadth(cpInfo.getModelBreadth());
        cm.setModelThickness(cpInfo.getModelThickness());
        cm.setModelReleaseDate(new java.sql.Date(System.currentTimeMillis()));
        CellphoneBrand cb = new CellphoneBrand();
        cb.setBrandName(cpInfo.getBrandName());
        cm.setCellphoneBrand(cb);
         
        // persists the cellphone information
        int cpId = (Integer) session.save(cm);
        
        session.getTransaction().commit();
		return cpId;
	}

	public int deleteCellphoneInfo(Session session, int modelId) {
		CellphoneModel cpModel = new CellphoneModel();
		cpModel.setId(modelId);
		session.delete(cpModel);
		CellphoneModel cModel = (CellphoneModel) session.get(CellphoneModel.class, modelId);
		if(null == cModel) {
			return 1;
		}
		return 0;
	}

	public CellphoneInfo getCellphoneInfo(Session session, int modelId) {
		// gets the book entity back
        CellphoneModel cModel = (CellphoneModel) session.get(CellphoneModel.class, modelId);
        if(null != cModel) {
        	CellphoneInfo cpInfo = new CellphoneInfo();
        	CellphoneBrand cBrand = cModel.getCellphoneBrand();
        	cpInfo.setId(cModel.getId());
        	cpInfo.setBrandName(cBrand.getBrandName());
        	cpInfo.setModelName(cModel.getModelName());
        	cpInfo.setModelType(cModel.getModelType());
        	cpInfo.setModelScreenSize(cModel.getModelScreenSize());
        	cpInfo.setModelOS(cModel.getModelOS());
        	cpInfo.setModelProcessor(cModel.getModelProcessor());
        	cpInfo.setModelRAM(cModel.getModelRAM());
        	cpInfo.setModelInternalMemory(cModel.getModelInternalMemory());
        	cpInfo.setModelLength(cModel.getModelLength());
        	cpInfo.setModelBreadth(cModel.getModelBreadth());
        	cpInfo.setModelThickness(cModel.getModelThickness());
        	cpInfo.setModelColor(cModel.getModelColor());
        	cpInfo.setModelReleaseDate(cModel.getModelReleaseDate());
        	return cpInfo;
        }
		return null;
	}

	public void closeSession(Session session) {
		session.close();
	}

}
