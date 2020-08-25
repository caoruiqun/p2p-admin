package com.caoruiqun.admin.service.impl;

import com.caoruiqun.admin.mapper.SlideShowMapper;
import com.caoruiqun.admin.model.SlideShow;
import com.caoruiqun.admin.service.SlideShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 轮播图相关处理Service接口实现
 * 
 * @author Felix
 *
 */
@Service("slideShowService")
public class SlideShowServiceImpl implements SlideShowService {
	
	@Autowired
	private SlideShowMapper slideShowMapper;

	/**
	 * 分页查询轮播图列表信息
	 * 
	 * @param paramMap
	 * @return
	 */
	@Override
	public List<SlideShow> getSlideShowByPage(Map<String, Object> paramMap) {
		return slideShowMapper.getSlideShowByPage(paramMap);
	}

	/**
	 * 查询所有的轮播图总数
	 * 
	 * @return
	 */
	@Override
	public int getSlideShowByTotal(Map<String, Object> paramMap) {
		return slideShowMapper.getSlideShowByTotal(paramMap);
	}
	
	/**
	 * 添加轮播图信息
	 * 
	 * @param slideShow
	 * @return
	 */
	public int addSlideShow(SlideShow slideShow) {
		return slideShowMapper.insertSelective(slideShow);
	}
	
	/**
	 * 根据ID获取轮播图信息
	 * 
	 * @param id
	 * @return
	 */
	public SlideShow getSlideShowById (int id) {
		return slideShowMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 根据ID删除轮播图
	 * 
	 * @param id
	 * @return
	 */
	public int deleteSlideShowById (int id) {
		return slideShowMapper.deleteByPrimaryKey(id);
	}
}