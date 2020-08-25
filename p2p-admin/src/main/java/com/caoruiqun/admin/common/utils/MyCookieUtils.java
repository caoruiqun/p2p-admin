package com.caoruiqun.admin.common.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie操作工具类
 *
 * @author Felix
 *
 */
public class MyCookieUtils {

	/**
	 * 设置cookie
	 * 
	 * @param response
	 * @param name cookie名字
	 * @param value cookie值
	 * @param maxAge cookie生命周期 以秒为单位
	 */
	public static void addCookie(HttpServletRequest request,HttpServletResponse response, String name, String value, int maxAge) {
		Cookie cookie = new Cookie(name, value);
		//将cookie放到项目的上下文根下
		cookie.setPath(request.getContextPath());
		//设置时间
		if (maxAge > 0) {
			cookie.setMaxAge(maxAge);
		}
		//通过response向浏览器响应cookie
		response.addCookie(cookie);
	}
	
	/**
	 * 根据cookie名称获取cookie的值
	 * 
	 * @param request
	 * @param name
	 * @return
	 */
	public static String getCookieValueByName (HttpServletRequest request, String name) {
		String cookieValue = "";
		//获取当前站点的所有Cookie
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			//对cookies中的数据进行遍历，找到用户名、密码的数据
			for (int i=0; i<cookies.length; i++) {
				if (name.equals(cookies[i].getName())) {
					cookieValue = cookies[i].getValue();
					break;
				}
			}
		}
		return cookieValue;
	}
	
	/**
	 * 根据cookie名称获取cookie的值
	 * 
	 * @param request
	 * @param name
	 * @return
	 */
	public static void removeCookieValueByName (HttpServletRequest request, HttpServletResponse response, String name) {
		//获取当前站点的所有Cookie
		Cookie[] cookies = request.getCookies();
		//对cookies中的数据进行遍历，找到用户名、密码的数据
//		for (Cookie cookie : cookies) {
//			if (name.equals(cookie.getName())) {
//				cookie.setValue(null);
//				cookie.setPath("/");
//				cookie.setMaxAge(0);
//				response.addCookie(cookie);
//				break;
//			}
//		}

		try
		{
			for(int i=0;i<cookies.length;i++)
			{
				//System.out.println(cookies[i].getName() + ":" + cookies[i].getValue());
				Cookie cookie = new Cookie(cookies[i].getName(), null);
				cookie.setMaxAge(0);
				cookie.setPath(request.getContextPath());//根据你创建cookie的路径进行填写
				response.addCookie(cookie);
			}
		}catch(Exception ex)
		{
			System.out.println("清空Cookies发生异常！");
		}

	}
}