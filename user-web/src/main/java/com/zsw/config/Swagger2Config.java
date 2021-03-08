package com.zsw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zsw
 * @date 2021/2/1 15:58
 * @description : swagger
 *
 * @Api：修饰整个类，描述Controller的作用
 * @ApiOperation：描述一个类的一个方法，或者说一个接口
 * @ApiParam：单个参数描述
 * @ApiModel：用对象来接收参数
 * @ApiProperty：用对象接收参数时，描述对象的一个字段
 * @ApiResponse：HTTP响应其中1个描述
 * @ApiResponses：HTTP响应整体描述
 * @ApiIgnore：使用该注解忽略这个API
 * @ApiError ：发生错误返回的信息
 * @ApiParamImplicitL：一个请求参数
 * @ApiParamsImplicit 多个请求参数
 */
@Configuration
@EnableSwagger2
//@ConditionalOnProperty(prefix = "swagger2",value = {"enabled"},havingValue = "true")
public class Swagger2Config extends WebMvcConfigurerAdapter{
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zsw.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                .description("springboot测试接口")
                .version("1.0")
                .title("Api测试文档").license("Apache2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .build());
    }
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("springboot利用swagger构建api文档")
//                .description("简单优雅的restfun风格，http://blog.csdn.net/forezp")
//                .termsOfServiceUrl("http://blog.csdn.net/forezp")
//                .version("1.0")
//                .build();
//    }

}
