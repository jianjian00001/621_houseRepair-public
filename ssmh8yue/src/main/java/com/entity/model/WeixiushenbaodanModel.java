package com.entity.model;

import com.entity.WeixiushenbaodanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 维修申报单
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2022-03-22 09:39:51
 */
public class WeixiushenbaodanModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 报修设备
	 */
	
	private String baoxiushebei;
		
	/**
	 * 问题描述
	 */
	
	private String wentimiaoshu;
		
	/**
	 * 报修日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date baoxiuriqi;
		
	/**
	 * 业主号
	 */
	
	private String yezhuhao;
		
	/**
	 * 业主姓名
	 */
	
	private String yezhuxingming;
		
	/**
	 * 业主手机
	 */
	
	private String yezhushouji;
		
	/**
	 * 楼房号
	 */
	
	private String loufanghao;
		
	/**
	 * 完成状态
	 */
	
	private String wanchengzhuangtai;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
				
	
	/**
	 * 设置：报修设备
	 */
	 
	public void setBaoxiushebei(String baoxiushebei) {
		this.baoxiushebei = baoxiushebei;
	}
	
	/**
	 * 获取：报修设备
	 */
	public String getBaoxiushebei() {
		return baoxiushebei;
	}
				
	
	/**
	 * 设置：问题描述
	 */
	 
	public void setWentimiaoshu(String wentimiaoshu) {
		this.wentimiaoshu = wentimiaoshu;
	}
	
	/**
	 * 获取：问题描述
	 */
	public String getWentimiaoshu() {
		return wentimiaoshu;
	}
				
	
	/**
	 * 设置：报修日期
	 */
	 
	public void setBaoxiuriqi(Date baoxiuriqi) {
		this.baoxiuriqi = baoxiuriqi;
	}
	
	/**
	 * 获取：报修日期
	 */
	public Date getBaoxiuriqi() {
		return baoxiuriqi;
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
	 * 设置：完成状态
	 */
	 
	public void setWanchengzhuangtai(String wanchengzhuangtai) {
		this.wanchengzhuangtai = wanchengzhuangtai;
	}
	
	/**
	 * 获取：完成状态
	 */
	public String getWanchengzhuangtai() {
		return wanchengzhuangtai;
	}
				
	
	/**
	 * 设置：是否审核
	 */
	 
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
				
	
	/**
	 * 设置：审核回复
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
			
}
