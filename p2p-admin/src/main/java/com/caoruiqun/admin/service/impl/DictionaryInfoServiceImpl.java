package com.caoruiqun.admin.service.impl;

import com.caoruiqun.admin.mapper.DictionaryInfoMapper;
import com.caoruiqun.admin.model.DictionaryInfo;
import com.caoruiqun.admin.service.DictionaryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 数据字典处理Service实现
 *
 * @author Felix
 *
 */
@Service("dictionaryInfoService")
public class DictionaryInfoServiceImpl implements DictionaryInfoService {

	@Autowired
	private DictionaryInfoMapper dictionaryInfoMapper;
	
	/**
	 * 查询所有的字典表数据
	 * 
	 */
	@Override
	public List<DictionaryInfo> getAllDictionaryInfo() {
		return dictionaryInfoMapper.getAllDictionaryInfo();
	}
	
	@Override
	public List<DictionaryInfo> getDictionaryInfoByType(int type) {
		return dictionaryInfoMapper.selectDictionaryInfoByType(type);
	}
}