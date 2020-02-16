package org.dpow.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBootApplication is a combo of the following:
 *  Configuration - Java component configuration with beans using vanilla Spring framework, e.g. `@Bean` or `@Controller`.
 *  ComponentScan - Specifies the packages to scan for @Configuration to recognize; searches current package
 *      and all subpackages, so best to put this main driver file in module root classpath.
 *  EnableAutoConfiguration - Allows SpringBoot to create many beans and configure the application automatically
 *      based on the resolved classpath; also allows for selective include/exclude/etc. fields.
 */
@SpringBootApplication
public class ApplicationDriver {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationDriver.class, args);
    }
}
