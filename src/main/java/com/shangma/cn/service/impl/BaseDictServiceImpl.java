package com.shangma.cn.service.impl;

import com.shangma.cn.entity.BaseDict;
import com.shangma.cn.entity.BaseDictExample;
import com.shangma.cn.mapper.BaseDictMapper;
import com.shangma.cn.service.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseDictServiceImpl implements BaseDictService {


    @Autowired
    private BaseDictMapper baseDictMapper;

    @Override
    public List<BaseDict> findByTypeCode(String typeCode) {

        BaseDictExample example = new BaseDictExample();
        //这个criteria 就是封装我们的条件的
        BaseDictExample.Criteria criteria = example.createCriteria();
        criteria.andDictTypeCodeEqualTo(typeCode);
        return baseDictMapper.selectByExample(example);
    }
}
