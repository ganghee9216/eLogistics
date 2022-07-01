package com.ganghee.elogistics.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//WebMvcTest는 일반적인 @Configuration은 스캔하지 않는다.
@Configuration
//Auditing 활성화
@EnableJpaAuditing
public class JpaConfig {
}