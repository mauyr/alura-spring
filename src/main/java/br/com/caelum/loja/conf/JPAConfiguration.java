package br.com.caelum.loja.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by mauyr on 26/01/17.
 */
//@Configuration
//@EnableTransactionManagement
public class JPAConfiguration {

    @Value("${database.config.filename}")
    private String databaseConfig;

    @Value("${database.config.dialect}")
    private String dialect;

//    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        factoryBean.setJpaVendorAdapter(vendorAdapter);

        factoryBean.setDataSource(dataSource());

        Properties props = aditionalProperties();

        factoryBean.setJpaProperties(props);

        factoryBean.setPackagesToScan("br.com.caelum.loja.model");

        return factoryBean;
    }

    private Properties aditionalProperties() {
        Properties props = new Properties();
        props.setProperty("hibernate.dialect", this.dialect);
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.hbm2ddl.auto", "create");
        props.setProperty("hibernate.hbm2ddl.import_files", "db/initial_data.sql");
        return props;
    }

//    @Bean
//    @Profile("dev")
    DataSource dataSource() {
        BasicDataSource dataSourceConfig = new BasicDataSource();
        dataSourceConfig.setDriverClassName("org.postgresql.Driver");

        dataSourceConfig.setUrl("jdbc:postgresql://127.0.0.1:5432/loja");
        dataSourceConfig.setUsername("postgres");
        dataSourceConfig.setValidationQuery("SELECT 1");
        dataSourceConfig.setPassword("postgres");

        return dataSourceConfig;
    }

//    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf){
        return new JpaTransactionManager(emf);
    }
}
