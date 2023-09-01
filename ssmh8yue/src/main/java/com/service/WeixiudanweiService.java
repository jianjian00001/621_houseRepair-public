package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WeixiudanweiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WeixiudanweiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WeixiudanweiView;


/**
 * 维修单位
 *
 * @author 
 * @email 
 * @date 2022-03-22 09:39:51
 */
public interface WeixiudanweiService extends IService<WeixiudanweiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WeixiudanweiVO> selectListVO(Wrapper<WeixiudanweiEntity> wrapper);
   	
   	WeixiudanweiVO selectVO(@Param("ew") Wrapper<WeixiudanweiEntity> wrapper);
   	
   	List<WeixiudanweiView> selectListView(Wrapper<WeixiudanweiEntity> wrapper);
   	
   	WeixiudanweiView selectView(@Param("ew") Wrapper<WeixiudanweiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WeixiudanweiEntity> wrapper);
   	

}

