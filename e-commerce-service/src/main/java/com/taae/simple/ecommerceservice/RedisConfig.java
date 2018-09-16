package com.taae.simple.ecommerceservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
@EnableCaching
//@PropertySource("classpath:redis.properties")
public class RedisConfig {
   @Autowired
   private YMLConfig config;		
	
   @Bean
   public LettuceConnectionFactory redisConnectionFactory() {
	    RedisStandaloneConfiguration redisConf = new RedisStandaloneConfiguration();
	    redisConf.setHostName(config.getRedisHost());
	    redisConf.setPort(Integer.parseInt(config.getRedisPort()));
	    redisConf.setPassword(RedisPassword.of(config.getRedisPassword()));	    
        return new LettuceConnectionFactory(redisConf);
   }
   @Bean
   public RedisCacheManager cacheManager() {
	    RedisCacheManager rcm = RedisCacheManager.create(redisConnectionFactory());
	    rcm.setTransactionAware(true);
   	    return rcm;
   }  
}
