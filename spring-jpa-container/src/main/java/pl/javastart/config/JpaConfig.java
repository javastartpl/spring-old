package pl.javastart.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.*;
import org.springframework.orm.jpa.*;
import org.springframework.orm.jpa.vendor.*;

@Configuration
public class JpaConfig {
//    @Bean
//    public LocalContainerEntityManagerFactoryBean createEMF(JpaVendorAdapter adapter) {
//        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
//        Map<String, String> properties = new HashMap<>();
//        properties.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/library");
//        properties.put("javax.persistence.jdbc.user", "root");
//        properties.put("javax.persistence.jdbc.password", "admin");
//        properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
//        properties.put("javax.persistence.schema-generation.database.action", "drop-and-create");
//        emf.setPersistenceUnitName("spring-jpa-pu");
//        emf.setJpaPropertyMap(properties);
//        emf.setJpaVendorAdapter(adapter);
//        emf.setPackagesToScan("pl.javastart.model");
//        return emf;
//    }
    @Bean
    public LocalContainerEntityManagerFactoryBean createEMF(JpaVendorAdapter adapter, DataSource ds) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setPersistenceUnitName("spring-jpa-pu");
        emf.setDataSource(ds);
        emf.setJpaVendorAdapter(adapter);
        emf.setPackagesToScan("pl.javastart.model");
        return emf;
    }
    
    @Bean
    public JpaVendorAdapter createVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        return adapter;
    }
    
    @Bean
    public DataSource createDS() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/library");
        ds.setUsername("root");
        ds.setPassword("admin");
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setInitialSize(5);
        return ds;
    }
    
}