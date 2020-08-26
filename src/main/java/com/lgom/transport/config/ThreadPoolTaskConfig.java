package com.lgom.transport.config;

import com.lgom.transport.model.MddGcDataSend;
import com.lgom.transport.model.MddGcGramSend;
import com.lgom.transport.model.PdmRealSend;
import com.lgom.transport.service.MddGcDataSendService;
import com.lgom.transport.service.MddGcGramSendService;
import com.lgom.transport.service.PdmRealSendService;
import com.lgom.transport.thrift.ThriftDataClient;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;

/**
 * @author Mr qiu
 * @description 定时任务启动
 * @date 2020-06-19 10:38
 */
@Configuration
@EnableAsync
@EnableScheduling
public class ThreadPoolTaskConfig {

    @Resource
    private ThriftDataClient thriftDataClient;
    @Resource
    private MddGcDataSendService mddGcDataSendService;
    @Resource
    private MddGcGramSendService mddGcGramSendService;
    @Resource
    private PdmRealSendService pdmRealSendService;

    @Value("${isServer}")
    private boolean isServer;

    @Bean("main")
    public Executor mainExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(100);
        executor.initialize();
        return executor;
    }
//    @Async
//    @Scheduled(cron = "${schedule.cron.gcData}")
    public void mddGcDataSend() throws TException {
        List<MddGcDataSend> list = mddGcDataSendService.list();
        if (!CollectionUtils.isEmpty(list)) {
            thriftDataClient.sendData("", "mdd_gc_data", list);
            mddGcDataSendService.removeByIds(list.stream().map(MddGcDataSend::getId).collect(Collectors.toList()));
        }
    }

//    @Async
    @Scheduled(cron = "${schedule.cron.gcGram}")
    public void mddGcGramSend() throws TException {
        if (isServer) {
            List<MddGcGramSend> list = mddGcGramSendService.list();
            if (!CollectionUtils.isEmpty(list)) {
                thriftDataClient.sendData("DC.SYL.NBLGDB", "mdd_gc_gram", list);
            }
        } else {
            MddGcGramSend mddGcGramSend = new MddGcGramSend();
            thriftDataClient.queryData("DC.SYL.NBLGDB","mdd_gc_gram",mddGcGramSend);
        }
    }

//
//    @Async
//    @Scheduled(cron = "${schedule.cron.pdmReal}")
    public void pdmRealSend() throws TException {
        System.out.println("第三个定时任务开始 : " + LocalDateTime.now().toLocalTime() + "\r\n线程 : " + Thread.currentThread().getName());
        List<PdmRealSend> list = pdmRealSendService.list();
        if (!CollectionUtils.isEmpty(list)) {
            thriftDataClient.sendData("", "pdm_real_send", list);
        }



    }

}
