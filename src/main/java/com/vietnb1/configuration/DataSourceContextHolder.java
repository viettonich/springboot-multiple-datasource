package com.vietnb1.configuration;

import org.springframework.util.Assert;

public class DataSourceContextHolder {

    private static final ThreadLocal<DataSourceType> contextHolder = new ThreadLocal<>();

    public static void setDatasourceType(DataSourceType customerType) {
        Assert.notNull(customerType, "customerType cannot be null");
        contextHolder.set(customerType);
    }

    public static DataSourceType getDatasourceType() {
        return (DataSourceType) contextHolder.get();
    }

    public static void clearDatasourceType() {
        contextHolder.remove();
    }

}
