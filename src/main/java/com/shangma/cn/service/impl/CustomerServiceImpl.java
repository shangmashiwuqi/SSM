package com.shangma.cn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shangma.cn.entity.BaseDict;
import com.shangma.cn.entity.Customer;
import com.shangma.cn.entity.PageResponseBean;
import com.shangma.cn.mapper.BaseDictMapper;
import com.shangma.cn.mapper.CustomerMapper;
import com.shangma.cn.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private BaseDictMapper baseDictMapper;


    /*
     * 遍历数组 再查询
     *
     * 第一种解决方式 是后端+前段    预加载（很遥远 ）
     *
     * 第二种解决方式： 后端+前段   分页
     *
     *   limit
     *
     *   select * from user limit 2 5
     * 第三种解决方式： 懒加载（前段页面实现 ） +分页
     *
     * 分页返回的实体类
     */
    @Override
    public PageResponseBean<Customer> findAll(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Customer> customers = customerMapper.selectByExample(null);
        // 我们需要总页数

        PageInfo<Customer> pageInfo = new PageInfo<>(customers);
        //获得总页数 
        long total = pageInfo.getTotal();


        for (Customer customer : customers) {
            //用户等级id
            String custLevel = customer.getCustLevel();
            BaseDict baseDict = baseDictMapper.selectByPrimaryKey(custLevel);
            String dictItemName = baseDict.getDictItemName();

            customer.setCustLevelName(dictItemName);
            //客户来源id
            String custSource = customer.getCustSource();
            BaseDict baseDict1 = baseDictMapper.selectByPrimaryKey(custSource);
            String dictItemName1 = baseDict1.getDictItemName();
            customer.setCustSourceName(dictItemName1);
            //客户行业的id
            String custIndustry = customer.getCustIndustry();

            BaseDict baseDict2 = baseDictMapper.selectByPrimaryKey(custIndustry);
            String dictItemName2 = baseDict2.getDictItemName();
            customer.setCustIndustryName(dictItemName2);
        }


        PageResponseBean<Customer> pageResponseBean = new PageResponseBean<>();
        pageResponseBean.setTotal(total);
        pageResponseBean.setData(customers);
        return pageResponseBean;
    }


    @Override
    public Customer findCustomerById(long id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Customer customer) {
        customerMapper.updateByPrimaryKey(customer);
    }
}
