package com.caoruiqun.admin.service;

import com.caoruiqun.admin.model.StaffInfo;

import java.util.List;
import java.util.Map;

/**
 * 员工信息处理Service接口
 * 
 * @author Felix
 *
 */
public interface StaffInfoService {

	/**
	 * 根据id查询员工信息
	 * 
	 * @param staffId
	 * @return
	 */
	public StaffInfo getStaffInfoById(int staffId);

	/**
	 * 根据输入的手机号开始几位查询匹配的手机号
	 *
	 * @param startPhone
	 * @return
	 */
	public List<Map<String, Object>> getStaffPhone(String startPhone);

	/**
	 * 根据phone查询员工信息
	 *
	 * @param id
	 * @return
	 */
	public StaffInfo getStaffInfoByPhone(String phone);
}
