package demo.ans.webservice.database;

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
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * The Spring JPA Configuration for the Oracle database.
 */
 @Configuration
 @EnableTransactionManagement
 @EnableJpaRepositories(
		 entityManagerFactoryRef = DatabaseConfigConstant.ORACLE_ENTITY_MANAGER_FACTORY,
		 transactionManagerRef = DatabaseConfigConstant.ORACLE_TRANSACTION_MANAGER, 
		 basePackages = { "demo.ans.webservice.database.model.oracle" })
public class OracleDatabaseConfig {

	/**
	 * Initializes the data source.
	 *
	 * @return the initialized data source
	 */
	@Bean(name = DatabaseConfigConstant.ORACLE_DATA_SOURCE)
	@ConfigurationProperties(prefix = "oracle.datasource")
	public DataSource dataSource() {
					
		return DataSourceBuilder				
				.create()
				.build();						
		
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
	@Bean(name = DatabaseConfigConstant.ORACLE_ENTITY_MANAGER_FACTORY)
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier(DatabaseConfigConstant.ORACLE_DATA_SOURCE) DataSource dataSource) {
		return builder.dataSource(dataSource).packages("demo.ans.webservice.database.model.oracle").build();
	}

	/**
	 * Creates the transaction manager.
	 *
	 * @param entityManagerFactory
	 *            the entity manager factory
	 * @return the transaction manager
	 */
	@Bean(name = DatabaseConfigConstant.ORACLE_TRANSACTION_MANAGER)
	public PlatformTransactionManager transactionManager(
			@Qualifier(DatabaseConfigConstant.ORACLE_ENTITY_MANAGER_FACTORY) EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
	
	

}
