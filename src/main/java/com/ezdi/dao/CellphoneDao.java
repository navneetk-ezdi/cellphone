package com.ezdi.dao;

import com.ezdi.model.CellphoneInfo;

public interface CellphoneDao {
	
	public CellphoneInfo viewModelInfo(int modelId);
	public String deleteModelInfo(int modelId);
	public String insertModelInfo(CellphoneInfo cpInfo);
	public String insertBrandInfo(CellphoneInfo cpInfo);
}
