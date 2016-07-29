package com.ezdi.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static com.ezdi.constant.CellphoneConstant.*;
import com.ezdi.dao.CellphoneDao;
import com.ezdi.model.CellphoneInfo;
import com.ezdi.model.WorkStatus;

@RestController
public class CellphoneInsertController {
	@Autowired
	private CellphoneDao cpDao;

	@RequestMapping(SLASH + INSERT)
	public @ResponseBody WorkStatus insert(HttpServletRequest request) throws IOException {
		CellphoneInfo cpInfo = new CellphoneInfo();
		cpInfo.setBrandName(request.getParameter(C_BRAND_NAME));
		cpInfo.setModelName(request.getParameter(MODEL_NAME));
		cpInfo.setModelColor(request.getParameter(MODEL_COLOR));
		cpInfo.setModelType(request.getParameter(MODEL_TYPE));
		cpInfo.setModelScreenSize(Float.parseFloat(request.getParameter(MODEL_SCREEN_SIZE)));
		cpInfo.setModelLength(Float.parseFloat(request.getParameter(MODEL_LENGTH)));
		cpInfo.setModelBreadth(Float.parseFloat(request.getParameter(MODEL_BREADTH)));
		cpInfo.setModelThickness(Float.parseFloat(request.getParameter(MODEL_THICKNESS)));
		cpInfo.setModelOS(request.getParameter(MODEL_OS));
		cpInfo.setModelProcessor(request.getParameter(MODEL_PROCESSOR));
		cpInfo.setModelRAM(Integer.parseInt(request.getParameter(MODEL_RAM)));
		cpInfo.setModelInternalMemory(Integer.parseInt(request.getParameter(MODEL_INTERNAL_MEMORY)));
		if (SUCCESS.equals(cpDao.insertModelInfo(cpInfo))) {
			return new WorkStatus(INSERT, SUCCESSFULLY_DONE);
		}
		return new WorkStatus(INSERT, FAILED);
	}

	@RequestMapping(SLASH + INSERT + SLASH + BRAND_ID + SLASH + OPEN_BRAC + BRAND_ID + CLOSE_BRAC 
			+ SLASH + BRAND_NAME + SLASH + OPEN_BRAC + BRAND_NAME + CLOSE_BRAC)
	public @ResponseBody WorkStatus insert(@PathVariable(value = BRAND_ID) String brandId,
			@PathVariable(value = BRAND_NAME) String brandName, HttpServletRequest request) {
		CellphoneInfo cpInfo = new CellphoneInfo();
		cpInfo.setBrandName(brandName);
		cpInfo.setId(Integer.parseInt(brandId));
		if (SUCCESS.equals(cpDao.insertBrandInfo(cpInfo))) {
			return new WorkStatus(INSERT, SUCCESSFULLY_DONE);
		}
		return new WorkStatus(INSERT, FAILED);
	}

}
