package com.wenyanwen123;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description: API文档
 * @Author liww
 * @Date 2019/4/3
 * @Version 1.0
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Value("${swagger.show}")
    private boolean swaggerShow;

    /**
     * @Desc 创建API应用
     *       apiInfo() 增加API相关信息
     *       通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     *       本例采用指定扫描的包路径来定义指定要建立API的目录。
     * @Author liww
     * @Date 2019/4/3
     * @Param []
     * @return springfox.documentation.spring.web.plugins.Docket
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerShow)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wenyanwen123"))
                .paths(PathSelectors.any())
                .build();
    }

   /**
    * @Desc 创建该API的基本信息（这些基本信息会展现在文档页面中）
    *       访问地址：http://项目实际地址/swagger-ui.html
    * @Author liww
    * @Date 2019/4/3
    * @Param []
    * @return springfox.documentation.service.ApiInfo
    */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("学习项目API文档")
                .description("")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }

}
