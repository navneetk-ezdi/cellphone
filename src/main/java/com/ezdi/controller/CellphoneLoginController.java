package com.ezdi.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.ezdi.constant.CellphoneConstant.*;

@Controller
public class CellphoneLoginController {

	@RequestMapping(value=SLASH + DENIED)
	public String denied(HttpServletRequest request, Model model) throws IOException{
		return DENIED;
	}
	
	@RequestMapping(value=SLASH + HOME)
	public String home(HttpServletRequest request, Model model) throws IOException{
		return HOME;
	}
	
	@RequestMapping(value=SLASH + GOTOINSERT)
	public String insert(HttpServletRequest request, Model model) throws IOException{
		return INSERT;
	}
}
