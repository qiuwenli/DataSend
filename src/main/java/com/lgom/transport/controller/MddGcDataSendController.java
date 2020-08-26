package com.lgom.transport.controller;


import com.lgom.transport.model.MddGcDataSend;
import com.lgom.transport.service.MddGcDataSendService;
import com.lgom.transport.thrift.ThriftDataClient;
import org.apache.thrift.TException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Mr qiu
 * @since 2020-06-15
 */
@RestController
@RequestMapping("/mddGcDataSend")
public class MddGcDataSendController {

    @Resource
    private ThriftDataClient thriftDataClient;

    @Resource
    private MddGcDataSendService mddGcDataSendService;

    @GetMapping(value = "/sendData")
    public String sendData(int sendData) throws TException {
        List<MddGcDataSend> list = mddGcDataSendService.list();
        thriftDataClient.sendData("admin", "mdd_gc_data", list);
        return "测试成功"+sendData;
    }

}

