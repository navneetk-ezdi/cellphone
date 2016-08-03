package com.ezdi.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.ezdi.constant.CellphoneConstant.*;

@Controller
public class CellphoneLoginController {

	@RequestMapping(value=SLASH + DENIED)
	public String denied(HttpServletRequest request, Model model) throws IOException{
		return DENIED;
	}
	
	@RequestMapping(value=SLASH + HOME)
	public String home(HttpServletRequest request, Model model) throws IOException{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(null != authentication) {
			String userName = authentication.getName();
			request.getSession().setAttribute("username", userName);
		} else {
			request.getSession().setAttribute("sessionid", request.getSession().getId());
		}
		return HOME;
	}
	
	@RequestMapping(value=SLASH + GOTOINSERT)
	public String insert(HttpServletRequest request, Model model) throws IOException{
		return INSERT;
	}
	
	@RequestMapping(value=SLASH + LOGOUT, method=RequestMethod.POST)
	public String logout(HttpServletRequest request, Model model) throws IOException{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		authentication.setAuthenticated(false);
		request.getSession().invalidate();
		return LOGOUT;
	}
	
	@RequestMapping(value=SLASH + EXPIRED)
	public String expired(HttpServletRequest request, Model model) throws IOException{
		return EXPIRED;
	}
	
	@RequestMapping(value=SLASH + INVALID)
	public String invalid(HttpServletRequest request, Model model) throws IOException{
		return INVALID;
	}
	
	@RequestMapping(value=SLASH + LOGIN)
	public String login(HttpServletRequest request, Model model) throws IOException{
		return LOGIN;
	}
}
