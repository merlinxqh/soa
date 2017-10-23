package com.hiveview.tv.icp.controller;

import com.hiveview.base.util.response.RespMsg;
import com.hiveview.tv.icp.rpc.DemoApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by leo on 2017/10/23.
 */
@RestController
public class HelloController {

    @Autowired
    private DemoApiService demoApiService;

    @RequestMapping(value = "hello/{name}")
    public RespMsg<?> hello(@PathVariable("name") String name){
        return RespMsg.successResp(demoApiService.sayHello(name));
    }
}
