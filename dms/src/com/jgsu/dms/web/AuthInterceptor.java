package com.jgsu.dms.web;

import org.springframework.stereotype.Component;

import com.jgsu.dms.exception.DocumentException;
import com.jgsu.dms.model.User;
import com.jgsu.dms.util.ActionUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
@Component("authInterceptor")
public class AuthInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//1、获取action的名称
		String an = invocation.getProxy().getActionName();
		if(!an.startsWith("login")) {
			User loginUser = (User)ActionContext.getContext().getSession().get("loginUser");
			if(loginUser==null) return "login";
			//来进行其他权限控制
			if(loginUser.getType()!=1) {
				//普通用户
				if(!ActionUtil.checkUrl(an)) {
					throw new DocumentException("需要管理员才能访问该功能");
				}
			}
		}
		return invocation.invoke();
	}

}
