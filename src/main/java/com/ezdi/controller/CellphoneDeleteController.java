package com.ezdi.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static com.ezdi.constant.CellphoneConstant.*;
import com.ezdi.dao.CellphoneDao;
import com.ezdi.model.WorkStatus;

@RestController
public class CellphoneDeleteController {
	@Autowired
	private CellphoneDao cpDao;

	@RequestMapping(SLASH + DELETE + SLASH + OPEN_BRAC + MODEL_ID + CLOSE_BRAC)
	public @ResponseBody WorkStatus delete(@PathVariable(value = MODEL_ID) String modelId) 
			throws IOException {
		if (SUCCESS.equals(cpDao.deleteModelInfo(Integer.parseInt(modelId)))) {
			return new WorkStatus(DELETE, SUCCESSFULLY_DONE);
		}
		return new WorkStatus(DELETE, FAILED + SLASH + NO_DATA_FOUND);
	}

}
