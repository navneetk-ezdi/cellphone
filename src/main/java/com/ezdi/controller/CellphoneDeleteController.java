package com.ezdi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ezdi.dao.CellphoneDao;
import com.ezdi.model.WorkStatus;

@RestController
public class CellphoneDeleteController {
	@Autowired
	private CellphoneDao cpDao;

	@RequestMapping("/delete/{modelId}")
	public @ResponseBody WorkStatus delete(@PathVariable(value="modelId") String modelId) {
		
	        if("SUCCESS".equals(cpDao.deleteModelInfo(Integer.parseInt(modelId)))) {
				return new WorkStatus("INSERT","SUCCESSFULLY DONE");
			}
			return new WorkStatus("INSERT","FAILED");
	    }

}
