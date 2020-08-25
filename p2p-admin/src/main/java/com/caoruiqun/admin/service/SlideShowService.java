package com.caoruiqun.admin.service;

import com.caoruiqun.admin.model.SlideShow;

import java.util.List;
import java.util.Map;

/**
 * 轮播图相关处理Service接口
 * 
 * @author Felix
 *
 */
public interface SlideShowService {

	/**
	 * 分页查询轮播图列表信息
	 * 
	 * @param paramMap
	 * @return
	 */
	public List<SlideShow> getSlideShowByPage(Map<String, Object> paramMap);
	
	/**
	 * 查询所有的轮播图总数
	 * 
	 * @return
	 */
	public int getSlideShowByTotal(Map<String, Object> paramMap);
	
	/**
	 * 添加轮播图信息
	 * 
	 * @param slideShow
	 * @return
	 */
	public int addSlideShow(SlideShow slideShow);
	
	/**
	 * 根据ID获取轮播图信息
	 * 
	 * @param id
	 * @return
	 */
	public SlideShow getSlideShowById(int id);

	/**
	 * 根据ID删除轮播图
	 *
	 * @param id
	 * @return
	 */
	public int deleteSlideShowById(int id);
}
