package cn.zxy.zmanager.dao;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author Silence 000996
 * @data 18/9/12
 */
@Configuration
@MapperScan(basePackages = "cn.zxy.zmanager.dao.mapper")
public class DataBaseConfiguration {

    @Bean(destroyMethod = "close", initMethod = "init")
    @ConfigurationProperties("database")
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }
}
