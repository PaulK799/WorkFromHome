package com.paul.learning.wfh.config;

import com.paul.learning.wfh.SpringBoot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Configuration class for {@link SpringBoot}.
 */
@Configuration
public class WFHConfig {

    /**
     * Bean for initalizing {@link Docket} API.
     *
     * @return The {@link Docket} generated.
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .enable(true);
    }
}
