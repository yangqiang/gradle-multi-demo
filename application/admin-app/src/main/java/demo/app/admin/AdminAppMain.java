package demo.app.admin;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@SpringBootApplication
@EnableScheduling
@EnableAsync
@ComponentScan("demo.feature.admin")
@MapperScan(basePackages = "demo.**.mapper")
@EnableTransactionManagement
@EnableConfigurationProperties
public class AdminAppMain {
    public static void main(String[] args) {
        SpringApplication.run(AdminAppMain.class, args);
    }
}
