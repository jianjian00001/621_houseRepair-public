package com.entity.vo;

import com.entity.WeixiuwanchengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 维修完成
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-03-22 09:39:51
 */
public class WeixiuwanchengVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 业主号
	 */
	
	private String yezhuhao;
		
	/**
	 * 业主姓名
	 */
	
	private String yezhuxingming;
		
	/**
	 * 报修编号
	 */
	
	private String baoxiubianhao;
		
	/**
	 * 楼房号
	 */
	
	private String loufanghao;
		
	/**
	 * 维修工号
	 */
	
	private String weixiugonghao;
		
	/**
	 * 师傅姓名
	 */
	
	private String shifuxingming;
		
	/**
	 * 师傅手机
	 */
	
	private String shifushouji;
		
	/**
	 * 完成时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date wanchengshijian;
		
	/**
	 * 维修结果
	 */
	
	private String weixiujieguo;
		
	/**
	 * 回执单
	 */
	
	private String huizhidan;
				
	
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
	 * 设置：报修编号
	 */
	 
	public void setBaoxiubianhao(String baoxiubianhao) {
		this.baoxiubianhao = baoxiubianhao;
	}
	
	/**
	 * 获取：报修编号
	 */
	public String getBaoxiubianhao() {
		return baoxiubianhao;
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
				
	
	/**
	 * 设置：维修工号
	 */
	 
	public void setWeixiugonghao(String weixiugonghao) {
		this.weixiugonghao = weixiugonghao;
	}
	
	/**
	 * 获取：维修工号
	 */
	public String getWeixiugonghao() {
		return weixiugonghao;
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
				
	
	/**
	 * 设置：完成时间
	 */
	 
	public void setWanchengshijian(Date wanchengshijian) {
		this.wanchengshijian = wanchengshijian;
	}
	
	/**
	 * 获取：完成时间
	 */
	public Date getWanchengshijian() {
		return wanchengshijian;
	}
				
	
	/**
	 * 设置：维修结果
	 */
	 
	public void setWeixiujieguo(String weixiujieguo) {
		this.weixiujieguo = weixiujieguo;
	}
	
	/**
	 * 获取：维修结果
	 */
	public String getWeixiujieguo() {
		return weixiujieguo;
	}
				
	
	/**
	 * 设置：回执单
	 */
	 
	public void setHuizhidan(String huizhidan) {
		this.huizhidan = huizhidan;
	}
	
	/**
	 * 获取：回执单
	 */
	public String getHuizhidan() {
		return huizhidan;
	}
			
}
