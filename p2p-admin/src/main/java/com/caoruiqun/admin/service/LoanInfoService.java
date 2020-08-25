package com.caoruiqun.admin.service;

import com.caoruiqun.admin.model.CreditorRightsContract;
import com.caoruiqun.admin.model.LoanInfo;

import java.util.List;
import java.util.Map;

/**
 * 标的产品信息Service接口
 * 
 * @author Felix
 *
 */
public interface LoanInfoService {

	/**
	 * 分页查询产品列表信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<LoanInfo> getLoanInfoByPage(Map<String, Object> paramMap);
	
	/**
	 * 查询所有的产品总数
	 * 
	 * @return
	 */
	public int getLoanInfoByTotal(Map<String, Object> paramMap);
	
	/**
	 * 根据id查询投标产品详情
	 * 
	 * @param id
	 * @return
	 */
	public LoanInfo getLoanInfoById(int id);

	/**
	 * 根据产品Id更新产品信息
	 *
	 * @param loanInfo
	 * @return
	 */
	public int updateLoanInfoById(LoanInfo loanInfo);

	/**
	 * 添加产品信息
	 *
	 * @param loanInfo
	 * @return
	 */
	public int addProduct(LoanInfo loanInfo);

	/**
	 * 根据产品ID删除产品
	 *
	 * @param id
	 * @return
	 */
	public int deleteProductById(Integer id);

	/**
     * 根据债权ID查询用户、投资、产品、债权信息
     *
     * @param creditorId
     * @return
     */
	public List<CreditorRightsContract> getCreditorRightsByContract(Integer creditorId);
}
