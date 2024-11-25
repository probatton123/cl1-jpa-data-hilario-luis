package pe.edu.i202222714.cl1_jpa_data_hilario_luis.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConexionesConfig {
    @Value("${DB_WORLD_URL}")
    private String bdWorldUrl;
    @Value("${DB_WORLD_USER}")
    private String bdWorldUser;
    @Value("${DB_WORLD_PASS}")
    private String bdWorldPass;
    @Value("${DB_WORLD_DRIVER}")
    private String bdWorldDriver;

    @Bean
    public HikariDataSource hikariDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(bdWorldUrl);
        config.setUsername(bdWorldUser);
        config.setPassword(bdWorldPass);
        config.setDriverClassName(bdWorldDriver);

        config.setMaximumPoolSize(30);
        config.setMinimumIdle(4);
        config.setIdleTimeout(240000);
        config.setConnectionTimeout(45000);

        return new HikariDataSource(config);
    }
}
