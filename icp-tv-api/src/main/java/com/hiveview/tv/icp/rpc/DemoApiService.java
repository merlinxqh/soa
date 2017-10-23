package com.hiveview.tv.icp.rpc;

import com.hiveview.icp.api.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by leo on 2017/10/23.
 */
@Service
public class DemoApiService {

    @Autowired
    private DemoService demoService;

    public String sayHello(String name){
        return demoService.sayHello(name);
    }
}
