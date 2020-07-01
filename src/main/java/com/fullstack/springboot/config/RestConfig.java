package com.fullstack.springboot.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import com.fullstack.springboot.entity.Product;
import com.fullstack.springboot.entity.ProductCategory;

@Configuration
public class RestConfig implements RepositoryRestConfigurer {
	
	private EntityManager entityManager;

	@Autowired
	public RestConfig(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


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
		
		exposeIds(config);
		
	
	}


	private void exposeIds(RepositoryRestConfiguration config) {
		
		Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
		
		List<Class> Entityclasses = new ArrayList<>();
		
		for (EntityType entityclass : entities) {
			Entityclasses.add(entityclass.getJavaType());
		}
		
		Class[] domaintype = Entityclasses.toArray(new Class[0]);
		config.exposeIdsFor(domaintype);
		
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