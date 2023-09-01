package com.entity.vo;

import com.entity.WeixiudanweiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 维修单位
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-03-22 09:39:51
 */
public class WeixiudanweiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 密码
	 */
	
	private String mima;
		
	/**
	 * 师傅姓名
	 */
	
	private String shifuxingming;
		
	/**
	 * 性别
	 */
	
	private String xingbie;
		
	/**
	 * 年龄
	 */
	
	private String nianling;
		
	/**
	 * 师傅手机
	 */
	
	private String shifushouji;
				
	
	/**
	 * 设置：密码
	 */
	 
	public void setMima(String mima) {
		this.mima = mima;
	}
	
	/**
	 * 获取：密码
	 */
	public String getMima() {
		return mima;
	}
				
	
	/**
	 * 设置：师傅姓名
	 */
	 
	public void setShifuxingming(String shifuxingming) {
		this.shifuxingming = shifuxingming;
	}
	
	/**
	 * 获取：师傅姓名
	 */
	public String getShifuxingming() {
		return shifuxingming;
	}
				
	
	/**
	 * 设置：性别
	 */
	 
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
				
	
	/**
	 * 设置：年龄
	 */
	 
	public void setNianling(String nianling) {
		this.nianling = nianling;
	}
	
	/**
	 * 获取：年龄
	 */
	public String getNianling() {
		return nianling;
	}
				
	
	/**
	 * 设置：师傅手机
	 */
	 
	public void setShifushouji(String shifushouji) {
		this.shifushouji = shifushouji;
	}
	
	/**
	 * 获取：师傅手机
	 */
	public String getShifushouji() {
		return shifushouji;
	}
			
}
