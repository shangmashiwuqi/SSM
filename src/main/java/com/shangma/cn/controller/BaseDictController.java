package com.shangma.cn.controller;

import com.shangma.cn.entity.BaseDict;
import com.shangma.cn.service.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.HttpURLConnection;
import java.util.List;

@Controller
public class BaseDictController {

    @Autowired
    private BaseDictService baseDictService;

    @GetMapping("findByTypeCode")
    public ResponseEntity<List<BaseDict>> findByTypeCode(String code) {
        return ResponseEntity.ok(baseDictService.findByTypeCode(code));

    }
}
