package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

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
            return new CommonResult(200, "success,serverPort:"+serverPort,payment);
        }else{
            return new CommonResult(444, "fail",null);
        }
    }

    @GetMapping("/payment/lb")
    public String getServerPort(){
        return serverPort;
    }

    @GetMapping("/payment/timeout")
    public String timeout(){
        try { TimeUnit.SECONDS.sleep(3); }catch (Exception e) {e.printStackTrace();}
        return serverPort;
    }
}
