package com.fullstack.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import com.fullstack.springboot.entity.Product;
import com.fullstack.springboot.entity.ProductCategory;

@Configuration
public class RestConfig implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

		HttpMethod[] theUnsupportedAction = {HttpMethod.DELETE, HttpMethod.POST, HttpMethod.PUT};
		
		/**
		 * Disable method for Product Class: POST , PUT, DELETE
		 */
		config.getExposureConfiguration().forDomainType(Product.class)
		.withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedAction))
		.withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedAction));
		
		/**
		 * Disable method for ProductCategory Class: POST , PUT, DELETE
		 */
		config.getExposureConfiguration().forDomainType(ProductCategory.class)
		.withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedAction))
		.withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedAction));
		
		
	
	}

	
}
/**

config.getCorsRegistry()
.addMapping("/**")
  .allowedOrigins("http://localhost:3000")
  .allowedOrigins("*")
  .allowedMethods("HEAD", "OPTIONS", "GET", "POST", "PUT", "DELETE")
  .allowCredentials(false)
  .maxAge(3600);
 
 */