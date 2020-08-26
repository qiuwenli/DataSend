package com.lgom.generate;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.Collections;

/**
 * 官网配置地址:https://mybatis.plus/config/generator-config.html#%E5%9F%BA%E6%9C%AC%E9%85%8D%E7%BD%AE
 * 根据官网,根据自身需要进行配置
 * @author Mr qiu
 * @description mybatis-plus 生成器
 * @date 2020-06-15 10:03
 */
public class GenerateClass {

    public static void main(String[] args) {
        GenerateClass g = new GenerateClass();
        String projectName = "dataSend";
        String packageName = "com.lgom.transport";
        String tableName = "PDM_REAL_SEND";
        boolean serviceNameStartWithI = false;
        g.generateByTables(serviceNameStartWithI,projectName,packageName,tableName);
    }
    /**
     * 根据表自动生成
     *  @param packageName           包名
     * @param tableNames            表名
     */
    private void generateByTables(boolean serviceNameStartWithI, String projectName, String packageName, String... tableNames) {
        //配置数据源
        DataSourceConfig dataSourceConfig = getSqlServerDataSourceConfig();
        // 策略配置
        StrategyConfig strategyConfig = getStrategyConfig(tableNames);
        //全局变量配置
        GlobalConfig globalConfig = getGlobalConfig(serviceNameStartWithI);
        //包名配置
        PackageConfig packageConfig = getPackageConfig(packageName);
        //自动生成
        autoGenerator(dataSourceConfig, strategyConfig, globalConfig, packageConfig);
    }

    /**
     * 集成
     *
     * @param dataSourceConfig 配置数据源
     * @param strategyConfig   策略配置
     * @param config           全局变量配置
     * @param packageConfig    包名配置
     */
    private void autoGenerator(DataSourceConfig dataSourceConfig, StrategyConfig strategyConfig, GlobalConfig config, PackageConfig packageConfig) {
        new AutoGenerator()
                .setGlobalConfig(config).
                setCfg(new InjectionConfig() {
                    @Override
                    public void initMap() {

                    }
                }.setFileOutConfigList(Collections.singletonList(new FileOutConfig(
                        "/templates/mapper.xml" + (".vm")) {
                    // 自定义输出文件目录
                    @Override
                    public String outputFile(TableInfo tableInfo) {
                        return "F:\\IdeaWorkSpace\\DataSend\\src\\main\\resources\\mapper\\" + tableInfo.getEntityName() + "Mapper.xml";
                    }
                })))
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig)
                .setTemplateEngine(new VelocityTemplateEngine())
                .execute();
    }

    /**
     * 设置包名
     *
     * @param packageName 父路径包名
     * @return PackageConfig 包名配置
     */
    private PackageConfig getPackageConfig(String packageName) {
        return new PackageConfig()
                .setParent(packageName)
                .setMapper("dao")
                .setController("controller")
                .setService("service")
                .setEntity("model");
    }

    /**
     * 全局配置
     *
     * @param serviceNameStartWithI false
     * @return GlobalConfig
     */
    private GlobalConfig getGlobalConfig(boolean serviceNameStartWithI) {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig
                .setBaseColumnList(true)
                .setBaseResultMap(true)
                .setActiveRecord(false)
                .setAuthor("Mr qiu")
                //设置输出路径
                .setOutputDir(System.getProperty("user.dir")+"/src/main/java/")
                .setFileOverride(true)
                .setXmlName("%sMapper")
                .setServiceName("%sService")
                .setServiceImplName("%sServiceImpl");
        if (!serviceNameStartWithI) {
            //设置service名
            globalConfig.setServiceName("%sService");
        }
        return globalConfig;
    }

    /**
     * 策略配置
     *
     * @param tableNames 表名
     * @return StrategyConfig
     */
    private StrategyConfig getStrategyConfig(String... tableNames) {
        return new StrategyConfig()
                // 全局大写命名 ORACLE 注意
                .setCapitalMode(true)
                .setEntityLombokModel(false)
                .setRestControllerStyle(true)
//            .setSuperEntityClass("com.lgom.common.domain.BaseEntity")
//            .setSuperControllerClass()  //添加controller父类
                .setTablePrefix("cac")
                //从数据库表到文件的命名策略
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)

                //需要生成的的表名，多个表名传数组
                .setInclude(tableNames);
    }

    /**
     * 配置数据源
     *
     * @return 数据源配置 DataSourceConfig
     */
    private DataSourceConfig getMysqlDataSourceConfig() {
        return new DataSourceConfig().setDbType(DbType.MYSQL)
                .setUrl("jdbc:mysql://192.168.3.152:3308/cacmonitor?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8")
                .setUsername("root")
                .setPassword("lgom")
                .setDriverName("com.mysql.jdbc.Driver");
    }

    /**
     * 配置数据源
     *
     * @return 数据源配置 DataSourceConfig
     */
    private DataSourceConfig getSqlServerDataSourceConfig() {
        return new DataSourceConfig().setDbType(DbType.SQL_SERVER)
                .setUrl("jdbc:sqlserver://192.168.3.212:1433;DatabaseName=NBLGMDD")
                .setUsername("sa")
                .setPassword("123456")
                .setDriverName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    }
}
