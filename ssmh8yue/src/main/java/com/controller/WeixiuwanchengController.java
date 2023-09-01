package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.WeixiuwanchengEntity;
import com.entity.view.WeixiuwanchengView;

import com.service.WeixiuwanchengService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 维修完成
 * 后端接口
 * @author 
 * @email 
 * @date 2022-03-22 09:39:51
 */
@RestController
@RequestMapping("/weixiuwancheng")
public class WeixiuwanchengController {
    @Autowired
    private WeixiuwanchengService weixiuwanchengService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WeixiuwanchengEntity weixiuwancheng, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yezhu")) {
			weixiuwancheng.setYezhuhao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("weixiudanwei")) {
			weixiuwancheng.setWeixiugonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<WeixiuwanchengEntity> ew = new EntityWrapper<WeixiuwanchengEntity>();
		PageUtils page = weixiuwanchengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiuwancheng), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WeixiuwanchengEntity weixiuwancheng, 
		HttpServletRequest request){
        EntityWrapper<WeixiuwanchengEntity> ew = new EntityWrapper<WeixiuwanchengEntity>();
		PageUtils page = weixiuwanchengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiuwancheng), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WeixiuwanchengEntity weixiuwancheng){
       	EntityWrapper<WeixiuwanchengEntity> ew = new EntityWrapper<WeixiuwanchengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( weixiuwancheng, "weixiuwancheng")); 
        return R.ok().put("data", weixiuwanchengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WeixiuwanchengEntity weixiuwancheng){
        EntityWrapper< WeixiuwanchengEntity> ew = new EntityWrapper< WeixiuwanchengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( weixiuwancheng, "weixiuwancheng")); 
		WeixiuwanchengView weixiuwanchengView =  weixiuwanchengService.selectView(ew);
		return R.ok("查询维修完成成功").put("data", weixiuwanchengView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WeixiuwanchengEntity weixiuwancheng = weixiuwanchengService.selectById(id);
        return R.ok().put("data", weixiuwancheng);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WeixiuwanchengEntity weixiuwancheng = weixiuwanchengService.selectById(id);
        return R.ok().put("data", weixiuwancheng);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WeixiuwanchengEntity weixiuwancheng, HttpServletRequest request){
    	weixiuwancheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(weixiuwancheng);

        weixiuwanchengService.insert(weixiuwancheng);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WeixiuwanchengEntity weixiuwancheng, HttpServletRequest request){
    	weixiuwancheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(weixiuwancheng);

        weixiuwanchengService.insert(weixiuwancheng);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody WeixiuwanchengEntity weixiuwancheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weixiuwancheng);
        weixiuwanchengService.updateById(weixiuwancheng);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        weixiuwanchengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<WeixiuwanchengEntity> wrapper = new EntityWrapper<WeixiuwanchengEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yezhu")) {
			wrapper.eq("yezhuhao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("weixiudanwei")) {
			wrapper.eq("weixiugonghao", (String)request.getSession().getAttribute("username"));
		}

		int count = weixiuwanchengService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
