package com.lgom.transport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Mr qiu
 * @description 主启动
 * @date 2020-06-10 16:58
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, MultipartAutoConfiguration.class})
@EnableScheduling
public class DataSendMain {
    public static void main(String[] args) {
        SpringApplication.run(DataSendMain.class);
    }
}
