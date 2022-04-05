package com.vietnb1.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.n")
    public DataSourceProperties dataSourcePropertiesN() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.z")
    public DataSourceProperties dataSourcePropertiesZ() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource dataSourceN() {
        return dataSourcePropertiesN().initializeDataSourceBuilder().build();
    }

    @Bean
    public DataSource dataSourceZ() {
        return dataSourcePropertiesZ().initializeDataSourceBuilder().build();
    }

    @Bean(name = "dataSource")
    @Primary
    public DataSource dataSource() {
        Map<Object, Object> targetDataSources = new HashMap<>();
        DataSource dataSourceN = dataSourceN();
        DataSource dataSourceZ = dataSourceZ();
        targetDataSources.put(DataSourceType.N, dataSourceN);
        targetDataSources.put(DataSourceType.Z, dataSourceZ);

        CustomRoutingDataSource clientRoutingDatasource = new CustomRoutingDataSource();
        clientRoutingDatasource.setTargetDataSources(targetDataSources);
        clientRoutingDatasource.setDefaultTargetDataSource(dataSourceZ);
        return clientRoutingDatasource;
    }

}
