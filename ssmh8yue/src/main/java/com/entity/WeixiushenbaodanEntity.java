package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 维修申报单
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-03-22 09:39:51
 */
@TableName("weixiushenbaodan")
public class WeixiushenbaodanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public WeixiushenbaodanEntity() {
		
	}
	
	public WeixiushenbaodanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 报修编号
	 */
					
	private String baoxiubianhao;
	
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
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
