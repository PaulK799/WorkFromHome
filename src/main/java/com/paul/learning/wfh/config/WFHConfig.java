package com.paul.learning.wfh.config;

import com.paul.learning.wfh.WorkFromHome;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for {@link WorkFromHome}.
 */
@Configuration
@EnableAutoConfiguration
@RefreshScope
public class WFHConfig {

    @Value("${wfh.sort.default:4567}")
    private String sortDefault;

    /**
     * Getter to retrieve the SortDefault paramter.
     *
     * @return The configured SortDefault.
     */
    public String getSortDefault() {
        return sortDefault;
    }
}
