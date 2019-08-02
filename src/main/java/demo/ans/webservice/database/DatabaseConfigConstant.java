package demo.ans.webservice.database;

/**
 * The constants for database configuration classes.
 *
 */
public interface DatabaseConfigConstant {

	/** Embedded HSQL data source bean. */
	public static final String EMBEDDED_HSQL_DATA_SOURCE = "eHSQLDataSource";

	/** Embedded HSQL transaction manager bean. */
	public static final String EMBEDDED_HSQL_TRANSACTION_MANAGER = "eHSQLTransactionManager";

	/** Embedded HSQL entity manager factory bean. */
	public static final String EMBEDDED_HSQL_ENTITY_MANAGER_FACTORY = "eHSQLEntityManagerFactory";
	

	
	/** Embedded H2 data source bean. */
	public static final String EMBEDDED_H2_DATA_SOURCE = "eH2DataSource";

	/** Embedded H2 transaction manager bean. */
	public static final String EMBEDDED_H2_TRANSACTION_MANAGER = "eH2TransactionManager";

	/** Embedded H2 entity manager factory bean. */
	public static final String EMBEDDED_H2_ENTITY_MANAGER_FACTORY = "eH2EntityManagerFactory";
	
	
	/** ORACLE data source bean. */
	public static final String ORACLE_DATA_SOURCE = "oracleDataSource";

	/** ORACLE transaction manager bean. */
	public static final String ORACLE_TRANSACTION_MANAGER = "oracleTransactionManager";

	/** ORACLE entity manager factory bean. */
	public static final String ORACLE_ENTITY_MANAGER_FACTORY = "oracleEntityManagerFactory";
	


}
