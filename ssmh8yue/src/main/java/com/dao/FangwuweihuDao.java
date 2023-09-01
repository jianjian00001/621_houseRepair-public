package com.dao;

import com.entity.FangwuweihuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FangwuweihuVO;
import com.entity.view.FangwuweihuView;


/**
 * 房屋维护
 * 
 * @author 
 * @email 
 * @date 2022-03-22 09:39:51
 */
public interface FangwuweihuDao extends BaseMapper<FangwuweihuEntity> {
	
	List<FangwuweihuVO> selectListVO(@Param("ew") Wrapper<FangwuweihuEntity> wrapper);
	
	FangwuweihuVO selectVO(@Param("ew") Wrapper<FangwuweihuEntity> wrapper);
	
	List<FangwuweihuView> selectListView(@Param("ew") Wrapper<FangwuweihuEntity> wrapper);

	List<FangwuweihuView> selectListView(Pagination page,@Param("ew") Wrapper<FangwuweihuEntity> wrapper);
	
	FangwuweihuView selectView(@Param("ew") Wrapper<FangwuweihuEntity> wrapper);
	

}
