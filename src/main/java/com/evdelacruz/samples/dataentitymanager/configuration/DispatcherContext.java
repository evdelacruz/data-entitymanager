package com.evdelacruz.samples.dataentitymanager.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan("com.evdelacruz.samples.dataentitymanager.dist.rest")
public class DispatcherContext extends WebMvcConfigurerAdapter {
}
