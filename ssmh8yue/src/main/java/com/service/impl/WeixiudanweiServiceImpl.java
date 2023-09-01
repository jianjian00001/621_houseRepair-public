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


import com.dao.WeixiudanweiDao;
import com.entity.WeixiudanweiEntity;
import com.service.WeixiudanweiService;
import com.entity.vo.WeixiudanweiVO;
import com.entity.view.WeixiudanweiView;

@Service("weixiudanweiService")
public class WeixiudanweiServiceImpl extends ServiceImpl<WeixiudanweiDao, WeixiudanweiEntity> implements WeixiudanweiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WeixiudanweiEntity> page = this.selectPage(
                new Query<WeixiudanweiEntity>(params).getPage(),
                new EntityWrapper<WeixiudanweiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WeixiudanweiEntity> wrapper) {
		  Page<WeixiudanweiView> page =new Query<WeixiudanweiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WeixiudanweiVO> selectListVO(Wrapper<WeixiudanweiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WeixiudanweiVO selectVO(Wrapper<WeixiudanweiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WeixiudanweiView> selectListView(Wrapper<WeixiudanweiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WeixiudanweiView selectView(Wrapper<WeixiudanweiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
