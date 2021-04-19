package com.lot.equipment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 项目启动类
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.lot.equipment.dao"})
@ComponentScan({"com.lot"})
public class EquipmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(EquipmentApplication.class, args);
    }
}
