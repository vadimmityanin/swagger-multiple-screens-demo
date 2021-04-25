package com.swaggertest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("external")
				.apiInfo(apiInfo())
				.select()
				.paths(postPaths())
				.build();
	}

	@Bean
	public Docket postsApi2() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("internal")
				.apiInfo(apiInfo2())
				.select()
				.paths(postPaths())
				.build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/api/posts.*"), regex("/api/swaggertest.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("swaggertest API")
				.description("swaggertest API reference for developers")
				.termsOfServiceUrl("http://swaggertest.com")
				.contact("swaggertest@gmail.com").license("swaggertest License")
				.licenseUrl("swaggertest@gmail.com").version("1.0").build();
	}

	private ApiInfo apiInfo2() {
		return new ApiInfoBuilder().title("Vadim")
				.description("TEst")
				.termsOfServiceUrl("http://testess.com")
				.contact("zz@gmail.com").license("swaggertest License")
				.licenseUrl("jazzzcxzainuse@gmail.com").version("1.0").build();
	}

}