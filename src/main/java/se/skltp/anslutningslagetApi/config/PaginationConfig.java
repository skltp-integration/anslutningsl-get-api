package se.skltp.anslutningslagetApi.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.config.SpringDataWebConfiguration;

@Configuration
@EnableConfigurationProperties
public class PaginationConfig extends SpringDataWebConfiguration {

    @Bean
    public PageableHandlerMethodArgumentResolver pageableResolver() {
        PageableHandlerMethodArgumentResolver pageableHandlerMethodArgumentResolver =
                new PageableHandlerMethodArgumentResolver(sortResolver());

        pageableHandlerMethodArgumentResolver.setMaxPageSize(Integer.MAX_VALUE);

        return pageableHandlerMethodArgumentResolver;
    }

}

