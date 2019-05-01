# spring-boot-multi-datasource

An example project showing how to configure more than one (multiple) datasource in spring boot to work with spring-data-jpa.  

Separate `@Configuration` files are created for each datasource (customer, product).  In-memory hsqldb and h2 databases are used in the example, but this setup can be used for any database.

The customer datasource is annotated with `@Primary`, thus will be the default autowired datasource if no `@Qualifier` is specified.  

This example does NOT use JTA transaction manager.   Separate `EntityManagerFactoryBean` and `PlatformTransactionManager` are created for each datasource.

`@Transaction` annotation for non primary datasource should be specified with the `transactionManager` attribute.  

## Running the application

From eclipse you can simply right click on `Application.java` and run as java application.  

Then navigate to http://localhost:8080.  Here a simple page shows the list of customers and products retrieved from the separate datasources





