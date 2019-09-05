package com.shangma.cn.service;

import com.shangma.cn.entity.BaseDict;

import java.util.List;

public interface BaseDictService {
    public List<BaseDict> findByTypeCode(String typeCode);
}
