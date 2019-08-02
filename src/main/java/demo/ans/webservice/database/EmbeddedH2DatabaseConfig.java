package demo.ans.webservice.database;

import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * The Spring JPA Configuration for the Embedded HSQL database.
 */
 @Configuration
 @EnableTransactionManagement
 @EnableJpaRepositories(
		 entityManagerFactoryRef = DatabaseConfigConstant.EMBEDDED_H2_ENTITY_MANAGER_FACTORY,
		 transactionManagerRef = DatabaseConfigConstant.EMBEDDED_H2_TRANSACTION_MANAGER, 
		 basePackages = { "demo.ans.webservice.database.model.h2" })
public class EmbeddedH2DatabaseConfig {

	/**
	 * Initializes the data source.
	 *
	 * @return the initialized data source
	 */
	@Primary
	@Bean(name = DatabaseConfigConstant.EMBEDDED_H2_DATA_SOURCE)
	@ConfigurationProperties(prefix = "h2.datasource")
	public DataSource dataSource() {
		
		// embedded H2 datasource EXAMPLE
		
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.H2)
				.addScript("db/data.sql")
				.build();
		
		return db;

//		DataSource db = DataSourceBuilder.create()
//                //.url("jdbc:h2:mem:thing:H2;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE")
//				.url("jdbc:h2:~/test;DB_CLOSE_ON_EXIT=FALSE")
//                .driverClassName("org.h2.Driver")
//                .username("sa")
//                .password("test")
//	    		.build();
		
//		DataSource db = DataSourceBuilder.create()
//                .url("jdbc:h2:mem:thing:H2;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE")
//                .driverClassName("org.h2.Driver")
//                .username("sa")
//                .password("")	 	    		
//	    		.build();		
		
		
//		return DataSourceBuilder				
//				.create()
//				.build();						
		
	}

	/**
	 * Creates the entity manager factory.
	 *
	 * @param builder
	 *            the entity manager factory builder
	 * @param dataSource
	 *            the data source
	 * @return the entity manager factory
	 */
	@Primary
	@Bean(name = DatabaseConfigConstant.EMBEDDED_H2_ENTITY_MANAGER_FACTORY)
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier(DatabaseConfigConstant.EMBEDDED_H2_DATA_SOURCE) DataSource dataSource) {
		return builder.dataSource(dataSource).packages("demo.ans.webservice.database.model.h2").build();
	}

	/**
	 * Creates the transaction manager.
	 *
	 * @param entityManagerFactory
	 *            the entity manager factory
	 * @return the transaction manager
	 */
	@Primary
	@Bean(name = DatabaseConfigConstant.EMBEDDED_H2_TRANSACTION_MANAGER)
	public PlatformTransactionManager transactionManager(
			@Qualifier(DatabaseConfigConstant.EMBEDDED_H2_ENTITY_MANAGER_FACTORY) EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
	
	
	// Start WebServer, access http://localhost:8082
	//@Bean(initMethod = "start", destroyMethod = "stop")
	//public Server startDBManager() throws SQLException {
	//	return Server.createWebServer();
	//}	
	

}
