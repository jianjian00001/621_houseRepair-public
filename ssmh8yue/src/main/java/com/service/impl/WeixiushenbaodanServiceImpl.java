package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.WeixiushenbaodanDao;
import com.entity.WeixiushenbaodanEntity;
import com.service.WeixiushenbaodanService;
import com.entity.vo.WeixiushenbaodanVO;
import com.entity.view.WeixiushenbaodanView;

@Service("weixiushenbaodanService")
public class WeixiushenbaodanServiceImpl extends ServiceImpl<WeixiushenbaodanDao, WeixiushenbaodanEntity> implements WeixiushenbaodanService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WeixiushenbaodanEntity> page = this.selectPage(
                new Query<WeixiushenbaodanEntity>(params).getPage(),
                new EntityWrapper<WeixiushenbaodanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WeixiushenbaodanEntity> wrapper) {
		  Page<WeixiushenbaodanView> page =new Query<WeixiushenbaodanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WeixiushenbaodanVO> selectListVO(Wrapper<WeixiushenbaodanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WeixiushenbaodanVO selectVO(Wrapper<WeixiushenbaodanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WeixiushenbaodanView> selectListView(Wrapper<WeixiushenbaodanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WeixiushenbaodanView selectView(Wrapper<WeixiushenbaodanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
