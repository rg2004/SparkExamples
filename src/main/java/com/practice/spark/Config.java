package com.practice.spark;

import org.apache.spark.SparkConf;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Config {
	
	
    @Value("${app.name}")
    private String appName;

    @Value("${master.uri}")
    private String masterUri;
    
    SparkConf sparkConf;
    
    @Bean
    public SparkConf sparkConf() {
        SparkConf sparkConf = new SparkConf()
                .setAppName(appName)
                .setMaster(masterUri);

        return sparkConf;
    }


}
