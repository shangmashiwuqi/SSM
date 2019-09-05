package com.shangma.cn.controller;

import com.shangma.cn.entity.Customer;
import com.shangma.cn.entity.PageResponseBean;
import com.shangma.cn.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


//控制器 必须要写Controller 注解  不能写其他注解
@Controller
public class CustomerController {


     @Autowired
    private CustomerService customerService;

    @GetMapping("findAll")
    public ResponseEntity<PageResponseBean<Customer>> findAll(int currentPage, int pageSize) {
        if (currentPage <= 0) {
            currentPage = 1;
        }
        if (pageSize <= 0) {
            pageSize = 5;
        }
        return ResponseEntity.ok(customerService.findAll(currentPage, pageSize));
    }


    @GetMapping("findCustomerById/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable long id) {

        return ResponseEntity.ok(customerService.findCustomerById(id));
    }


    @PutMapping("update")
    public ResponseEntity<String> update(Customer customer) {
        customerService.update(customer);


        return ResponseEntity.ok("success");
    }
}
