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

import com.entity.WeixiudanweiEntity;
import com.entity.view.WeixiudanweiView;

import com.service.WeixiudanweiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.InputStream;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 维修单位
 * 后端接口
 * @author 
 * @email 
 * @date 2022-03-22 09:39:51
 */
@RestController
@RequestMapping("/weixiudanwei")
public class WeixiudanweiController {
    @Autowired
    private WeixiudanweiService weixiudanweiService;



    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		WeixiudanweiEntity user = weixiudanweiService.selectOne(new EntityWrapper<WeixiudanweiEntity>().eq("weixiugonghao", username));
		if(user==null || !user.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		String token = tokenService.generateToken(user.getId(), username,"weixiudanwei",  "维修单位" );
		return R.ok().put("token", token);
	}
	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody WeixiudanweiEntity weixiudanwei){
    	//ValidatorUtils.validateEntity(weixiudanwei);
    	WeixiudanweiEntity user = weixiudanweiService.selectOne(new EntityWrapper<WeixiudanweiEntity>().eq("weixiugonghao", weixiudanwei.getWeixiugonghao()));
		if(user!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		weixiudanwei.setId(uId);
        weixiudanweiService.insert(weixiudanwei);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        WeixiudanweiEntity user = weixiudanweiService.selectById(id);
        return R.ok().put("data", user);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	WeixiudanweiEntity user = weixiudanweiService.selectOne(new EntityWrapper<WeixiudanweiEntity>().eq("weixiugonghao", username));
    	if(user==null) {
    		return R.error("账号不存在");
    	}
    	user.setMima("123456");
        weixiudanweiService.updateById(user);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WeixiudanweiEntity weixiudanwei, 
		HttpServletRequest request){

        EntityWrapper<WeixiudanweiEntity> ew = new EntityWrapper<WeixiudanweiEntity>();
		PageUtils page = weixiudanweiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiudanwei), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WeixiudanweiEntity weixiudanwei, 
		HttpServletRequest request){
        EntityWrapper<WeixiudanweiEntity> ew = new EntityWrapper<WeixiudanweiEntity>();
		PageUtils page = weixiudanweiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiudanwei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WeixiudanweiEntity weixiudanwei){
       	EntityWrapper<WeixiudanweiEntity> ew = new EntityWrapper<WeixiudanweiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( weixiudanwei, "weixiudanwei")); 
        return R.ok().put("data", weixiudanweiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WeixiudanweiEntity weixiudanwei){
        EntityWrapper< WeixiudanweiEntity> ew = new EntityWrapper< WeixiudanweiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( weixiudanwei, "weixiudanwei")); 
		WeixiudanweiView weixiudanweiView =  weixiudanweiService.selectView(ew);
		return R.ok("查询维修单位成功").put("data", weixiudanweiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WeixiudanweiEntity weixiudanwei = weixiudanweiService.selectById(id);
        return R.ok().put("data", weixiudanwei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WeixiudanweiEntity weixiudanwei = weixiudanweiService.selectById(id);
        return R.ok().put("data", weixiudanwei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WeixiudanweiEntity weixiudanwei, HttpServletRequest request){
    	weixiudanwei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(weixiudanwei);
    	WeixiudanweiEntity user = weixiudanweiService.selectOne(new EntityWrapper<WeixiudanweiEntity>().eq("weixiugonghao", weixiudanwei.getWeixiugonghao()));
		if(user!=null) {
			return R.error("用户已存在");
		}

		weixiudanwei.setId(new Date().getTime());
        weixiudanweiService.insert(weixiudanwei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WeixiudanweiEntity weixiudanwei, HttpServletRequest request){
    	weixiudanwei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(weixiudanwei);
    	WeixiudanweiEntity user = weixiudanweiService.selectOne(new EntityWrapper<WeixiudanweiEntity>().eq("weixiugonghao", weixiudanwei.getWeixiugonghao()));
		if(user!=null) {
			return R.error("用户已存在");
		}

		weixiudanwei.setId(new Date().getTime());
        weixiudanweiService.insert(weixiudanwei);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody WeixiudanweiEntity weixiudanwei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weixiudanwei);
        weixiudanweiService.updateById(weixiudanwei);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        weixiudanweiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<WeixiudanweiEntity> wrapper = new EntityWrapper<WeixiudanweiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = weixiudanweiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	






    @RequestMapping("/importExcel")
    public R importExcel(@RequestParam("file") MultipartFile file){
        try {
            //获取输入流
            InputStream inputStream = file.getInputStream();
            //创建读取工作簿
            Workbook workbook = WorkbookFactory.create(inputStream);
            //获取工作表
            Sheet sheet = workbook.getSheetAt(0);
            //获取总行
            int rows=sheet.getPhysicalNumberOfRows();
            if(rows>1){
                //获取单元格
                for (int i = 1; i < rows; i++) {
                    Row row = sheet.getRow(i);
                    WeixiudanweiEntity weixiudanweiEntity =new WeixiudanweiEntity();
                    weixiudanweiEntity.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
                    String weixiugonghao = CommonUtil.getCellValue(row.getCell(0));
                    weixiudanweiEntity.setWeixiugonghao(weixiugonghao);
                    String mima = CommonUtil.getCellValue(row.getCell(1));
                    weixiudanweiEntity.setMima(mima);
                    String shifuxingming = CommonUtil.getCellValue(row.getCell(2));
                    weixiudanweiEntity.setShifuxingming(shifuxingming);
                    String xingbie = CommonUtil.getCellValue(row.getCell(3));
                    weixiudanweiEntity.setXingbie(xingbie);
                    String nianling = CommonUtil.getCellValue(row.getCell(4));
                    weixiudanweiEntity.setNianling(nianling);
                    String shifushouji = CommonUtil.getCellValue(row.getCell(5));
                    weixiudanweiEntity.setShifushouji(shifushouji);
                     
                    //想数据库中添加新对象
                    weixiudanweiService.insert(weixiudanweiEntity);//方法
                }
            }
            inputStream.close();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok("导入成功");
    }

}
