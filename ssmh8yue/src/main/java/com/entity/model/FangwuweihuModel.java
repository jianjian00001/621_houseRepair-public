package com.entity.model;

import com.entity.FangwuweihuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 房屋维护
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2022-03-22 09:39:51
 */
public class FangwuweihuModel  implements Serializable {
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
	 * 业主号
	 */
	
	private String yezhuhao;
		
	/**
	 * 维护时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
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
