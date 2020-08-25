package com.caoruiqun.admin.service;

import com.caoruiqun.admin.model.CreditorRights;

import java.util.List;
import java.util.Map;

/**
 * 债权相关处理Service接口
 * 
 * @author Felix
 *
 */
public interface CreditorRightsService {

	/**
	 * 分页查询债权列表信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<CreditorRights> getCreditorRightsByPage(Map<String, Object> paramMap);
	
	/**
	 * 查询所有的债权总数
	 * 
	 * @return
	 */
	public int getCreditorRightsByTotal(Map<String, Object> paramMap);
	
	/**
	 * 添加债权
	 * 
	 * @param creditorRights
	 * @return
	 */
	public int addCreditorRights(CreditorRights creditorRights);

	/**
	 * 根据主键id查询债权信息
	 *
	 * @param id
	 * @return
	 */
	public CreditorRights getCreditorRights(int id);

	/**
	 * 根据主键id删除债权信息
	 *
	 * @param id
	 * @return
	 */
	public int deleteCreditorRights(int id);

	/**
	 * 根据债权状态查询债权信息
	 *
	 * @param matchStatus
	 * @return
	 */
	public List<CreditorRights> getCreditorRightsByMatchStatus(Map<String, Object> paramMap);

	/**
	 * 接收第三方债权
	 *
	 */
	public void receiveCreditor();
}
