package com.trang.TrangWebYTe.Config.Db;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.trang.TrangWebYTe.Config.AES;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class ConfigDb {
	 @Value("${db.datasource.driver-class-name}")
	    private String driverClass;
	@Value("${db.datasource.url}")
 private String url;

 @Value("${db.datasource.username}")
 private String user;

 @Value("${db.datasource.password}")
 private String password;

private String secrectkey="Abc@123";

 @Bean(name = "dataSource")
 public DataSource dataSource() {
     HikariConfig dataSource = new HikariConfig();
     dataSource.setDriverClassName(driverClass);
     dataSource.setJdbcUrl(AES.decrypt(url, secrectkey));
     dataSource.setUsername(AES.decrypt(user, secrectkey));
     dataSource.setPassword(AES.decrypt(password, secrectkey));
     HikariDataSource hikariDataSource= new HikariDataSource(dataSource);
     return (DataSource) hikariDataSource;
 }

 @Bean(name = "transactionManager")
 public DataSourceTransactionManager dataSourceTransactionManager() {
     return new DataSourceTransactionManager(dataSource());
 }

 @Bean(name = "sqlSessionFactory")
 	public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
     final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
     sessionFactory.setDataSource(dataSource);

              /*Set the mapper file location*/
     sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
             .getResources("classpath:/com/trang/TrangWebYTe/Mapper/SQL/*.xml"));
//
//              /*Set entity class mapping rules: Underscore -> Hump*/
//     org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
//     configuration.setMapUnderscoreToCamelCase(true);
//     sessionFactory.setConfiguration(configuration);
     return sessionFactory.getObject();
 }
}
