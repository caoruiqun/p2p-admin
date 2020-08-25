package com.caoruiqun.admin.service.impl;

import com.caoruiqun.admin.mapper.PermissionInfoMapper;
import com.caoruiqun.admin.mapper.UserInfoMapper;
import com.caoruiqun.admin.model.PermissionInfo;
import com.caoruiqun.admin.model.UserInfo;
import com.caoruiqun.admin.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 用户处理Service实现
 *
 * @author Felix
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Autowired
	private PermissionInfoMapper permissionInfoMapper;

	/**
	 * 用户登录
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public UserInfo login (String userName, String password) {
//		Map<String, Object> paramMap = new ConcurrentHashMap<String, Object>();
//		paramMap.put("userName", userName);
//		paramMap.put("password", password);
//		//登录查询
//		UserInfo userInfo = userInfoMapper.selectByUserNameAndPassword(paramMap);

		UserInfo userInfo = userInfoMapper.selectUserInfoByUserNameAndPassword(userName, password);

		if (null != userInfo) {
			//获取用户菜单权限
//			Map<String, Object> menuMap = new ConcurrentHashMap<String, Object>();
//			menuMap.put("type", "menu");
//			menuMap.put("userId", userInfo.getId());
//			List<PermissionInfo> menuPermissionInfoList = permissionInfoMapper.selectPermissionInfoByUserIdAndType(menuMap);

			List<PermissionInfo> menuPermissionInfoList = permissionInfoMapper.selectPermissionInfoByUserIdAndType(userInfo.getId(),"menu");

			//获取用户按钮权限
//			menuMap.put("type", "button");
//			List<PermissionInfo> buttonPermissionInfoList = permissionInfoMapper.selectPermissionInfoByUserIdAndType(menuMap);

			List<PermissionInfo> buttonPermissionInfoList = permissionInfoMapper.selectPermissionInfoByUserIdAndType(userInfo.getId(),"button");

			//把菜单权限和按钮权限放置到用户对象中，然后前台页面就知道当前用户有哪些菜单权限，有哪些按钮权限了
			userInfo.setMenuPermissionInfoList(menuPermissionInfoList);
			userInfo.setButtonPermissionInfoList(buttonPermissionInfoList);
		}

		return userInfo;
	}
	
	/**
	 * 分页查询用户信息数据
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<UserInfo> getUserInfoByPage(Map<String, Object> paramMap) {
		return userInfoMapper.getUserInfoByPage(paramMap);
	}
	
	/**
	 * 分页查询用户信息总数
	 * 
	 * @param paramMap
	 * @return
	 */
	public int getUserInfoByTotal(Map<String, Object> paramMap) {
		return userInfoMapper.getUserInfoByTotal(paramMap);
	}
	
	/**
	 * 添加用户
	 * 
	 * @param userInfo
	 * @return
	 */
	public int addUser (UserInfo userInfo) {
		return userInfoMapper.addUser(userInfo);
	}
	
	/**
	 * 删除用户
	 * 
	 * @param id
	 * @return
	 */
	public int deleteUser (int id) {
		return userInfoMapper.deleteUser(id);
	}
	
	/**
	 * 根据用户ID查询用户信息
	 * 
	 * @param userId
	 * @return
	 */
	public UserInfo getUserInfoById (Integer userId) {
		return userInfoMapper.getUserInfoById(userId);
	}
}
