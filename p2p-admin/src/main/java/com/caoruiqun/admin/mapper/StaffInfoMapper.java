package com.caoruiqun.admin.mapper;

import com.caoruiqun.admin.model.StaffInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 员工信息处理Mapper接口
 * 
 * @author Felix
 *
 */
@Mapper
public interface StaffInfoMapper {
	
	StaffInfo getStaffInfoById(int staffId);

    int deleteByPrimaryKey(Integer id);

    int insert(StaffInfo record);

    int insertSelective(StaffInfo record);

    StaffInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StaffInfo record);

    int updateByPrimaryKey(StaffInfo record);

    /**
	 * 根据输入的手机号开始几位查询匹配的手机号
	 *
	 * @param startPhone
	 * @return
	 */
    List<Map<String, Object>> getStaffPhone(String startPhone);

	/**
	 * 根据phone查询员工信息
	 *
	 * @param phone
	 * @return
	 */
	StaffInfo getStaffInfoByPhone(String phone);
}