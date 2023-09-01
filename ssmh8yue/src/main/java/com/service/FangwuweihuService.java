package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FangwuweihuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FangwuweihuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FangwuweihuView;


/**
 * 房屋维护
 *
 * @author 
 * @email 
 * @date 2022-03-22 09:39:51
 */
public interface FangwuweihuService extends IService<FangwuweihuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FangwuweihuVO> selectListVO(Wrapper<FangwuweihuEntity> wrapper);
   	
   	FangwuweihuVO selectVO(@Param("ew") Wrapper<FangwuweihuEntity> wrapper);
   	
   	List<FangwuweihuView> selectListView(Wrapper<FangwuweihuEntity> wrapper);
   	
   	FangwuweihuView selectView(@Param("ew") Wrapper<FangwuweihuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FangwuweihuEntity> wrapper);
   	

}

