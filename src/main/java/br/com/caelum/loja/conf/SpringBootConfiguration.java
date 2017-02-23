package br.com.caelum.loja.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by mauyr on 17/02/17.
 */
@SpringBootApplication
@EnableJpaRepositories("br.com.caelum.loja.domain.repository")
@EntityScan("br.com.caelum.loja.model")
public class SpringBootConfiguration extends SpringBootServletInitializer {

    private static final Logger log = LoggerFactory.getLogger(SpringBootConfiguration.class);

    private static final String defaultProfile = "dev";

    public static void main (String[] args) throws Exception {
        SpringApplication.run(SpringBootConfiguration.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.profiles(addDefaultProfile());
    }

    /**
     * Set a default profile if it has not been set.
     * <p/>
     * <p>
     * Please use -Dspring.profiles.active=dev
     * </p>
     */
    private String addDefaultProfile() {
        String profile = System.getProperty("spring.profiles.active");
        if (profile != null) {
            log.info("####################################################################");
            log.info("");
            log.info("Running with Spring profile(s) : {}", profile);
            log.info("");
            log.info("####################################################################");
            return profile;
        }

        log.warn("!!! No Spring profile configured, running with default configuration: " + defaultProfile);
        return defaultProfile;
    }
}
