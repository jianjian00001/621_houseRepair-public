package com.entity.view;

import com.entity.WeixiudanweiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 维修单位
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-03-22 09:39:51
 */
@TableName("weixiudanwei")
public class WeixiudanweiView  extends WeixiudanweiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WeixiudanweiView(){
	}
 
 	public WeixiudanweiView(WeixiudanweiEntity weixiudanweiEntity){
 	try {
			BeanUtils.copyProperties(this, weixiudanweiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
