package com.taae.simple.ecommerceservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YMLConfig {

	private String redisHost;
	private String redisPort;
	private String redisPassword;
	
	private String databaseDriverClassName;
	private String databaseUrl;
	private String databaseUser;
	private String databasePassword;
	
	private String hibernateDialect;
	private String hibernateShowSql;
	private String hibernateFormatSql;
	private String hibernateIdNewGenerator;
	
	public String getRedisHost() {
		return redisHost;
	}
	public void setRedisHost(String redisHost) {
		this.redisHost = redisHost;
	}
	public String getRedisPort() {
		return redisPort;
	}
	public void setRedisPort(String redisPort) {
		this.redisPort = redisPort;
	}
	public String getRedisPassword() {
		return redisPassword;
	}
	public void setRedisPassword(String redisPassword) {
		this.redisPassword = redisPassword;
	}
	public String getDatabaseDriverClassName() {
		return databaseDriverClassName;
	}
	public void setDatabaseDriverClassName(String databaseDriverClassName) {
		this.databaseDriverClassName = databaseDriverClassName;
	}
	public String getDatabaseUrl() {
		return databaseUrl;
	}
	public void setDatabaseUrl(String databaseUrl) {
		this.databaseUrl = databaseUrl;
	}
	public String getDatabaseUser() {
		return databaseUser;
	}
	public void setDatabaseUser(String databaseUser) {
		this.databaseUser = databaseUser;
	}
	public String getDatabasePassword() {
		return databasePassword;
	}
	public void setDatabasePassword(String databasePassword) {
		this.databasePassword = databasePassword;
	}
	public String getHibernateDialect() {
		return hibernateDialect;
	}
	public void setHibernateDialect(String hibernateDialect) {
		this.hibernateDialect = hibernateDialect;
	}
	public String getHibernateShowSql() {
		return hibernateShowSql;
	}
	public void setHibernateShowSql(String hibernateShowSql) {
		this.hibernateShowSql = hibernateShowSql;
	}
	public String getHibernateFormatSql() {
		return hibernateFormatSql;
	}
	public void setHibernateFormatSql(String hibernateFormatSql) {
		this.hibernateFormatSql = hibernateFormatSql;
	}
	public String getHibernateIdNewGenerator() {
		return hibernateIdNewGenerator;
	}
	public void setHibernateIdNewGenerator(String hibernateIdNewGenerator) {
		this.hibernateIdNewGenerator = hibernateIdNewGenerator;
	}
	
	
}
