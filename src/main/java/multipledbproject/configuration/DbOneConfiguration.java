package multipledbproject.configuration;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryOne",
        transactionManagerRef = "transactionManagerOne",
        basePackages = "multipledbproject.dbone.repository")
public class DbOneConfiguration {

    @Bean("dataSourceOne")
    @Primary
    @ConfigurationProperties(prefix = "db_one")
    public DataSource dataSourceOne() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "entityManagerFactoryOne")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryOne(EntityManagerFactoryBuilder entityManagerFactoryBuilder, @Qualifier("dataSourceOne") DataSource dataSource) {
        Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL81Dialect");
        return entityManagerFactoryBuilder
                .dataSource(dataSource)
                .packages("multipledbproject.dbone")
                .persistenceUnit("dbOne")
                .properties(properties)
                .build();
    }

    @Bean(name = "transactionManagerOne")
    @Primary
    public PlatformTransactionManager transactionManagerOne(@Qualifier("entityManagerFactoryOne") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
