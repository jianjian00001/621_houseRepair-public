package com.dao;

import com.entity.FangwuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FangwuxinxiVO;
import com.entity.view.FangwuxinxiView;


/**
 * 房屋信息
 * 
 * @author 
 * @email 
 * @date 2022-03-22 09:39:51
 */
public interface FangwuxinxiDao extends BaseMapper<FangwuxinxiEntity> {
	
	List<FangwuxinxiVO> selectListVO(@Param("ew") Wrapper<FangwuxinxiEntity> wrapper);
	
	FangwuxinxiVO selectVO(@Param("ew") Wrapper<FangwuxinxiEntity> wrapper);
	
	List<FangwuxinxiView> selectListView(@Param("ew") Wrapper<FangwuxinxiEntity> wrapper);

	List<FangwuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<FangwuxinxiEntity> wrapper);
	
	FangwuxinxiView selectView(@Param("ew") Wrapper<FangwuxinxiEntity> wrapper);
	

}
