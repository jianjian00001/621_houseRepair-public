package com.entity.view;

import com.entity.WeixiuwanchengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 维修完成
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-03-22 09:39:51
 */
@TableName("weixiuwancheng")
public class WeixiuwanchengView  extends WeixiuwanchengEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WeixiuwanchengView(){
	}
 
 	public WeixiuwanchengView(WeixiuwanchengEntity weixiuwanchengEntity){
 	try {
			BeanUtils.copyProperties(this, weixiuwanchengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
