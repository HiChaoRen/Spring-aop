package com.hichaoren.config;

import org.springframework.context.annotation.*;

/**
 * Created by HiChaoRen on 2022-12-13.
 */
@Configuration
@ComponentScan("com.hichaoren")
@PropertySource("classpath:jdbc.properties")
@EnableAspectJAutoProxy
@Import({JdbcConfig.class, MybatisConfig.class})
public class SpringConfig {

}



