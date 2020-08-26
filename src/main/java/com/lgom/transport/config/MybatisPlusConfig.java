package com.lgom.transport.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Mr qiu
 * @description mybatis plus 配置
 * @date 2020-06-15 16:02
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.lgom.transport.dao")
public class MybatisPlusConfig {

}
