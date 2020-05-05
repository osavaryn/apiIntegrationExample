package com.osavaryn.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.osavaryn.service"})
@PropertySource(value = {"classpath:app.properties"})
public class RootConfig {

}