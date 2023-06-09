package com.training.hplusspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages = "com.training.hplusspringboot")
public class ApplicationConfiguration extends WebMvcConfigurationSupport {

    /*make sure that the static resources are mapped correctly
     using addResourceHandlers api*/

    /*the project structure that you're looking at on the left side of IDE
    is going to be a little different from the structure that actually gets
    generated in the war package. So we need to tell springframework that when
    the war is created, you need to pick up the css and images from the
    appropriate parts. That's what this method is going to help us do*/
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("css/**", "images/**")
                .addResourceLocations("classpath:/static/css/", "classpath:/static/images/");
    }

    /*define the jspViewResolver so that the jsp
     templates are picked up from the correct folders.*/
    @Bean
    public InternalResourceViewResolver jspViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);

        return viewResolver;
    }
}
