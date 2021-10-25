package com.sherlockmen.newcoderBlog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.print.SimpleDoc;
import java.text.SimpleDateFormat;
import java.util.logging.SimpleFormatter;

@Configuration
public class AlphaConfig {

    @Bean
    public SimpleDateFormat simpleDateFormat(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

}
