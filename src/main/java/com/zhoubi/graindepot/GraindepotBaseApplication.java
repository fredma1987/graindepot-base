package com.zhoubi.graindepot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.session.data.redis.RedisFlushMode;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableRedisHttpSession(redisFlushMode = RedisFlushMode.IMMEDIATE)
public class GraindepotBaseApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(GraindepotBaseApplication.class, args);
	}

}

