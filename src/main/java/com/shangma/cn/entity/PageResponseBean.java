package com.shangma.cn.entity;

import java.util.List;

/**
 * 分页返回数据是通用的
 */
public class PageResponseBean<T> {

    private long total;

    private List<T> data;


    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
