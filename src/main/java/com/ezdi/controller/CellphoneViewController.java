package com.ezdi.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.ezdi.constant.CellphoneConstant.*;
import com.ezdi.dao.CellphoneDao;
import com.ezdi.model.CellphoneInfo;

@Controller
public class CellphoneViewController {
	@Autowired
	private CellphoneDao cpDao;

	@RequestMapping(value = SLASH + VIEW + SLASH + OPEN_BRAC + MODEL_ID + CLOSE_BRAC, 
			method = RequestMethod.GET, produces = APP_JSON)
	public @ResponseBody CellphoneInfo view(@PathVariable(value = MODEL_ID) String modelId) 
			throws IOException {
			CellphoneInfo cpInfo = cpDao.viewModelInfo(Integer.parseInt(modelId));
			if(null == cpInfo) {
				cpInfo = new CellphoneInfo();
				cpInfo.setWorkName(VIEW);
	        	cpInfo.setWorkStatus(NO_DATA_FOUND);
			}
			return cpInfo;
	}

}
