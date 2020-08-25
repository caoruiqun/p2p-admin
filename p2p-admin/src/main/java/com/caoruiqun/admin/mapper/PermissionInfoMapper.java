package com.caoruiqun.admin.mapper;

import com.caoruiqun.admin.model.PermissionInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 权限信息Mapper接口
 * 
 * @author Felix
 *
 */
@Mapper
public interface PermissionInfoMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(PermissionInfo record);

    int insertSelective(PermissionInfo record);

    PermissionInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PermissionInfo record);

    int updateByPrimaryKey(PermissionInfo record);
    
    List<PermissionInfo> selectPermissionInfoByUserIdAndType(@Param("userId") Integer userId,@Param("type") String type);
}