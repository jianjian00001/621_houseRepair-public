package com.dao;

import com.entity.WeixiuwanchengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WeixiuwanchengVO;
import com.entity.view.WeixiuwanchengView;


/**
 * 维修完成
 * 
 * @author 
 * @email 
 * @date 2022-03-22 09:39:51
 */
public interface WeixiuwanchengDao extends BaseMapper<WeixiuwanchengEntity> {
	
	List<WeixiuwanchengVO> selectListVO(@Param("ew") Wrapper<WeixiuwanchengEntity> wrapper);
	
	WeixiuwanchengVO selectVO(@Param("ew") Wrapper<WeixiuwanchengEntity> wrapper);
	
	List<WeixiuwanchengView> selectListView(@Param("ew") Wrapper<WeixiuwanchengEntity> wrapper);

	List<WeixiuwanchengView> selectListView(Pagination page,@Param("ew") Wrapper<WeixiuwanchengEntity> wrapper);
	
	WeixiuwanchengView selectView(@Param("ew") Wrapper<WeixiuwanchengEntity> wrapper);
	

}
