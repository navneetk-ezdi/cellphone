package com.ezdi.service;

import org.hibernate.Session;

import com.ezdi.model.CellphoneInfo;
public interface CellphoneDBService {
	
	public Session openSession();
	public int insertCellphoneInfo(Session session, CellphoneInfo cpInfo);
	public int insertCellphoneBrandInfo(Session session, CellphoneInfo cpInfo);
	public int deleteCellphoneInfo(Session session, int modelId);
	public CellphoneInfo getCellphoneInfo(Session session, int modelId);
	public void closeSession(Session session);

}
