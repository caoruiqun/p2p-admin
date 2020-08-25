package com.caoruiqun.admin.web;

import com.caoruiqun.admin.common.constants.Constants;
import com.caoruiqun.admin.common.rto.ReturnObject;
import com.caoruiqun.admin.common.utils.MyCookieUtils;
import com.caoruiqun.admin.model.StaffInfo;
import com.caoruiqun.admin.model.UserInfo;
import com.caoruiqun.admin.service.StaffInfoService;
import com.caoruiqun.admin.service.UserInfoService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: 10-p2p-admin
 * @description:
 * @author: CaoRuiqun
 * @create: 2020-01-05 19:35
 **/
@Controller
public class UserController {

    /**
     * log4j2 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * 注入UserInfoService
     */
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 注入StaffInfoService
     */
    @Autowired
    private StaffInfoService staffInfoService;

    /**
     * 用户登录
     *
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping("/admin/login")
    @ResponseBody
    public ReturnObject login(HttpServletRequest request, HttpServletResponse response,
                              @RequestParam(name = "userName", required = false) String userName,
                              @RequestParam(name = "password", required = false) String password,
                              @RequestParam(name = "rememberMe", required = false) boolean rememberMe) {

        logger.info("用户登录-->userName={}", userName);

        ReturnObject returnObject = new ReturnObject();

        //服务端对参数再次进行验证，验证用户名不能为空
        if (StringUtils.isEmpty(userName)) {
            returnObject.setErrorCode(Constants.ZERO);
            returnObject.setErrorMessage("请输入登录账户");
            return returnObject;
        } else if (StringUtils.isEmpty(password)) {//服务端对参数再次进行验证，验证密码不能为空
            returnObject.setErrorCode(Constants.ZERO);
            returnObject.setErrorMessage("请输入登录密码");
            return returnObject;
        } else {

            //调用底层登录方法，根据用户和密码查询用户是否存在
            UserInfo userInfo = userInfoService.login(userName, password);

            if (null == userInfo) {//未查询到用户，则登录失败
                returnObject.setErrorCode(Constants.ZERO);
                returnObject.setErrorMessage("账户名或密码错误");
            } else {

                //登录成功
                //判断是否勾选了七天内免登陆
                if (rememberMe) {
                    //将用户名和密码放入cookie中，通过response响应给浏览器客户端
                    int loginMaxAge = 7 * 24 * 60 * 60;//定义账户密码的生命周期，这里是7天，单位为秒
                    MyCookieUtils.addCookie(request, response, "userName", userName, loginMaxAge);//将姓名加入到cookie中
                    MyCookieUtils.addCookie(request, response, "password", password, loginMaxAge);//将密码加入到cookie中
                }

                //将登录查询出来的用户信息放入session中
                request.getSession().setAttribute(Constants.SESSION_USER, userInfo);

                returnObject.setErrorCode(Constants.ONE);
                returnObject.setErrorMessage("登录成功");
            }

            return returnObject;
        }
    }

    /**
     * 进入后台系统主页面-用户信息页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/admin/profile")
    public String main(HttpSession session, Model model) {

        UserInfo userInfo = (UserInfo) session.getAttribute(Constants.SESSION_USER);

        //根据员工ID获取用户所属员工及组织机构信息
        StaffInfo staffInfo = staffInfoService.getStaffInfoById(userInfo.getStaffId());

        //员工信息放入model中供页面展示
        model.addAttribute("staffInfo", staffInfo);

        //跳转到profile.jsp页面
        return "profile";
    }

    /**
     * 用户退出登录
     *
     * @param session
     * @return
     */
    @RequestMapping("/admin/logout")
    public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {

        //将session中的用户信息删除，退出登录
        session.removeAttribute(Constants.SESSION_USER);

        //废弃 销毁 session
//        session.invalidate();

        //删除用户登录的cookie信息
        MyCookieUtils.removeCookieValueByName(request, response, "userName");
        MyCookieUtils.removeCookieValueByName(request, response, "password");

        //跳转到index.jsp页面
        return "redirect:/";
    }

    /**
     * 查询用户信息列表
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/admin/users")
    public String users(Model model,
                        @RequestParam(value = "currentPage", required = false) Integer currentPage,
                        @RequestParam(value = "pageSize", required = false) Integer pageSize) {

        if (null == currentPage) {
            currentPage = 1;//当前页从1开始
        }
        if (null == pageSize) {
            pageSize = Constants.DEFAULT_PAGESIZE;//默认每页显示10条数据
        }

        int startRow = (currentPage - 1) * pageSize;
        Map<String, Object> paramMap = new ConcurrentHashMap<String, Object>();
        paramMap.put("startRow", startRow);
        paramMap.put("pageSize", pageSize);

        //分页查询用户列表数据
        List<UserInfo> userInfoList = userInfoService.getUserInfoByPage(paramMap);

        //符合查询条件的用户数据总条数
        int totalRows = userInfoService.getUserInfoByTotal(paramMap);

        //计算有多少页
        int totalPage = totalRows / pageSize;
        int mod = totalRows % pageSize;
        if (mod > 0) {
            totalPage = totalPage + 1;
        }

        model.addAttribute("userInfoList", userInfoList);//产品列表
        model.addAttribute("totalPage", totalPage);//总页数
        model.addAttribute("currentPage", currentPage);//当前页
        model.addAttribute("startRow", startRow);//开始行
        model.addAttribute("totalRows", totalRows);//总数据条数
        model.addAttribute("pageSize", pageSize);//每页显示多少条数据

        //跳转到产品列表页
        return "users";
    }

    /**
     * 去添加用户
     *
     * @return
     */
    @RequestMapping(value = "/admin/toAddUser")
    public String toAddUser() {

        return "addUser";
    }

    /**
     * 去修改用户信息
     *
     * @return
     */
    @RequestMapping(value = "/admin/toEditUser")
    public String toEditUser(Model model,
                             @RequestParam(name = "id", required = true) Integer userId) {

        UserInfo userInfo = userInfoService.getUserInfoById(userId);

        model.addAttribute("updateUserInfo", userInfo);

        return "addUser";
    }

    /**
     * 根据前端输入的手机号自动动态匹配查询员工手机号
     * <p>
     * jQuery UI Autocomplete，默认传递的参数名称为term
     *
     * @param startPhone
     * @return
     */
    @RequestMapping(value = "/admin/getStaffPhone")
    public @ResponseBody
    Object getStaffPhone(
            @RequestParam(name = "term", required = true) String startPhone) {

        ReturnObject returnObject = new ReturnObject();
        logger.info("根据输入的手机号开始几位查询匹配的手机号:" + startPhone);

        //根据输入的手机号开始几位查询匹配的手机号
        List<Map<String, Object>> phoneMapList = staffInfoService.getStaffPhone(startPhone);

        String[] array = new String[phoneMapList.size()];
        for (int i = 0; i < phoneMapList.size(); i++) {
            Map<String, Object> map = phoneMapList.get(i);
            array[i] = String.valueOf(map.get("phone"));
        }
        returnObject.setData(array);

        return returnObject.getData();
    }

    /**
     * 添加用户
     *
     * @param username
     * @param password
     * @param phone
     * @return
     */
    @RequestMapping(value = "/admin/addUser")
    public @ResponseBody
    ReturnObject addUser(
            @RequestParam(name = "username", required = true) String username,
            @RequestParam(name = "password", required = true) String password,
            @RequestParam(name = "phone", required = true) String phone) {

        ReturnObject returnObject = new ReturnObject();

        //根据手机号获取一遍员工id
        StaffInfo staffInfo = staffInfoService.getStaffInfoByPhone(phone);
        if (null == staffInfo) {
            returnObject.setErrorCode(Constants.ONE);
            returnObject.setErrorMessage("手机号码不存在");
            return returnObject;
        }

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setPassword(password);
        userInfo.setStaffId(staffInfo.getId());
        int addRow = userInfoService.addUser(userInfo);

        if (addRow <= 0) {
            returnObject.setErrorCode(Constants.ONE);
            returnObject.setErrorMessage("添加用户失败，请过会儿重试吧~");
            return returnObject;
        }

        returnObject.setErrorCode(Constants.ZERO);
        returnObject.setErrorMessage("添加用户成功");
        return returnObject;
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/admin/deleteUser")
    public String deleteUser(@RequestParam(name = "id", required = true) Integer id) {
        //删除用户
        userInfoService.deleteUser(id);
        return "redirect:/admin/users";
    }

    /**
     * 用户没有权限
     *
     * @return
     */
    @RequestMapping("/admin/refuse")
    public String refuse() {
        return "refuse";
    }
}
