package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WeixiuwanchengEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WeixiuwanchengVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WeixiuwanchengView;


/**
 * 维修完成
 *
 * @author 
 * @email 
 * @date 2022-03-22 09:39:51
 */
public interface WeixiuwanchengService extends IService<WeixiuwanchengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WeixiuwanchengVO> selectListVO(Wrapper<WeixiuwanchengEntity> wrapper);
   	
   	WeixiuwanchengVO selectVO(@Param("ew") Wrapper<WeixiuwanchengEntity> wrapper);
   	
   	List<WeixiuwanchengView> selectListView(Wrapper<WeixiuwanchengEntity> wrapper);
   	
   	WeixiuwanchengView selectView(@Param("ew") Wrapper<WeixiuwanchengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WeixiuwanchengEntity> wrapper);
   	

}

