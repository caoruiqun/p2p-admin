package com.caoruiqun.admin.mapper;

import com.caoruiqun.admin.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 用户相关处理Mapper
 * 
 * @author Felix
 *
 */
@Mapper
public interface UserInfoMapper {
	
	/**
	 * 根据用户名和密码查询用户
	 * 
	 * @return
	 */
    public UserInfo selectUserInfoByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);
    
    /**
	 * 分页查询用户信息数据
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<UserInfo> getUserInfoByPage(Map<String, Object> paramMap);
	
	/**
	 * 分页查询用户信息总数
	 * 
	 * @param paramMap
	 * @return
	 */
	public int getUserInfoByTotal(Map<String, Object> paramMap);
	
	/**
	 * 添加用户
	 * 
	 * @param userInfo
	 * @return
	 */
	public int addUser(UserInfo userInfo);

	/**
	 * 删除用户
	 *
	 * @param id
	 * @return
	 */
	public int deleteUser(int id);

	/**
	 * 根据用户ID查询用户信息
	 *
	 * @param userId
	 * @return
	 */
	public UserInfo getUserInfoById(Integer userId);
}