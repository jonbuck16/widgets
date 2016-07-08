package com.example.widgets.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@PropertySource("classpath:config/documentation.properties")
public class Documentation {

	@Value("${api.version}")
	private String apiVersion;

	@Value("${api.description}")
	private String description;

	@Value("${api.license}")
	private String license;

	@Value("${api.license.url}")
	private String licenseURL;

	@Value("${api.title}")
	private String title;

	/**
	 * 
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(title).description(description).license(license).licenseUrl(licenseURL)
				.version(apiVersion).build();
	}

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Predicate<String> paths() {
		return or(regex("/widgets.*"));
	}

	/**
	 * 
	 * @return
	 */
	private Tag primaryTag() {
		Tag tag = new Tag("Widgets", "Control your widgets");
		return tag;
	}

	/**
	 * Creates a new documentation docket containing the reuired API data.
	 * 
	 * @return Docket the docket configured for the application
	 */
	@Bean
	public Docket swaggerConfig() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2).tags(primaryTag()).apiInfo(apiInfo()).select()
				.paths(paths()).build();
		docket.useDefaultResponseMessages(false);
		return docket;
	}

}
