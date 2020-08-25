package com.caoruiqun.admin.mapper;

import com.caoruiqun.admin.model.SlideShow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 轮播图相关处理Mapper
 * 
 * @author Felix
 *
 */
@Mapper
public interface SlideShowMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insertSelective(SlideShow slideShow);

    SlideShow selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SlideShow record);

    List<SlideShow> getSlideShowByPage(Map<String, Object> paramMap);
    
    int getSlideShowByTotal(Map<String, Object> paramMap);
}