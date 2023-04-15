package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        Integer result = paymentService.insert(payment);
        log.info("result="+result);
        if (result > 0){
            return new CommonResult(200, "success",result);
        }else{
            return new CommonResult(444, "fail",result);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.queryById(id);
        log.info("payment="+payment);
        if (null != payment){
            return new CommonResult(200, "success",payment);
        }else{
            return new CommonResult(444, "fail",null);
        }
    }
}
