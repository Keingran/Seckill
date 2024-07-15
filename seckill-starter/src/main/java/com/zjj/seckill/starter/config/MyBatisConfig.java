package com.zjj.seckill.starter.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * mybatis config
 *
 * @author zhujunjian
 */
public class MyBatisConfig {

    @Value("${mybatis.scanpackages}")
    private String scanPackages;

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DruidDataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
//        sqlSessionFactory.setTypeAliasesPackage(scanPackages);
//        sqlSessionFactory.setMapperLocations("classpath*:com/meiwei/tan/dao/**/*Dao.xml");
        return sqlSessionFactory;
    }
}