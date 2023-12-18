package com.test.teste.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.test.teste.Repositories",
    entityManagerFactoryRef = "jpaSharedEM_entityManagerFactory"
)
public class JpaConfig {

    @Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("dataSource") DataSource dataSource) {
        
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        // Aquí puedes configurar el proveedor JPA según tus necesidades

        return builder
                .dataSource(dataSource)
                .packages("com.test.teste.Entities")
                .persistenceUnit("testepu")
                .properties(getJpaProperties())
                .jpaVendorAdapter(vendorAdapter)
                .build();
    }

    private Map<String, Object> getJpaProperties() {
        // Configura las propiedades JPA según tus necesidades
        Map<String, Object> jpaProperties = new HashMap<String, Object>;
        // Ejemplo: jpaProperties.put("hibernate.hbm2ddl.auto", "update");
        return jpaProperties;
    }

    // Otras configuraciones, como el EntityManager, pueden ir aquí...
}
