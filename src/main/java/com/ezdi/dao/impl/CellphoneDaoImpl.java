package com.ezdi.dao.impl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.ezdi.constant.CellphoneConstant.*;
import com.ezdi.dao.CellphoneDao;
import com.ezdi.model.CellphoneInfo;
import com.ezdi.service.CellphoneDBService;
@Component
public class CellphoneDaoImpl implements CellphoneDao {
	@Autowired
	private CellphoneDBService cpService;

	public void setCpService(CellphoneDBService cpService) {
		this.cpService = cpService;
	}
	
	public CellphoneInfo viewModelInfo(int modelId) {
		CellphoneInfo ci = new CellphoneInfo();
		Session session = cpService.openSession();
		ci = cpService.getCellphoneInfo(session, modelId);
		cpService.closeSession(session);
		return ci;
	}

	public String deleteModelInfo(int modelId) {
		String delStatus = SUCCESS;
		Session session = cpService.openSession();
		if(cpService.deleteCellphoneInfo(session, modelId) == 0) {
			delStatus = FAILURE;
		}
		cpService.closeSession(session);
		return delStatus;
	}

	public String insertModelInfo(CellphoneInfo cpInfo) {
		String insStatus = SUCCESS;
		Session session = cpService.openSession();
		if(cpService.insertCellphoneInfo(session, cpInfo) == 0) {
			insStatus = FAILURE;
		}
		cpService.closeSession(session);
		return insStatus;
	}
	
	public String insertBrandInfo(CellphoneInfo cpInfo) {
		String insStatus = SUCCESS;
		Session session = cpService.openSession();
		if(cpService.insertCellphoneBrandInfo(session, cpInfo) == 0) {
			insStatus = FAILURE;
		}
		cpService.closeSession(session);
		return insStatus;
	}
	

}
