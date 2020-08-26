package com.lgom.transport.controller;


import com.lgom.transport.model.PdmRealSend;
import com.lgom.transport.service.PdmRealSendService;
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
 * @since 2020-06-17
 */
@RestController
@RequestMapping("/pdmRealSend")
public class PdmRealSendController {
    @Resource
    private ThriftDataClient thriftDataClient;

    @Resource
    private PdmRealSendService pdmRealSendService;

    @GetMapping(value = "/sendData")
    public String sendData(int sendData) throws TException {
        List<PdmRealSend> list = pdmRealSendService.list();
        thriftDataClient.sendData("admin", "pdm_real_send", list);
        return "测试成功"+sendData;
    }
}

