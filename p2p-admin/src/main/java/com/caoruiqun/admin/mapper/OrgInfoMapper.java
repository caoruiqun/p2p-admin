package com.caoruiqun.admin.mapper;

import com.caoruiqun.admin.model.OrgInfo;

/**
 * 部门信息处理Mapper
 *
 * @author Felix
 *
 */
public interface OrgInfoMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(OrgInfo record);

    int insertSelective(OrgInfo record);

    OrgInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrgInfo record);

    int updateByPrimaryKey(OrgInfo record);
}