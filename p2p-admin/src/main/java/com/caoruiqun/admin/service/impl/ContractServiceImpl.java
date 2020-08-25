package com.caoruiqun.admin.service.impl;

import com.caoruiqun.admin.common.utils.XMLGregorianCalendarUtils;
import com.caoruiqun.admin.mapper.CreditorRightsMapper;
import com.caoruiqun.admin.model.BidInfo;
import com.caoruiqun.admin.model.CreditorRights;
import com.caoruiqun.admin.model.CreditorRightsContract;
import com.caoruiqun.admin.service.ContractService;
import com.caoruiqun.admin.stub.BidInfoVO;
import com.caoruiqun.admin.stub.CreditorVO;
import com.caoruiqun.admin.stub.SealServiceImpl;
import com.caoruiqun.admin.stub.SealServiceImplService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 合同生成处理Service接口实现
 * 
 * @author Felix
 *
 */
@Service("contractService")
public class ContractServiceImpl implements ContractService {
	
	/**log4j2 日志记录器*/
	private static final Logger logger = LoggerFactory.getLogger(ContractServiceImpl.class);
	
	@Autowired
	private CreditorRightsMapper creditorRightsMapper;
	
	/**
	 * 合同生成
	 * 
	 */
	public void genegateContract (Integer creditorRightsId) {
		
		//查询符合生成合同条件的债权
		List<CreditorRightsContract> creditorRightsContractList = creditorRightsMapper.getCreditorRightsForContract(creditorRightsId);
		
		//遍历符合生成合同条件的债权，逐个生成pdf借款合同
		for (CreditorRightsContract creditorRightsContract : creditorRightsContractList) {
			
			//封装数据，调用远程webservice
			CreditorVO creditorVO = new CreditorVO();
			creditorVO.setApplyNo(creditorRightsContract.getApplyNo());
			creditorVO.setApplyPurpose(creditorRightsContract.getApplyPurpose());
			creditorVO.setAuditLoanMoney(creditorRightsContract.getAuditLoanMoney());
			creditorVO.setAuditLoanTerm(creditorRightsContract.getAuditLoanTerm());
			creditorVO.setBorrowerIdcard(creditorRightsContract.getBorrowerIdcard());
			creditorVO.setBorrowerPresentAddress(creditorRightsContract.getBorrowerPresentAddress());
			creditorVO.setBorrowerRealname(creditorRightsContract.getBorrowerRealname());
			creditorVO.setBorrowerSex(creditorRightsContract.getBorrowerSex());
			creditorVO.setCollectFinishTime(XMLGregorianCalendarUtils.convertToXMLGregorianCalendar(creditorRightsContract.getCollectFinishTime()));
			
			//从生成的代码中获取bidInfoVOList， webservice的list
			List<BidInfoVO> bidInfoVOList = creditorVO.getBidInfoVOList();

			//我们的投资记录list
			List<BidInfo> bidinfolist = creditorRightsContract.getBidInfoList();

			for (BidInfo bidInfo : bidinfolist) {

				//webservice对象
				BidInfoVO bidInfoVO = new BidInfoVO();

				bidInfoVO.setBidId(bidInfo.getBidId());
				bidInfoVO.setBidMoney(bidInfo.getBidMoney());
				bidInfoVO.setIdCard(bidInfo.getIdCard());
				bidInfoVO.setName(bidInfo.getName());
				bidInfoVO.setPhone(bidInfo.getPhone());
				bidInfoVO.setUserId(bidInfo.getUserId());

				//将封装好的投资信息对象添加到bidInfoVOList中
				bidInfoVOList.add(bidInfoVO);
			}
			
			//调用签章系统的webservice接口完成合同生成及签章
			SealServiceImplService sealServiceImplService = new SealServiceImplService();
			SealServiceImpl sealServiceImpl = sealServiceImplService.getSealServiceImplPort();

			String sealPdf = sealServiceImpl.pdfSeal(creditorVO);
			
			logger.info("生成的合同文件：" + sealPdf);
			
			if (StringUtils.isNotEmpty(sealPdf) && StringUtils.startsWith(sealPdf, "http://")) {
				//将合同文件访问路径更新到债权表中
				CreditorRights record = new CreditorRights();
				record.setId(creditorRightsContract.getId());//债权ID
				record.setLoanContractPath(sealPdf);//合同路径
				int updateRow = creditorRightsMapper.updateByPrimaryKeySelective(record);
				logger.info("更新债权合同路径结果：" + updateRow);
			}
		}
	}
}