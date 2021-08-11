package com.westone.lijingjing.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com/westone/lijingjing/dao")
public class MyBatisConfig {

}
