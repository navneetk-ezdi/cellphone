package com.ezdi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezdi.dao.CellphoneDao;
import com.ezdi.model.CellphoneInfo;

@Controller
public class CellphoneViewController {
	@Autowired
	private CellphoneDao cpDao;

	
	@RequestMapping(value="/view/{modelId}",method = RequestMethod.GET,produces="application/json")
	public @ResponseBody CellphoneInfo view(@PathVariable(value="modelId") String modelId) {
	        CellphoneInfo cpInfo = cpDao.viewModelInfo(Integer.parseInt(modelId));
	        return cpInfo;
	    }

}
