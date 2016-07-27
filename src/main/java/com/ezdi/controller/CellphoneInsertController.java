package com.ezdi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ezdi.dao.CellphoneDao;
import com.ezdi.model.CellphoneInfo;
import com.ezdi.model.WorkStatus;

@RestController
public class CellphoneInsertController {
	@Autowired
	private CellphoneDao cpDao;

	@RequestMapping("/insert")
	public @ResponseBody WorkStatus insert(HttpServletRequest request) {
		CellphoneInfo cpInfo = new CellphoneInfo();
		cpInfo.setBrandName(request.getParameter("brandName"));
		cpInfo.setModelName(request.getParameter("modelName"));
		cpInfo.setModelColor(request.getParameter("modelColor"));
		cpInfo.setModelType(request.getParameter("modelType"));
		cpInfo.setModelScreenSize(Float.parseFloat(request.getParameter("modelScreenSize")));
		cpInfo.setModelLength(Float.parseFloat(request.getParameter("modelLength")));
		cpInfo.setModelBreadth(Float.parseFloat(request.getParameter("modelBreadth")));
		cpInfo.setModelThickness(Float.parseFloat(request.getParameter("modelThickness")));
		cpInfo.setModelOS(request.getParameter("modelOS"));
		cpInfo.setModelProcessor(request.getParameter("modelProcessor"));
		cpInfo.setModelRAM(Integer.parseInt(request.getParameter("modelRAM")));
		cpInfo.setModelInternalMemory(Integer.parseInt(request.getParameter("modelInternalMemory")));
		if ("SUCCESS".equals(cpDao.insertModelInfo(cpInfo))) {
			return new WorkStatus("INSERT", "SUCCESSFULLY DONE");
		}
		return new WorkStatus("INSERT", "FAILED");
	}

	@RequestMapping("/insert/brandid/{brandId}/brandname/{brandName}")
	public @ResponseBody WorkStatus insert(@PathVariable(value = "brandId") String brandId,
			@PathVariable(value = "brandName") String brandName, HttpServletRequest request) {
		CellphoneInfo cpInfo = new CellphoneInfo();
		cpInfo.setBrandName(brandName);
		cpInfo.setId(Integer.parseInt(brandId));
		if ("SUCCESS".equals(cpDao.insertBrandInfo(cpInfo))) {
			return new WorkStatus("INSERT", "SUCCESSFULLY DONE");
		}
		return new WorkStatus("INSERT", "FAILED");
	}

}
