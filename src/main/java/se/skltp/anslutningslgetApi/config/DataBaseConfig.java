package se.skltp.anslutningslgetApi.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DataBaseConfig {
    @Autowired
    private Environment env;

    @Autowired
    private DataSource dataSource;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("anslutningslget.db.driver"));
        dataSource.setUrl(env.getProperty("anslutningslget.db.url"));
        dataSource.setUsername(env.getProperty("anslutningslget.db.username"));
        dataSource.setPassword(env.getProperty("anslutningslget.db.password"));
        return dataSource;
    }

    /**
     * Declare the JPA entity manager factory.
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory =
                new LocalContainerEntityManagerFactoryBean();

        entityManagerFactory.setDataSource(dataSource);


        entityManagerFactory.setPackagesToScan(
                env.getProperty("anslutningslget.entitymanager.packages.to.scan"));

        // Vendor adapter
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);

        // Hibernate properties
        Properties additionalProperties = new Properties();
        additionalProperties.put(
                "hibernate.dialect",
                env.getProperty("anslutningslget.hibernate.dialect"));
        additionalProperties.put(
                "hibernate.show_sql",
                env.getProperty("anslutningslget.hibernate.show_sql"));
        additionalProperties.put(
                "hibernate.hbm2ddl.auto",
                env.getProperty("anslutningslget.hibernate.hbm2ddl.auto"));
        entityManagerFactory.setJpaProperties(additionalProperties);


        return entityManagerFactory;
    }
}

