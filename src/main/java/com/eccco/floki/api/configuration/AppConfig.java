package com.eccco.floki.api.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.eccco.floki.clients"})
public class AppConfig {
}
