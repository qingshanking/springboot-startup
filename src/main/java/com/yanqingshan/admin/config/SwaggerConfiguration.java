package com.yanqingshan.admin.config;

import cn.hutool.core.lang.Assert;
import cn.hutool.extra.spring.SpringUtil;
import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.service.Parameter;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname SwaggerConfiguration
 * @Description knife4j Swagger 配置
 * @Version 1.0.0
 * @Date 2023/5/5 21:20
 * @Created by yanqs
 */
@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfiguration {
    private final OpenApiExtensionResolver openApiExtensionResolver;

    @Autowired
    public SwaggerConfiguration(OpenApiExtensionResolver openApiExtensionResolver) {
        this.openApiExtensionResolver = openApiExtensionResolver;
    }

    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        String groupName = "后端接口";
        String serverPort = SpringUtil.getProperty("server.port");
        Assert.notEmpty(serverPort, "配置项({}) 不能为空", "server.port");
        List<Parameter> pars = new ArrayList<>();
        // header中的ticket参数非必填，传空也可以
        ParameterBuilder ticketPar = new ParameterBuilder();
        ticketPar.name("Authorization").description("Authorization").modelRef(new ModelRef("string")).parameterType("header").required(true).build();
        //Sign
        //ParameterBuilder signTickPar = new ParameterBuilder();
        //signTickPar.name("sign").description("sign").modelRef(new ModelRef("string")).parameterType("header").required(true).build();

        //Timestamp
        //ParameterBuilder timesTickPar = new ParameterBuilder();
        //timesTickPar.name("timestamp").description("timestamp").modelRef(new ModelRef("string")).parameterType("header").required(true).build();
        pars.add(ticketPar.build());
        //pars.add(signTickPar.build());
        //pars.add(timesTickPar.build());


        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .host("http://127.0.0.1:" + serverPort + "/doc.html")
                .apiInfo(apiInfo())
                .groupName(groupName)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yanqingshan.admin.module"))
                .paths(PathSelectors.any())
                .build()
                .extensions(openApiExtensionResolver.buildExtensions(groupName))
                .globalOperationParameters(pars);;
        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot Startup RESTful APIs")
                .description("# SpringBoot Startup RESTful APIs")
                .termsOfServiceUrl("http://www.yanqingshan.com/")
                .contact("i@yanqingshan.com")
                .version("1.0")
                .build();
    }
}
