package com.caoruiqun.admin.web;

import com.caoruiqun.admin.common.utils.MyCookieUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: 10-p2p-admin
 * @description:
 * @author: CaoRuiqun
 * @create: 2020-01-05 18:40
 **/
@Controller
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    /**
     * 后台系统首页
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String index(HttpServletRequest request, Model model) {

        //从cookie中读取用户名
        String userName = MyCookieUtils.getCookieValueByName(request, "userName");
        //从cookie中读取用户密码
        String password = MyCookieUtils.getCookieValueByName(request, "password");

        if (StringUtils.isNotEmpty(userName) && StringUtils.isNotEmpty(password)) {

            model.addAttribute("userName", userName);
            model.addAttribute("password", password);
            model.addAttribute("isAutoLogin", 1); //给页面传递一个免登陆标记，1表示7天免登录
        }
        return "index";
    }
}
