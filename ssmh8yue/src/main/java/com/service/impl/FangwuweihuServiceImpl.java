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


import com.dao.FangwuweihuDao;
import com.entity.FangwuweihuEntity;
import com.service.FangwuweihuService;
import com.entity.vo.FangwuweihuVO;
import com.entity.view.FangwuweihuView;

@Service("fangwuweihuService")
public class FangwuweihuServiceImpl extends ServiceImpl<FangwuweihuDao, FangwuweihuEntity> implements FangwuweihuService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FangwuweihuEntity> page = this.selectPage(
                new Query<FangwuweihuEntity>(params).getPage(),
                new EntityWrapper<FangwuweihuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FangwuweihuEntity> wrapper) {
		  Page<FangwuweihuView> page =new Query<FangwuweihuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<FangwuweihuVO> selectListVO(Wrapper<FangwuweihuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FangwuweihuVO selectVO(Wrapper<FangwuweihuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FangwuweihuView> selectListView(Wrapper<FangwuweihuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FangwuweihuView selectView(Wrapper<FangwuweihuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
