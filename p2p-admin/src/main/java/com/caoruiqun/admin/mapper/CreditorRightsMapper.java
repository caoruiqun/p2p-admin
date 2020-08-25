package com.caoruiqun.admin.mapper;

import com.caoruiqun.admin.model.CreditorRights;
import com.caoruiqun.admin.model.CreditorRightsContract;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 债权处理Mapper
 * 
 * @author Felix
 *
 */
@Mapper
public interface CreditorRightsMapper {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(CreditorRights record);

    CreditorRights selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CreditorRights record);

    /**
     * 分页查询债权数据
     *
     * @param paramMap
     * @return
     */
    List<CreditorRights> getCreditorRightsByPage(Map<String, Object> paramMap);

    /**
     * 分页查询债权数据总数
     *
     * @param paramMap
     * @return
     */
    int getCreditorRightsByTotal(Map<String, Object> paramMap);
    
    List<CreditorRights> getCreditorRightsByMatchStatus(Map<String, Object> paramMap);
    
    /**
     * 根据债权ID查询用户、投资、产品、债权信息
     * 
     * @param creditorId
     * @return
     */
    List<CreditorRightsContract> getCreditorRightsForContract(@Param("creditorId") Integer creditorId);
}