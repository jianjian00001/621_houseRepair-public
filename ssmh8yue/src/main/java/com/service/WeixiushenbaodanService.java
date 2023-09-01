package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WeixiushenbaodanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WeixiushenbaodanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WeixiushenbaodanView;


/**
 * 维修申报单
 *
 * @author 
 * @email 
 * @date 2022-03-22 09:39:51
 */
public interface WeixiushenbaodanService extends IService<WeixiushenbaodanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WeixiushenbaodanVO> selectListVO(Wrapper<WeixiushenbaodanEntity> wrapper);
   	
   	WeixiushenbaodanVO selectVO(@Param("ew") Wrapper<WeixiushenbaodanEntity> wrapper);
   	
   	List<WeixiushenbaodanView> selectListView(Wrapper<WeixiushenbaodanEntity> wrapper);
   	
   	WeixiushenbaodanView selectView(@Param("ew") Wrapper<WeixiushenbaodanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WeixiushenbaodanEntity> wrapper);
   	

}

