package com.entity.vo;

import com.entity.FangwuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 房屋信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-03-22 09:39:51
 */
public class FangwuxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 房屋名称
	 */
	
	private String fangwumingcheng;
		
	/**
	 * 房屋类型
	 */
	
	private String fangwuleixing;
		
	/**
	 * 房屋面积
	 */
	
	private String fangwumianji;
		
	/**
	 * 业主号
	 */
	
	private String yezhuhao;
		
	/**
	 * 业主手机
	 */
	
	private String yezhushouji;
		
	/**
	 * 身份证
	 */
	
	private String shenfenzheng;
		
	/**
	 * 业主姓名
	 */
	
	private String yezhuxingming;
		
	/**
	 * 楼房号
	 */
	
	private String loufanghao;
				
	
	/**
	 * 设置：房屋名称
	 */
	 
	public void setFangwumingcheng(String fangwumingcheng) {
		this.fangwumingcheng = fangwumingcheng;
	}
	
	/**
	 * 获取：房屋名称
	 */
	public String getFangwumingcheng() {
		return fangwumingcheng;
	}
				
	
	/**
	 * 设置：房屋类型
	 */
	 
	public void setFangwuleixing(String fangwuleixing) {
		this.fangwuleixing = fangwuleixing;
	}
	
	/**
	 * 获取：房屋类型
	 */
	public String getFangwuleixing() {
		return fangwuleixing;
	}
				
	
	/**
	 * 设置：房屋面积
	 */
	 
	public void setFangwumianji(String fangwumianji) {
		this.fangwumianji = fangwumianji;
	}
	
	/**
	 * 获取：房屋面积
	 */
	public String getFangwumianji() {
		return fangwumianji;
	}
				
	
	/**
	 * 设置：业主号
	 */
	 
	public void setYezhuhao(String yezhuhao) {
		this.yezhuhao = yezhuhao;
	}
	
	/**
	 * 获取：业主号
	 */
	public String getYezhuhao() {
		return yezhuhao;
	}
				
	
	/**
	 * 设置：业主手机
	 */
	 
	public void setYezhushouji(String yezhushouji) {
		this.yezhushouji = yezhushouji;
	}
	
	/**
	 * 获取：业主手机
	 */
	public String getYezhushouji() {
		return yezhushouji;
	}
				
	
	/**
	 * 设置：身份证
	 */
	 
	public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
	}
	
	/**
	 * 获取：身份证
	 */
	public String getShenfenzheng() {
		return shenfenzheng;
	}
				
	
	/**
	 * 设置：业主姓名
	 */
	 
	public void setYezhuxingming(String yezhuxingming) {
		this.yezhuxingming = yezhuxingming;
	}
	
	/**
	 * 获取：业主姓名
	 */
	public String getYezhuxingming() {
		return yezhuxingming;
	}
				
	
	/**
	 * 设置：楼房号
	 */
	 
	public void setLoufanghao(String loufanghao) {
		this.loufanghao = loufanghao;
	}
	
	/**
	 * 获取：楼房号
	 */
	public String getLoufanghao() {
		return loufanghao;
	}
			
}
