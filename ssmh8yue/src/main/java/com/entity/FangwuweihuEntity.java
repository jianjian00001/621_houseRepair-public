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
 * 房屋维护
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2022-03-22 09:39:51
 */
@TableName("fangwuweihu")
public class FangwuweihuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public FangwuweihuEntity() {
		
	}
	
	public FangwuweihuEntity(T t) {
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
	 * 房屋编号
	 */
					
	private String fangwubianhao;
	
	/**
	 * 房屋名称
	 */
					
	private String fangwumingcheng;
	
	/**
	 * 房屋类型
	 */
					
	private String fangwuleixing;
	
	/**
	 * 业主号
	 */
					
	private String yezhuhao;
	
	/**
	 * 维护时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date weihushijian;
	
	/**
	 * 维护人员
	 */
					
	private String weihurenyuan;
	
	/**
	 * 维护内容
	 */
					
	private String weihuneirong;
	
	/**
	 * 维护结果
	 */
					
	private String weihujieguo;
	
	
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
	 * 设置：房屋编号
	 */
	public void setFangwubianhao(String fangwubianhao) {
		this.fangwubianhao = fangwubianhao;
	}
	/**
	 * 获取：房屋编号
	 */
	public String getFangwubianhao() {
		return fangwubianhao;
	}
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
	 * 设置：维护时间
	 */
	public void setWeihushijian(Date weihushijian) {
		this.weihushijian = weihushijian;
	}
	/**
	 * 获取：维护时间
	 */
	public Date getWeihushijian() {
		return weihushijian;
	}
	/**
	 * 设置：维护人员
	 */
	public void setWeihurenyuan(String weihurenyuan) {
		this.weihurenyuan = weihurenyuan;
	}
	/**
	 * 获取：维护人员
	 */
	public String getWeihurenyuan() {
		return weihurenyuan;
	}
	/**
	 * 设置：维护内容
	 */
	public void setWeihuneirong(String weihuneirong) {
		this.weihuneirong = weihuneirong;
	}
	/**
	 * 获取：维护内容
	 */
	public String getWeihuneirong() {
		return weihuneirong;
	}
	/**
	 * 设置：维护结果
	 */
	public void setWeihujieguo(String weihujieguo) {
		this.weihujieguo = weihujieguo;
	}
	/**
	 * 获取：维护结果
	 */
	public String getWeihujieguo() {
		return weihujieguo;
	}

}
