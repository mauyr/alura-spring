package br.com.caelum.loja.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by mauyr on 14/02/17.
 */
public class DataSourceConfigurationTest {

    @Bean
    @Profile("test")
    public DataSource dataSource() {
        BasicDataSource dataSourceConfig = new BasicDataSource();
        dataSourceConfig.setDriverClassName("org.postgresql.Driver");

        dataSourceConfig.setUrl("jdbc:postgresql://127.0.0.1:5432/loja_test");
        dataSourceConfig.setUsername("postgres");
        dataSourceConfig.setValidationQuery("SELECT 1");
        dataSourceConfig.setPassword("postgres");

        return dataSourceConfig;
    }

}
