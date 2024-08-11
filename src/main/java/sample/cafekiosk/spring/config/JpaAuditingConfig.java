package sample.cafekiosk.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// mockMvc 띄울 때 이거도 띄워야돼서 config 따로 관리
@EnableJpaAuditing
@Configuration
public class JpaAuditingConfig {
}
