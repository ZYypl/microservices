package com.ypl.micro;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@MapperScan(value = "com.ypl.micro.dao")
@EnableEurekaClient //注册进eureka
public class DeptProvider8002_APP {




    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:/mybatis/*/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }



    @Bean
    public DataSource dataSource() {
        PoolProperties p = new PoolProperties();
        p.setUrl("jdbc:mysql://localhost:3306/microservices1");
        p.setDriverClassName("org.gjt.mm.mysql.Driver");
        p.setUsername("root");
        p.setPassword("123");
        p.setTestWhileIdle(true);
        p.setTestOnBorrow(true);
        p.setTestOnReturn(false);
//        p.setValidationQuery("SELECT 1 FROM DUAL");
        p.setValidationInterval(30000);
        p.setMaxActive(100);
        p.setMinIdle(10);
        p.setMaxWait(10000);
        p.setInitialSize(10);
        p.setRemoveAbandonedTimeout(6000);
        p.setRemoveAbandoned(true);
        p.setLogAbandoned(true);
        p.setMinEvictableIdleTimeMillis(30000);
        p.setJmxEnabled(true);
        p.setFairQueue(true);
        p.setJdbcInterceptors(
                "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;" +
                        "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
        DataSource datasource = new org.apache.tomcat.jdbc.pool.DataSource(p);
        return datasource;
    }




    public static void main(String[] args) {
//        SpringApplication app = new SpringApplication(DeptProvider8002_APP.class);
//        app.setBannerMode(Banner.Mode.CONSOLE);
//        AppCtx.ctx = app.run(args);

		SpringApplication.run(DeptProvider8002_APP.class, args);
    }
}
