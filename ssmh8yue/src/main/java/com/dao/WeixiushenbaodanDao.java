package com.dao;

import com.entity.WeixiushenbaodanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WeixiushenbaodanVO;
import com.entity.view.WeixiushenbaodanView;


/**
 * 维修申报单
 * 
 * @author 
 * @email 
 * @date 2022-03-22 09:39:51
 */
public interface WeixiushenbaodanDao extends BaseMapper<WeixiushenbaodanEntity> {
	
	List<WeixiushenbaodanVO> selectListVO(@Param("ew") Wrapper<WeixiushenbaodanEntity> wrapper);
	
	WeixiushenbaodanVO selectVO(@Param("ew") Wrapper<WeixiushenbaodanEntity> wrapper);
	
	List<WeixiushenbaodanView> selectListView(@Param("ew") Wrapper<WeixiushenbaodanEntity> wrapper);

	List<WeixiushenbaodanView> selectListView(Pagination page,@Param("ew") Wrapper<WeixiushenbaodanEntity> wrapper);
	
	WeixiushenbaodanView selectView(@Param("ew") Wrapper<WeixiushenbaodanEntity> wrapper);
	

}
