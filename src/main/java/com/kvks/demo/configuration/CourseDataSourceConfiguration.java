package com.kvks.demo.configuration;

import com.kvks.demo.model.Course.Course;
import com.kvks.demo.model.Student.Student;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.kvks.demo.repository.Course",
        entityManagerFactoryRef = "courseEntityManagerFactory",
        transactionManagerRef= "courseTransactionManager")
public class CourseDataSourceConfiguration {

    @Bean
    @ConfigurationProperties("spring.cm-datasource")
    public DataSourceProperties courseDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.cm-datasource.configuration")
    public DataSource courseDataSource() {
        return courseDataSourceProperties().initializeDataSourceBuilder()
                .type(BasicDataSource.class).build();
    }

    @Bean(name = "courseEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean courseEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(courseDataSource())
                .packages(Course.class)
                .build();
    }

    @Bean
    public PlatformTransactionManager courseTransactionManager(
            final @Qualifier("courseEntityManagerFactory") LocalContainerEntityManagerFactoryBean courseEntityManagerFactory) {
        return new JpaTransactionManager(courseEntityManagerFactory.getObject());
    }
}