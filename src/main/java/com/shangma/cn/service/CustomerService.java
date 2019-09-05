package com.shangma.cn.service;

import com.shangma.cn.entity.Customer;
import com.shangma.cn.entity.PageResponseBean;

public interface CustomerService {

    public PageResponseBean<Customer> findAll(int currentPage, int pageSize);

    Customer findCustomerById(long id);

    void update(Customer customer);
}
