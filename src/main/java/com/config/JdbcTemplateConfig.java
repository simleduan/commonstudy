package com.config;import org.springframework.beans.factory.annotation.Qualifier;import org.springframework.context.annotation.Bean;import org.springframework.context.annotation.Configuration;import org.springframework.context.annotation.Primary;import org.springframework.jdbc.core.JdbcTemplate;import javax.sql.DataSource;@Configurationpublic class JdbcTemplateConfig {    @Primary    @Bean("taiKangJdbc")    public JdbcTemplate taiKangJdbc(@Qualifier("taikangDateSource")DataSource dataSource){        return new JdbcTemplate(dataSource);    }    @Bean("mpJdbc")    public JdbcTemplate mpJdbc(@Qualifier("mpDataSource")DataSource dataSource){        return new JdbcTemplate(dataSource);    }}