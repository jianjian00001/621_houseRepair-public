package com.dao;

import com.entity.WeixiudanweiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WeixiudanweiVO;
import com.entity.view.WeixiudanweiView;


/**
 * 维修单位
 * 
 * @author 
 * @email 
 * @date 2022-03-22 09:39:51
 */
public interface WeixiudanweiDao extends BaseMapper<WeixiudanweiEntity> {
	
	List<WeixiudanweiVO> selectListVO(@Param("ew") Wrapper<WeixiudanweiEntity> wrapper);
	
	WeixiudanweiVO selectVO(@Param("ew") Wrapper<WeixiudanweiEntity> wrapper);
	
	List<WeixiudanweiView> selectListView(@Param("ew") Wrapper<WeixiudanweiEntity> wrapper);

	List<WeixiudanweiView> selectListView(Pagination page,@Param("ew") Wrapper<WeixiudanweiEntity> wrapper);
	
	WeixiudanweiView selectView(@Param("ew") Wrapper<WeixiudanweiEntity> wrapper);
	

}
