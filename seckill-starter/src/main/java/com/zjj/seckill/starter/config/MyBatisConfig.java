package com.zjj.seckill.starter.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;


/**
 * mybatis config
 *
 * @author zhujunjian
 */
@Configuration
@MapperScan(basePackages = {"com.zjj.seckill.infrastructure.mapper"}, sqlSessionFactoryRef = "sqlSessionFactory")

public class MyBatisConfig {

    @Bean(name = "sqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(DruidDataSource dataSource,
                                               @Value("${mybatis.mapper-locations}") Resource[] mapperLocations,
                                               @Value("${mybatis.type-aliases-package}") String typeAliasesPackage) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setMapperLocations(mapperLocations);
        sqlSessionFactory.setTypeAliasesPackage(typeAliasesPackage);
        return sqlSessionFactory.getObject();
    }


}