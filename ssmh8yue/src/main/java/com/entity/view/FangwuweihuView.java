package com.entity.view;

import com.entity.FangwuweihuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 房屋维护
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-03-22 09:39:51
 */
@TableName("fangwuweihu")
public class FangwuweihuView  extends FangwuweihuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public FangwuweihuView(){
	}
 
 	public FangwuweihuView(FangwuweihuEntity fangwuweihuEntity){
 	try {
			BeanUtils.copyProperties(this, fangwuweihuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
