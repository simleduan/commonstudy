package com.sime.configinfo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "study.like")
@Configuration
@Data
public class ConfigInfoProper{
    private String language;
    private String girl;
    private String eat;
}
