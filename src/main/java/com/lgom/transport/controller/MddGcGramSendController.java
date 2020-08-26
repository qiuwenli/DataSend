package com.lgom.transport.controller;


import com.lgom.transport.model.MddGcGramSend;
import com.lgom.transport.service.MddGcGramSendService;
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
@RequestMapping("/mddGcGramSend")
public class MddGcGramSendController {

    @Resource
    private ThriftDataClient thriftDataClient;

    @Resource
    private MddGcGramSendService mddGcGramSendService;

    @GetMapping(value = "/sendData")
    public String sendData(int sendData) throws TException {
        List<MddGcGramSend> list = mddGcGramSendService.list();
        thriftDataClient.sendData("admin", "mdd_gc_gram", list);
        return "测试成功"+sendData;
    }
}

