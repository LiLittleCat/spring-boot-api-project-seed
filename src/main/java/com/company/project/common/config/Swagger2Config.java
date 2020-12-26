package com.company.project.common.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Swagger 配置
 * </p>
 *
 * @author LiLittleCat
 */
@Configuration
@EnableSwagger2
public class Swagger2Config implements WebMvcConfigurer {

    @Value("${swagger.enable}")
    private Boolean swaggerEnable;

    @Bean(name = "swagger2")
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                // 设置只有使用了 @ApiOperation 注解才生产接口文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                .apis(RequestHandlerSelectors.basePackage("com.company.project"))
                // 路径使用 any 风格
                .paths(PathSelectors.any())
                .build()
                // 如何保护 api 文档：三种验证（ApiKey, BasicAuth, Oauth）
//                .securitySchemes(security())
                .apiInfo(apiInfo())
                .enable(swaggerEnable);
    }

    /**
     * 接口文档信息
     *
     * @return ApiInfo
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("测试系统")
                .description("测试系统API")
                .version("V0.0.1")
                .build();
    }

    private List<ApiKey> security() {
        ArrayList<ApiKey> apiKeys = new ArrayList<>();
        apiKeys.add(new ApiKey("token", "token", "header"));
        return apiKeys;
    }

    /**
     * 配置静态资源
     *
     * @param registry ResourceHandlerRegistry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
