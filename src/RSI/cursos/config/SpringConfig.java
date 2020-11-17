package RSI.cursos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@EnableJpaRepositories(basePackages ="RSI.cursos.repository", entityManagerFactoryRef = "factory", transactionManagerRef = "txtManager")
@ComponentScan(basePackages = {"RSI.cursos.repository", "RSI.cursos.service"})
@Configuration
public class SpringConfig {
	@Bean
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource data=new DriverManagerDataSource();
		data.setDriverClassName("com.mysql.cj.jdbc.Driver");
		data.setUrl("jdbc:mysql://localhost:6033/TestSpring?serverTimezone=UTC");
		data.setUsername("root");
		data.setPassword("my_secret_password");
		return data;
	}
	
	@Bean
	public HibernateJpaVendorAdapter adapter() {
		HibernateJpaVendorAdapter adp=new HibernateJpaVendorAdapter();
		adp.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		return adp;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean factory() {
		LocalContainerEntityManagerFactoryBean factory= new LocalContainerEntityManagerFactoryBean();
		factory.setPersistenceUnitName("contactosPU");
		factory.setDataSource(getDataSource());
		factory.setPackagesToScan("RSI.cursos.model");
		factory.setJpaVendorAdapter(adapter());
		return factory;
	}
	
	@Bean
	public JpaTransactionManager txtManager() {
		JpaTransactionManager manager=new JpaTransactionManager();
		manager.setEntityManagerFactory(factory().getObject());
		return manager;
	}
}
